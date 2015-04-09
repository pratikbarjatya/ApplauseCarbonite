package com.applause.carbonite.auto.pageframework.views;

import org.apache.log4j.Logger;

import com.applause.auto.framework.pageframework.devicecontrols.Button;
import com.applause.auto.framework.pageframework.util.environment.LocatorKeyNotFoundException;

public class CarboniteActivateDeviceAdministratorView extends
		CarboniteAbstractView<CarboniteActivateDeviceAdministratorView> {

	private Logger logger = Logger
			.getLogger(CarboniteActivateDeviceAdministratorView.class);

	private Button activateButton;
	private Button cancelButton;

	public CarboniteActivateDeviceAdministratorView() {
		super();
		syncHelper.waitForElementToAppear(getActivateButton());
		syncHelper.waitForElementToAppear(getCancelButton());
		logger.info("Created CarboniteActivate Device Administrator View.");
	}

	private Button getActivateButton() {
		try {
			activateButton = new Button(
					env.getLocatorByName("DEVICE_ADMINISTRATOR_ACTIVATE_BUTTON"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return activateButton;
	}

	private Button getCancelButton() {
		try {
			cancelButton = new Button(
					env.getLocatorByName("DEVICE_ADMINISTRATOR_CANCEL_BUTTON"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return cancelButton;
	}

	public CarboniteYoureReadyView tapActivateButton() {
		getActivateButton().tap();
		return new CarboniteYoureReadyView();
	}

	public CarboniteYoureReadyView tapCancellButton() {
		getCancelButton().tap();
		return new CarboniteYoureReadyView();
	}
}
