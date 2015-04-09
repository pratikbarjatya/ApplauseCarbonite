package com.applause.carbonite.auto.pageframework.chunks;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.applause.auto.framework.pageframework.device.AbstractDeviceView;
import com.applause.auto.framework.pageframework.devicecontrols.Link;
import com.applause.auto.framework.pageframework.devicecontrols.Text;
import com.applause.auto.framework.pageframework.util.environment.LocatorKeyNotFoundException;
import com.applause.carbonite.auto.pageframework.views.CarboniteAbstractView;
import com.applause.carbonite.auto.pageframework.views.CarboniteHelpView;
import com.applause.carbonite.auto.pageframework.views.CarboniteSettingsView;

/**
 * Class represents the Options Menu exposed by clicking the three dots on the
 * top bar.
 *
 */
public class CarboniteOptionsMenu extends AbstractDeviceView {
	private Logger logger = Logger.getLogger(CarboniteOptionsMenu.class);

	private Link logOutLink;
	private Link savedFilesLink;
	private Link settingsLink;
	private Link helpLink;

	/**
	 * Create a Option Menu
	 */
	public CarboniteOptionsMenu() {
		super();
		syncHelper.waitForElementToAppear(getHelpLink());
		syncHelper.waitForElementToAppear(getSavedFilesLink());
		snapshotManager.takeRemoteDeviceSnapShot("Options_Menu_", driver);
		logger.info("Created Options Menu.");
	}

	/**
	 * @return the logOutLink
	 */
	public Link getLogOutLink() {
		try {
			logOutLink = new Link(
					env.getLocatorByName("OPTIONS_MENU_LOG_OUT_LINK"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return logOutLink;
	}

	/**
	 * @return the savedFilesLink
	 */
	public Link getSavedFilesLink() {
		try {
			savedFilesLink = new Link(
					env.getLocatorByName("OPTIONS_MENU_SAVED_FILES_LINK"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}

		return savedFilesLink;
	}

	/**
	 * @return the settingsLink
	 */
	public Link getSettingsLink() {
		try {
			settingsLink = new Link(
					env.getLocatorByName("OPTIONS_MENU_SETTINGS_LINK"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return settingsLink;
	}

	/**
	 * @return the helpLink
	 */
	public Link getHelpLink() {
		try {
			helpLink = new Link(env.getLocatorByName("OPTIONS_MENU_HELP_LINK"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return helpLink;
	}

	/**
	 * @return the CarboniteSettingsView
	 */
	public CarboniteSettingsView tapSettingsLink() {
		getSettingsLink().tap();
		return new CarboniteSettingsView();
	}

	public int getAvailableOptionsCount() {
		int result = 0;
		try {
			result = queryHelper.getAndroidElementCount(env
					.getLocatorByName("OPTIONS_MENU_GENERAL"));
		} catch (LocatorKeyNotFoundException e) {
			logger.error("Expception thrown when locating element.");
			e.printStackTrace();
		}
		return result;
	}

	public List<String> getAvailableOptions() {
		List<String> result = new ArrayList<String>();

		int availableOptionsCount = getAvailableOptionsCount();

		for (int i = 0; i < availableOptionsCount; i++) {
			try {
				Text status = new Text(String.format(
						env.getLocatorByName("OPTIONS_MENU_OPTION_TITLE"), i));
				result.add(status.getStringValue());
			} catch (LocatorKeyNotFoundException e) {
				logger.error("Expception thrown when locating element.");
				e.printStackTrace();
			}
		}

		return result;
	}

	public CarboniteHelpView tapHelpLink() {
		getHelpLink().tap();
		return new CarboniteHelpView();
	}

}
