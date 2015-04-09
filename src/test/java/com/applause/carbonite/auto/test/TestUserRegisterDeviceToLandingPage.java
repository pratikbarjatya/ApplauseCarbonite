package com.applause.carbonite.auto.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.framework.pageframework.util.environment.LocatorKeyNotFoundException;
import com.applause.carbonite.auto.pageframework.testdata.CarboniteTestConstants;
import com.applause.carbonite.auto.pageframework.testdata.Const;
import com.applause.carbonite.auto.pageframework.views.CarboniteAbstractView;
import com.applause.carbonite.auto.pageframework.views.CarboniteLandingView;
import com.applause.carbonite.auto.pageframework.views.CarboniteLoginView;
import com.applause.carbonite.auto.pageframework.views.CarboniteNewUserView;
import com.applause.carbonite.auto.pageframework.views.CarboniteWelcomeView;
import com.applause.carbonite.auto.pageframework.views.CarboniteYoureReadyView;

public class TestUserRegisterDeviceToLandingPage extends
		CarboniteBaseAppiumTest {
	private Logger logger = Logger
			.getLogger(TestUserRegisterDeviceToLandingPage.class);

	@Test(groups = { CarboniteTestConstants.TestNGGroups.REG_DEVICE }, description = "Test ID")
	public void testUserLoginRegisterDeviceToLandingPage() {

		try {
			Assert.assertTrue(
					new CarboniteAbstractView().login(Const.VALID_USER,
							Const.VALID_USER_PASSWORD,
							Const.CHECKED_PROTECTION, Const.UNCHECKED_BACKUP)
							.getRegisteredDeviceCount() > 1,
					"Expected Device Count on Landing Page to be greater then 1.");
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
			Assert.fail("Exception occurred when getting Device count on carbonite landing page.");
		}

	}
}
