package com.applause.carbonite.auto.pageframework.views;

import org.apache.log4j.Logger;

import com.applause.auto.framework.pageframework.device.AbstractDeviceView;
import com.applause.auto.framework.pageframework.devicecontrols.Button;
import com.applause.auto.framework.pageframework.devicecontrols.Text;
import com.applause.auto.framework.pageframework.util.environment.LocatorKeyNotFoundException;

/**
 * Class represents a new user view.
 *
 */
public class CarboniteNewUserView extends CarboniteAbstractView {
	private Logger logger = Logger.getLogger(CarboniteNewUserView.class);

	private Button loginButton;
	private Text createNewUserButton;

	/**
	 * Create new user view
	 */
	public CarboniteNewUserView() {
		syncHelper.waitForElementToAppear(getCreateNewUserButton());
		syncHelper.waitForElementToAppear(getLoginButton());
		snapshotManager.takeRemoteDeviceSnapShot("New_User_View_", driver);
		logger.info("Created New User View.");
	}

	/**
	 * Tap and login button
	 * 
	 * @return CarboniteLoginView
	 */
	public CarboniteLoginView tapLoginButton() {
		logger.info("On New User View, tapping Login Button");
		getLoginButton().tap();
		return new CarboniteLoginView();
	}

	/**
	 * @return the loginButton
	 */
	public Button getLoginButton() {
		try {
			loginButton = new Button(
					env.getLocatorByName("NEW_USER_VIEW_LOGIN_BUTTON"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return loginButton;
	}

	/**
	 * @return the createNewUserButton
	 */
	public Text getCreateNewUserButton() {
		try {
			createNewUserButton = new Text(
					env.getLocatorByName("NEW_USER_VIEW_CREATE_USER_BUTTON"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return createNewUserButton;
	}

}
