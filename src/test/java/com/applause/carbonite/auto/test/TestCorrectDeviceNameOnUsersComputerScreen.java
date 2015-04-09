package com.applause.carbonite.auto.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.carbonite.auto.pageframework.testdata.CarboniteTestConstants;
import com.applause.carbonite.auto.pageframework.testdata.Const;
import com.applause.carbonite.auto.pageframework.views.CarboniteAbstractView;
import com.applause.carbonite.auto.pageframework.views.CarboniteLandingView;
import com.applause.carbonite.auto.pageframework.views.CarboniteNewUserView;

public class TestCorrectDeviceNameOnUsersComputerScreen extends
		CarboniteBaseAppiumTest {

	private Logger logger = Logger
			.getLogger(TestCorrectDeviceNameOnUsersComputerScreen.class);

	@Test(groups = { CarboniteTestConstants.TestNGGroups.CORRECT_DEVICE_NAME_USERS_COMP }, description = "USR_COMP_ACT_002")
	public void testCorrectDeviceNameDisplaysOnUsersComputerScreen() {
		CarboniteLandingView landingView = new CarboniteAbstractView().login(
				Const.VALID_USER_BETA, Const.VALID_USER_PASSWORD_BETA,
				Const.CHECKED_PROTECTION, Const.UNCHECKED_BACKUP);
		driver.scrollTo("Olya");
		Assert.assertEquals(landingView.tapDeviceWithTitle("Olya")
				.getDeviceTitle(), "Olya");
	}
}