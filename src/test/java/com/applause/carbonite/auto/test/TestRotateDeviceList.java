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

public class TestRotateDeviceList extends CarboniteBaseAppiumTest {

	private Logger logger = Logger.getLogger(TestRotateDeviceList.class);

	@Test(groups = { CarboniteTestConstants.TestNGGroups.ROTATE_DEVICE_LIST }, description = "DEV_LIST_ACT_012")
	public void testRotateLeadsToCorrectDisplayOfDeviceList() {
		CarboniteLandingView landingView = new CarboniteAbstractView().login(
				Const.VALID_USER, Const.VALID_USER_PASSWORD,
				Const.CHECKED_PROTECTION, Const.UNCHECKED_BACKUP);

		driver.rotate(ScreenOrientation.LANDSCAPE);
		List<String> landscapeScreenStatuses = landingView
				.getAllDevicesStatus();
		driver.rotate(ScreenOrientation.PORTRAIT);
		List<String> portraitScreenStatuses = landingView.getAllDevicesStatus();

		Assert.assertEquals(
				landscapeScreenStatuses.subList(0,
						portraitScreenStatuses.size()), portraitScreenStatuses);
	}
}
