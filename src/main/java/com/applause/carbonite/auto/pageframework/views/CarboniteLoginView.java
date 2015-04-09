package com.applause.carbonite.auto.pageframework.views;

import org.apache.log4j.Logger;

import com.applause.auto.framework.pageframework.device.AbstractDeviceView;
import com.applause.auto.framework.pageframework.devicecontrols.Button;
import com.applause.auto.framework.pageframework.devicecontrols.TextBox;
import com.applause.auto.framework.pageframework.util.environment.LocatorKeyNotFoundException;
import com.applause.carbonite.auto.pageframework.chunks.CarboniteOptionsMenu;

/**
 * Class represents the Login view
 *
 */
public class CarboniteLoginView extends CarboniteAbstractView {
	private Logger logger = Logger.getLogger(CarboniteLoginView.class);

	private TextBox usernameTextBox;
	private TextBox passwordTextBox;
	private Button loginButton;
	private Button launchOptionsMenuButton;
	private CarboniteOptionsMenu options;

	/**
	 * Create a CarboniteLoginView object
	 */
	public CarboniteLoginView() {
		super();
		syncHelper.waitForElementToAppear(getLoginButton());
		syncHelper.waitForElementToAppear(getPasswordTextBox());
		syncHelper.waitForElementToAppear(getUsernameTextBox());
		snapshotManager.takeRemoteDeviceSnapShot("Login_View_", driver);
		logger.info("Crated Login View.");
	}

	/**
	 * Do a successful login on an existing device application
	 * 
	 * @param username
	 * @param password
	 * @return CarboniteLandingView
	 */
	public CarboniteLandingView doSuccessfulLogin(String username,
			String password) {
		logger.info(String.format("Logging in with [%s] and [%s].", username,
				password));
		getUsernameTextBox().clearTextBox();
		getUsernameTextBox().enterText(username);
		getPasswordTextBox().clearTextBox();
		getPasswordTextBox().enterText(password);
		getLoginButton().tap();
		return new CarboniteLandingView();
	}

	/**
	 * Do a successful login on a clean device
	 * 
	 * @param username
	 * @param password
	 * @return CarboniteWelcomeView
	 */
	public CarboniteWelcomeView doSuccessfulFirstLogin(String username,
			String password) {
		logger.info(String.format("Logging in with [%s] and [%s].", username,
				password));
		getUsernameTextBox().clearTextBox();
		getUsernameTextBox().enterText(username);
		getPasswordTextBox().clearTextBox();
		getPasswordTextBox().enterText(password);
		getLoginButton().tap();
		return new CarboniteWelcomeView();
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
	 * @return Username TextBox
	 */
	public TextBox getUsernameTextBox() {
		try {
			usernameTextBox = new TextBox(
					env.getLocatorByName("LOGIN_VIEW_USERNAME_TEXTBOX"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return usernameTextBox;
	}

	/**
	 * @return Password TextBox
	 */
	public TextBox getPasswordTextBox() {
		try {
			passwordTextBox = new TextBox(
					env.getLocatorByName("LOGIN_VIEW_PASSWORD_TEXTBOX"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return passwordTextBox;
	}

	/**
	 * @return LoginButton
	 */
	public Button getLoginButton() {
		try {
			loginButton = new Button(
					env.getLocatorByName("LOGIN_VIEW_LOGIN_BUTTON"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return loginButton;
	}

	/**
	 * @return Show Options Menu Button
	 */
	public Button getOptionsMenuButton() {
		try {
			launchOptionsMenuButton = new Button(
					env.getLocatorByName("LOGIN_VIEW_SHOW_OPTIONS_BUTTON"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return launchOptionsMenuButton;
	}

	public CarboniteLoginView enterPassword(String password) {
		getPasswordTextBox().enterText(password);
		getLoginButton().tap();
		return new CarboniteLoginView();
	}
}
