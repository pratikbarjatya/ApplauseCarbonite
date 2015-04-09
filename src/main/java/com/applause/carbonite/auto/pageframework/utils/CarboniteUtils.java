package com.applause.carbonite.auto.pageframework.utils;

import io.appium.java_client.AppiumDriver;

public class CarboniteUtils {

	public static final String SCREEN_SIZE = "screen";
	public static final String FONT_SIZE = "font";

	public static void swipe(AppiumDriver driver, String aim, int i) {

		if (aim.equals("screen")) {
			int height = driver.manage().window().getSize().height;
			int width = driver.manage().window().getSize().width;
			driver.swipe(width / 2, height - 1, width / 2, 250, 1000);
		} else if (aim.equals("font")) {

		}

	}
}
