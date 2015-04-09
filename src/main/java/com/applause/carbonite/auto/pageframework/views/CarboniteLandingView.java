package com.applause.carbonite.auto.pageframework.views;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.applause.auto.framework.pageframework.devicecontrols.Button;
import com.applause.auto.framework.pageframework.devicecontrols.Text;
import com.applause.auto.framework.pageframework.util.Constants;
import com.applause.auto.framework.pageframework.util.environment.LocatorKeyNotFoundException;

public class CarboniteLandingView extends
		CarboniteAbstractView<CarboniteLandingView> {
	private Logger logger = Logger.getLogger(CarboniteLandingView.class);
	private Button addComputerBackupButton;
	private Button settingsButton;

	/**
	 * Create Carbonite device landing view
	 */
	public CarboniteLandingView() {
		super();
		if (env.getIsMobileIOS()) {
			// sync on settings button
			syncHelper.waitForElementToAppear(getSettingsButton());
		} else {
			// in android device - sync on add computer backup button
			syncHelper.waitForElementToAppear(getAddComputerBackupButton());

		}
		snapshotManager.takeRemoteDeviceSnapShot("Landing_View_", driver);
		logger.info("Created Landing View.");
	}

	/**
	 * @return device count on landing page
	 * @throws LocatorKeyNotFoundException
	 */
	public int getRegisteredDeviceCount() throws LocatorKeyNotFoundException {
		if (env.getIsMobileIOS()) {
			int count = queryHelper.getMobileElementCount(env
					.getLocatorByName("LANDING_VIEW_BACKUP_BUTTON"));
			int loopCount = 0;
			while ((count == 0) || (loopCount > 20)) {
				syncHelper.suspend(Constants.Waits.MEDIUM_WAIT_MILI);
				count = queryHelper.getMobileElementCount(env
						.getLocatorByName("LANDING_VIEW_BACKUP_BUTTON"));
				loopCount++;
			}
			return count;
		}
		// if not iOS, must be Android
		return queryHelper.getAndroidElementCount(env
				.getLocatorByName("LANDING_VIEW_DEVICE_ICON"));
	}

	/**
	 * Get the index of the device c
	 * 
	 * @param title
	 * @return
	 */
	public int getIndexOfBackupAndProtectChunkWithTitle(String title) {
		try {
			int visibleCount = queryHelper.getAndroidElementCount(env
					.getLocatorByName("BACKUP_PROTECTION_CHUNK_GENERAL"));
			for (int i = 0; i < visibleCount; i++) {
				Text deviceTitle = new Text(
						String.format(
								env.getLocatorByName("BACKUP_PROTECTION_CHUNK_DEVICE_TITLE"),
								i));

				logger.info(String.format("Compared [%s] to [%s]",
						deviceTitle.getStringValue(), title));

				if (deviceTitle.getStringValue().equals(title)) {
					return i;
				}
			}
		} catch (LocatorKeyNotFoundException e) {
			logger.error("Expception thrown when locating element.");
			e.printStackTrace();
		}

		return -1;
	}

	/**
	 * @return the addComputerBackupButton
	 */
	public Button getAddComputerBackupButton() {
		try {
			addComputerBackupButton = new Button(
					env.getLocatorByName("LANDING_VIEW_ADD_COMPUTER_BACKUP_BUTTON"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return addComputerBackupButton;
	}

	/**
	 * @return the settingsButton
	 */
	public Button getSettingsButton() {
		try {
			settingsButton = new Button(
					env.getLocatorByName("LANDING_VIEW_SETTINGS_BUTTON"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return settingsButton;
	}

	public int getAvailableDevicesCount() {
		int result = 0;
		try {
			result = queryHelper.getAndroidElementCount(env
					.getLocatorByName("BACKUP_PROTECTION_CHUNK_GENERAL"));
		} catch (LocatorKeyNotFoundException e) {
			logger.error("Expception thrown when locating element.");
			e.printStackTrace();
		}
		return result;
	}

	public List<String> getAllDevicesStatus() {
		List<String> result = new ArrayList<String>();

		int availableDeviceCount = getAvailableDevicesCount();

		for (int i = 1; i < availableDeviceCount - 1; i++) {
			try {
				Text status = new Text(
						String.format(
								env.getLocatorByName("BACKUP_PROTECTION_CHUNK_DEVICE_STATUS"),
								i));
				result.add(status.getStringValue());
			} catch (LocatorKeyNotFoundException e) {
				logger.error("Expception thrown when locating element.");
				e.printStackTrace();
			}
		}

		return result;
	}

	public CarboniteUsersComputerView tapDeviceWithTitle(String title) {
		try {
			int visibleCount = queryHelper.getAndroidElementCount(env
					.getLocatorByName("BACKUP_PROTECTION_CHUNK_GENERAL"));
			for (int i = 1; i < visibleCount - 1; i++) {
				Text deviceTitle = new Text(
						String.format(
								env.getLocatorByName("BACKUP_PROTECTION_CHUNK_DEVICE_TITLE"),
								i));
				if (deviceTitle.getStringValue().equals(title)) {
					new Button(
							String.format(
									env.getLocatorByName("BACKUP_PROTECTION_CHUNK_DEVICE"),
									i)).tap();
					return new CarboniteUsersComputerView();
				}
			}
			throw new LocatorKeyNotFoundException(
					"Backup and protection chunk with title not found");
		} catch (LocatorKeyNotFoundException e) {
			logger.error("Expception thrown when locating element.");
			e.printStackTrace();
		}

		return new CarboniteUsersComputerView();
	}
}
