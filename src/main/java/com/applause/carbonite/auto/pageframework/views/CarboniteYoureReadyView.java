package com.applause.carbonite.auto.pageframework.views;

import org.apache.log4j.Logger;

import com.applause.auto.framework.pageframework.device.AbstractDeviceView;
import com.applause.auto.framework.pageframework.devicecontrols.Button;
import com.applause.auto.framework.pageframework.util.environment.LocatorKeyNotFoundException;

/**
 * Class represents a You're Ready View
 */
public class CarboniteYoureReadyView extends CarboniteAbstractView {
	private Logger logger = Logger.getLogger(CarboniteYoureReadyView.class);

	private Button okButton;

	/**
	 * Create a You're Ready View
	 */
	public CarboniteYoureReadyView() {
		syncHelper.waitForElementToAppear(getOkButton());
		snapshotManager.takeRemoteDeviceSnapShot("Youre_Ready_View_", driver);
		logger.info("Created You're Ready View");
	}

	/**
	 * Tap Ok
	 * 
	 * @return CarboniteLandingView
	 */
	public CarboniteLandingView tapOk() {
		logger.info("On You're Ready view, tapping ok.  Directing to Landing View.");
		getOkButton().tap();
		return new CarboniteLandingView();
	}

	/**
	 * @return the okButton
	 */
	public Button getOkButton() {
		try {
			okButton = new Button(
					env.getLocatorByName("YOUR_READY_VIEW_OK_BUTTON"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return okButton;
	}

}
