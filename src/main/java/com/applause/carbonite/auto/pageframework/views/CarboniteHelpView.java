package com.applause.carbonite.auto.pageframework.views;

import org.apache.log4j.Logger;

import com.applause.auto.framework.pageframework.devicecontrols.Text;
import com.applause.auto.framework.pageframework.util.environment.LocatorKeyNotFoundException;

public class CarboniteHelpView extends CarboniteAbstractView {

	private Logger logger = Logger.getLogger(CarboniteHelpView.class);

	public CarboniteHelpView() {
		super();
		try {
			syncHelper.waitForElementToAppear(new Text(env
					.getLocatorByName("HELP_VIEW_EMAIL")));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		logger.info("Created Help View.");
	}

	public String getEmail() {
		Text result = null;
		try {
			result = new Text(env.getLocatorByName("HELP_VIEW_EMAIL"));
		} catch (LocatorKeyNotFoundException e) {
			logger.error("Expception thrown when locating element.");
			e.printStackTrace();
		}
		return result.getStringValue();
	}

}
