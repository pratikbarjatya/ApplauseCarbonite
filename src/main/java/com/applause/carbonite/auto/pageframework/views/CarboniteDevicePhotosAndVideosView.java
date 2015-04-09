package com.applause.carbonite.auto.pageframework.views;

import org.apache.log4j.Logger;

import com.applause.auto.framework.pageframework.device.AbstractDeviceView;
import com.applause.auto.framework.pageframework.devicecontrols.Button;
import com.applause.auto.framework.pageframework.util.environment.LocatorKeyNotFoundException;
import com.applause.carbonite.auto.pageframework.chunks.CarboniteOptionsMenu;

public class CarboniteDevicePhotosAndVideosView extends CarboniteAbstractView {
	private Logger logger = Logger
			.getLogger(CarboniteDevicePhotosAndVideosView.class);

	private Button switchViewButton;
	private Button launchOptionsMenuButton;

	/**
	 * Create device photos and videos view
	 */
	public CarboniteDevicePhotosAndVideosView() {
		super();
		syncHelper.waitForElementToAppear(getSwitchViewButton());
//		syncHelper.waitForElementToAppear(getOptionsMenuButton());
		snapshotManager.takeRemoteDeviceSnapShot("Device_Photos_and_Videos_",
				driver);
		logger.info("Created a Device Photos and Videos View.");
	}

	/**
	 * Click the Show Options Button
	 * 
	 * @return CarboniteOptionsMenu object
	 */
	public CarboniteOptionsMenu clickShowOptionsButton() {
		logger.info("On Login Page, clicking Show Options Menu Button.");
		getOptionsMenuButton().tap();
		return new CarboniteOptionsMenu();
	}

	/**
	 * @return Show Options Menu Button
	 */
	public Button getOptionsMenuButton() {
		try {
			launchOptionsMenuButton = new Button(
					env.getLocatorByName("DEVICE_PHOTOS_AND_VIDEO_VIEW_SHOW_OPTIONS_BUTTON"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return launchOptionsMenuButton;
	}

	/**
	 * @return the switchViewButton
	 */
	public Button getSwitchViewButton() {
		try {
			switchViewButton = new Button(
					env.getLocatorByName("DEVICE_PHOTOS_AND_VIDEO_VIEW_SWITCH_VIEW_BUTTON"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return switchViewButton;
	}
}
