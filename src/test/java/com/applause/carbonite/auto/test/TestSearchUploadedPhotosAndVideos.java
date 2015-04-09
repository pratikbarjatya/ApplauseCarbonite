package com.applause.carbonite.auto.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.applause.auto.framework.pageframework.util.environment.LocatorKeyNotFoundException;
import com.applause.carbonite.auto.pageframework.chunks.CarboniteBackUpAndProtectChunk;
import com.applause.carbonite.auto.pageframework.testdata.CarboniteTestConstants;
import com.applause.carbonite.auto.pageframework.testdata.Const;
import com.applause.carbonite.auto.pageframework.views.CarboniteAbstractView;
import com.applause.carbonite.auto.pageframework.views.CarboniteLandingView;
import com.applause.carbonite.auto.pageframework.views.CarboniteLoginView;
import com.applause.carbonite.auto.pageframework.views.CarboniteNewUserView;
import com.applause.carbonite.auto.pageframework.views.CarboniteWelcomeView;
import com.applause.carbonite.auto.pageframework.views.CarboniteYoureReadyView;

public class TestSearchUploadedPhotosAndVideos extends CarboniteBaseAppiumTest {
	private Logger logger = Logger
			.getLogger(TestSearchUploadedPhotosAndVideos.class);

	@Test(groups = { CarboniteTestConstants.TestNGGroups.SEARCH }, description = "Test ID")
	public void testSearchUploadedVideoAndPhotos() {

		CarboniteLandingView landingView = new CarboniteAbstractView().login(
				Const.VALID_USER, Const.VALID_USER_PASSWORD,
				Const.CHECKED_PROTECTION, Const.UNCHECKED_BACKUP);

		int idx = landingView
				.getIndexOfBackupAndProtectChunkWithTitle("_Do Not Rename");

		if (idx == -1) {
			driver.scrollTo("_Do Not Rename");
			idx = landingView
					.getIndexOfBackupAndProtectChunkWithTitle("_Do Not Rename");
		}

		logger.info(String.format("Found index [%d].", idx));

		new CarboniteBackUpAndProtectChunk(Integer.toString(idx))
				.tapBackUpButton()
				.tapPhotoAndVideoLink()
				.tapSearchLink()
				.doSearch("IMG_20150210_213256.jpg");

		try {
			Assert.assertTrue(
					queryHelper
							.getAndroidElementCount(env
									.getLocatorByName("DEVICE_PHOTOS_AND_VIDEO_VIEW_THUMBNAIL_SEARCH")) == 1,
					"Expected count of elements to be greater then 1");
		} catch (LocatorKeyNotFoundException e) {
			Assert.fail();
			e.printStackTrace();
		}

	}
}
