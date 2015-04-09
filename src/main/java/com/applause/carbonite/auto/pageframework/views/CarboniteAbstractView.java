package com.applause.carbonite.auto.pageframework.views;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.applause.auto.framework.pageframework.device.AbstractDeviceView;
import com.applause.auto.framework.pageframework.devicecontrols.Link;
import com.applause.auto.framework.pageframework.util.environment.LocatorKeyNotFoundException;
import com.applause.carbonite.auto.pageframework.chunks.CarboniteOptionsMenu;
import com.applause.carbonite.auto.pageframework.chunks.CarboniteSearchChunk;
import com.applause.carbonite.auto.pageframework.testdata.CarboniteTestConstants;

/**
 * Class represents Abstract View
 *
 */
public class CarboniteAbstractView<T extends CarboniteAbstractView<T>> extends
		AbstractDeviceView {
	private static Logger logger = Logger
			.getLogger(CarboniteAbstractView.class);

	private Link searchLink;
	private Link optionsLink;

	public CarboniteAbstractView() {
		super();
	}

	/**
	 * Tap Search Link and return a search chunk
	 * 
	 * @return CarboniteSearchChunk
	 */
	public CarboniteSearchChunk tapSearchLink() {
		logger.info("Tapping Search");
		getSearchLink().tap();
		return new CarboniteSearchChunk();
	}

	/**
	 * @return the searchLink
	 */
	public Link getSearchLink() {
		try {
			searchLink = new Link(
					env.getLocatorByName("OPTIONS_MENU_SEARCH_LINK"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return searchLink;
	}

	/**
	 * Unregistring this device
	 */
	public CarboniteLoginView unregisterDevice() {
		logger.info("Unregistring device.");
		tapOptionsLink()
				.tapSettingsLink()
				.tapUnregisterThisDevice()
				.enterPassword(
						CarboniteTestConstants.TestData.VALID_USER_PASSWORD);
		return new CarboniteLoginView();
	}

	public CarboniteOptionsMenu tapOptionsLink() {
		try {
			if (syncHelper.isElementDisplayed(env
					.getLocatorByName("OPTIONS_MENU_SETTINGS_LINK"))) {
				return new CarboniteOptionsMenu();
			}
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		getOptionsLink().tap();
		return new CarboniteOptionsMenu();
	}

	@SuppressWarnings("unchecked")
	public T scrollTo(String to) {
		driver.scrollTo(to);
		return (T) this;
	}

	/**
	 * @return the optionsLink
	 */
	public Link getOptionsLink() {
		try {
			optionsLink = new Link(env.getLocatorByName("OPTIONS_BUTTON"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return optionsLink;
	}

	private void innerLogin(String validUser, String validUserPassword,
			boolean protection, boolean backup) {
		if (!env.getIsMobileIOS()) {

			CarboniteWelcomeView welcomeView = new CarboniteLoginView()
					.doSuccessfulFirstLogin(validUser, validUserPassword);

			if (!protection)
				welcomeView.getProtectDeviceCheckbox().tap();
			if (!backup)
				welcomeView.getBackupDeviceCheckbox().tap();
			welcomeView.getOkButton().tap();

			if (protection) {
				logger.info("Protection is enabled");
				try {
					if (validUser.equals("crbtest_android@yahoo.com/jabba")) {
						logger.info("Login is equals to \"crbtest_android@yahoo.com/jabba\", start waiting for 59 sec.");
						Thread.sleep(59000);
						logger.info("Waiting is over.");
					}
					logger.info("Start waiting for registering is over.");
					syncHelper.waitForElementToDisappear(env
							.getLocatorByName("REGISTERING_LOADING_MESSAGE"));
					logger.info("Registering is over.");
					if (syncHelper
							.isElementDisplayed(env
									.getLocatorByName("DEVICE_ADMINISTRATOR_ACTIVATE_BUTTON"))) {
						logger.info("Activate button presents.");
						new CarboniteActivateDeviceAdministratorView()
								.tapActivateButton().tapOk();
					} else {
						logger.info("Protection is disabled.");
						new CarboniteYoureReadyView().tapOk();
					}
				} catch (LocatorKeyNotFoundException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			new CarboniteLoginView().doSuccessfulLogin(validUser,
					validUserPassword);
		}
	}

	public CarboniteLandingView login(String validUser,
			String validUserPassword, boolean protection, boolean backup) {

		if (!isLoggedIn()) {
			innerLogin(validUser, validUserPassword, protection, backup);
		} else {
			if (tapOptionsLink().tapHelpLink().getEmail().equals(validUser)) {
				while (!areWeOnLandingView()) {
					driver.navigate().back();
				}
				return new CarboniteLandingView();
			} else {
				while (!areWeOnLandingView()) {
					driver.navigate().back();
				}
				unregisterDevice();
				innerLogin(validUser, validUserPassword, protection, backup);
			}
		}
		return new CarboniteLandingView();
	}

	private boolean areWeOnLandingView() {
		try {
			if (syncHelper
					.isElementDisplayed(env
							.getLocatorByName("LANDING_VIEW_DEVICE_ADD_COMPUTER_BUTTON"))) {
				return true;
			}
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean isLoggedIn() {
		List<String> options = tapOptionsLink().getAvailableOptions();
		driver.navigate().back();
		return options.contains("Log out");
	}

}
