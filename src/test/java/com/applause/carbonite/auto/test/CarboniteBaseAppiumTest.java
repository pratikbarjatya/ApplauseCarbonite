package com.applause.carbonite.auto.test;

import io.appium.java_client.AppiumDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.AfterClass;

import com.applause.auto.framework.pageframework.synchronization.SynchronizationHelper;
import com.applause.auto.framework.pageframework.util.drivers.WebDriverWrapper;
import com.applause.auto.framework.pageframework.util.environment.EnvironmentUtil;
import com.applause.auto.framework.pageframework.util.queryhelpers.DeviceElementQueryHelper;
import com.applause.carbonite.auto.pageframework.locators.CarboniteAndroidAppLocators;
import com.applause.carbonite.auto.pageframework.locators.CarboniteIOSAppLocators;
import com.applause.carbonite.auto.pageframework.views.CarboniteAbstractView;

public class CarboniteBaseAppiumTest {
	private static Logger logger = Logger
			.getLogger(CarboniteBaseAppiumTest.class);

	protected static AppiumDriver driver = null;

	protected static EnvironmentUtil env = EnvironmentUtil.getInstance();

	private static CarboniteAndroidAppLocators carboniteAndroidLocators = new CarboniteAndroidAppLocators();

	private static CarboniteIOSAppLocators carboniteIOSLocators = new CarboniteIOSAppLocators();

	protected static SynchronizationHelper syncHelper;

	protected static WebDriverWrapper deviceWrapper;

	protected static DeviceElementQueryHelper queryHelper;

	static {

		driver = WebDriverWrapper.getDeviceDriver();

		if (env.getIsMobileIOS()) {
			logger.info("Loading IOS Locators into in-memory map.");
			EnvironmentUtil.loadLocatorsForPackage(carboniteIOSLocators
					.getClass().getName());
		} else {
			logger.info("Loading Android Locators into in-memory map.");
			EnvironmentUtil.loadLocatorsForPackage(carboniteAndroidLocators
					.getClass().getName());
		}

		logger.info("Starting Before Class Setup.");
		queryHelper = new DeviceElementQueryHelper(driver);
		syncHelper = new SynchronizationHelper(driver);
		logger.info("Completed before class setup work - Created appium driver");

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.rotate(ScreenOrientation.LANDSCAPE);
		/*new CarboniteAbstractView().unregisterDevice();*/
//		WebDriverWrapper.closeApplicationSession();
	}
}
