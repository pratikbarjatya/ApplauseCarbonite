package com.applause.carbonite.auto.pageframework.views;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.applause.auto.framework.pageframework.devicecontrols.Text;
import com.applause.auto.framework.pageframework.util.environment.LocatorKeyNotFoundException;

public class CarboniteUsersComputerView extends
		CarboniteAbstractView<CarboniteUsersComputerView> {

	private Logger logger = Logger.getLogger(CarboniteUsersComputerView.class);

	public CarboniteUsersComputerView() {
		super();
		try {
			syncHelper.waitForElementToAppear(new Text(env
					.getLocatorByName("USERS_COMPUTER_DEVICE_TITLE")));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		logger.info("Created User's computer screen View.");
	}

	public String getDeviceTitle() {
		Text deviceTitle = null;
		try {
			deviceTitle = new Text(
					env.getLocatorByName("USERS_COMPUTER_DEVICE_TITLE"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return deviceTitle.getStringValue();
	}

	public List<String> getAllChunksTitles() {
		List<String> result = new ArrayList<String>();
		try {
			int count = queryHelper.getMobileElementCount(env
					.getLocatorByName("USERS_COMPUTERS_SCREEN_CHUNK_GENERAL"));

			logger.info(count);

			for (int i = 0; i < count; i++) {
				Text chunkTitle = new Text(
						String.format(
								env.getLocatorByName("USERS_COMPUTERS_SCREEN_CHUNK_TITLE"),
								i));
				result.add(chunkTitle.getStringValue());
			}
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

}
