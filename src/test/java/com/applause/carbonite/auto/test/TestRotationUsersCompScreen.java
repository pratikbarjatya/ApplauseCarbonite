package com.applause.carbonite.auto.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.carbonite.auto.pageframework.testdata.CarboniteTestConstants;
import com.applause.carbonite.auto.pageframework.testdata.Const;
import com.applause.carbonite.auto.pageframework.views.CarboniteAbstractView;
import com.applause.carbonite.auto.pageframework.views.CarboniteLandingView;
import com.applause.carbonite.auto.pageframework.views.CarboniteNewUserView;
import com.applause.carbonite.auto.pageframework.views.CarboniteUsersComputerView;

public class TestRotationUsersCompScreen extends CarboniteBaseAppiumTest {

	private Logger logger = Logger.getLogger(TestRotationUsersCompScreen.class);

	@Test(groups = { CarboniteTestConstants.TestNGGroups.ROTATE_USERS_COMP }, description = "USR_COMP_ACT_008")
	public void testCorrectDeviceNameDisplaysOnUsersComputerScreen() {
		CarboniteLandingView landingView = new CarboniteAbstractView().login(
				Const.VALID_USER_BETA, Const.VALID_USER_PASSWORD_BETA,
				Const.CHECKED_PROTECTION, Const.UNCHECKED_BACKUP);

		if (driver.getOrientation() == ScreenOrientation.PORTRAIT) {
			driver.rotate(ScreenOrientation.LANDSCAPE);
		}

		CarboniteUsersComputerView computerView = landingView.scrollTo("Olya")
				.tapDeviceWithTitle("Olya");
		
		List<String> landskapeTitles = computerView.getAllChunksTitles();

		driver.rotate(ScreenOrientation.PORTRAIT);

		List<String> portraitTitles = computerView.getAllChunksTitles();

		Assert.assertTrue(landskapeTitles.equals(portraitTitles));
	}
}
