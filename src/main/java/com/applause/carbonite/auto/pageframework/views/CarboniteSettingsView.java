package com.applause.carbonite.auto.pageframework.views;

import org.apache.log4j.Logger;

import com.applause.auto.framework.pageframework.devicecontrols.Button;
import com.applause.auto.framework.pageframework.util.environment.LocatorKeyNotFoundException;

public class CarboniteSettingsView extends CarboniteAbstractView {
	private Logger logger = Logger.getLogger(CarboniteSettingsView.class);

	private Button unregisterThisDeviceButton;

	public CarboniteSettingsView() {
		super();
		syncHelper.waitForElementToAppear(getUregisterThisDeviceButton());
		logger.info("Created Settings View.");
	}

	/**
	 * @return unregisterThisDeviceButton
	 */
	public Button getUregisterThisDeviceButton() {
		try {
			unregisterThisDeviceButton = new Button(
					env.getLocatorByName("UREGISTER_THIS_DEVICE_BUTTON"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return unregisterThisDeviceButton;
	}

	/**
	 * Tap Unregister this device Link and return a CarboniteLoginView
	 * 
	 * @return CarboniteLoginView
	 */
	public CarboniteLoginView tapUnregisterThisDevice() {
		getUregisterThisDeviceButton().tap();
		return new CarboniteLoginView();
	}
}
