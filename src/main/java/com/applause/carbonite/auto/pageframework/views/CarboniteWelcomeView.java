package com.applause.carbonite.auto.pageframework.views;

import org.apache.log4j.Logger;

import com.applause.auto.framework.pageframework.device.AbstractDeviceView;
import com.applause.auto.framework.pageframework.devicecontrols.Button;
import com.applause.auto.framework.pageframework.devicecontrols.Checkbox;
import com.applause.auto.framework.pageframework.util.environment.LocatorKeyNotFoundException;

/**
 * Class represents a Welcome View
 */
public class CarboniteWelcomeView extends CarboniteAbstractView {
	private Logger logger = Logger.getLogger(CarboniteWelcomeView.class);

	private Checkbox protectDeviceCheckbox;
	private Checkbox backupDeviceCheckbox;
	private Button okButton;

	/**
	 * Create a welcome view
	 */
	public CarboniteWelcomeView() {
		syncHelper.waitForElementToAppear(getOkButton());
		syncHelper.waitForElementToAppear(getProtectDeviceCheckbox());
		snapshotManager.takeRemoteDeviceSnapShot("Welcome_View_", driver);
		logger.info("Created Welcome View.");
	}

	/**
	 * Tap on the Ok button
	 * 
	 * @return CarboniteYoureReadyView
	 */
	public CarboniteYoureReadyView tapOk() {
		logger.info("On Welcome View, tapping OK and directing to You're Ready View.");
		getOkButton().tap();
		
		return new CarboniteYoureReadyView();
	}

	/**
	 * @return the protectDeviceCheckbox
	 */
	public Checkbox getProtectDeviceCheckbox() {
		try {
			protectDeviceCheckbox = new Checkbox(
					env.getLocatorByName("WELCOME_VIEW_PROTECT_CHECK_BOX"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return protectDeviceCheckbox;
	}

	/**
	 * @return the okButton
	 */
	public Button getOkButton() {
		try {
			okButton = new Button(
					env.getLocatorByName("WELCOME_VIEW_OK_BUTTON"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return okButton;
	}

	/**
	 * @return the backupDeviceCheckbox
	 */
	public Checkbox getBackupDeviceCheckbox() {
		try {
			backupDeviceCheckbox = new Checkbox(
					env.getLocatorByName("WELCOME_VIEW_BACKUP_CHECK_BOX"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return backupDeviceCheckbox;
	}
}
