package com.applause.carbonite.auto.pageframework.chunks;

import org.apache.log4j.Logger;

import com.applause.auto.framework.pageframework.device.AbstractDeviceView;
import com.applause.auto.framework.pageframework.devicecontrols.Button;
import com.applause.auto.framework.pageframework.devicecontrols.Text;
import com.applause.auto.framework.pageframework.util.environment.LocatorKeyNotFoundException;
import com.applause.carbonite.auto.pageframework.views.CarboniteDeviceBackupAndArchiveView;

/**
 * Represents a device check on the DeviceBackupAndAchivesView.
 */
public class CarboniteBackUpAndProtectChunk extends AbstractDeviceView {
	private Logger logger = Logger
			.getLogger(CarboniteBackUpAndProtectChunk.class);

	private Button backUpButton;
	private Text deviceTitle;
	private Button archiveButton;

	private String index = "";

	public CarboniteBackUpAndProtectChunk(String index) {
		this.index = index;
		/*syncHelper.waitForElementToAppear(getBackUpButton());*/
		syncHelper.waitForElementToAppear(getDeviceTitle());
		logger.info("Created Backup and Archive Chunk with titla : "
				+ getDeviceTitle().getStringValue());
	}

	/**
	 * Clicks the backup button and returns a Backup View for a device
	 * 
	 * @return
	 */
	public CarboniteDeviceBackupAndArchiveView tapBackUpButton() {
		logger.info("Clicking on backup button.");
		getDeviceTitle().tap();
		return new CarboniteDeviceBackupAndArchiveView();
	}

	/**
	 * @return the backUpButton
	 */
	public Button getBackUpButton() {
		try {
			backUpButton = new Button(String.format(env
					.getLocatorByName("BACKUP_PROTECTION_CHUNK_BACKUP_BUTTON"),
					index));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return backUpButton;
	}

	/**
	 * @return the deviceTitle
	 */
	public Text getDeviceTitle() {
		try {
			deviceTitle = new Text(String.format(
					env.getLocatorByName("BACKUP_PROTECTION_CHUNK_DEVICE_TITLE"),
					index));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return deviceTitle;
	}

	/**
	 * @return the archiveButton
	 */
	public Button getArchiveButton() {
		try {
			archiveButton = new Button(
					String.format(
							env.getLocatorByName("BACKUP_ARCHIVE_CHUNK_ARCHIVE_BUTTON"),
							index));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return archiveButton;
	}

}
