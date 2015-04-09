package com.applause.carbonite.auto.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.carbonite.auto.pageframework.testdata.CarboniteTestConstants;
import com.applause.carbonite.auto.pageframework.testdata.Const;
import com.applause.carbonite.auto.pageframework.views.CarboniteAbstractView;
import com.applause.carbonite.auto.pageframework.views.CarboniteNewUserView;

public class TestDeviceStatus extends CarboniteBaseAppiumTest {
	private Logger logger = Logger.getLogger(TestDeviceStatus.class);

	@Test(groups = { CarboniteTestConstants.TestNGGroups.DEVICE_STATUS }, description = "DEV_LIST_ACT_006")
	public void testExpiredStatusIsDisplayedForExpiredPc() {

		List<String> list = new CarboniteAbstractView()
				.login(Const.VALID_USER_BETA, Const.VALID_USER_PASSWORD_BETA,
						Const.CHECKED_PROTECTION, Const.UNCHECKED_BACKUP)
				.scrollTo("Expired").getAllDevicesStatus();

		boolean result = false;

		for (String x : list) {
			if (x.matches("Expired.*")) {
				result = true;
				break;
			}
		}
		Assert.assertTrue(result);
	}
}