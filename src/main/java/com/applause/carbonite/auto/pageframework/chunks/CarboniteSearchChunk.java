package com.applause.carbonite.auto.pageframework.chunks;

import org.apache.log4j.Logger;

import com.applause.auto.framework.pageframework.device.AbstractDeviceView;
import com.applause.auto.framework.pageframework.devicecontrols.TextBox;
import com.applause.auto.framework.pageframework.util.environment.LocatorKeyNotFoundException;
import com.applause.carbonite.auto.pageframework.views.CarboniteDevicePhotosAndVideosView;

/**
 * Class represents a search chunk created by clicking the search link on the
 * options menu.
 */
public class CarboniteSearchChunk extends AbstractDeviceView {
	private Logger logger = Logger.getLogger(CarboniteSearchChunk.class);

	private TextBox searchTextBox;

	/**
	 * Create a Search Chunk
	 */
	public CarboniteSearchChunk() {
		syncHelper.waitForElementToAppear(getSearchTextBox());
		snapshotManager.takeRemoteDeviceSnapShot("Search_Chunk_", driver);
		logger.info("Created a search chunk.");
	}

	/**
	 * Enter a search term and click on Go (simulated)
	 * 
	 * @param query
	 *            to search for
	 * @return CarboniteDevicePhotosAndVideosView
	 */
	public CarboniteDevicePhotosAndVideosView doSearch(String query) {
		getSearchTextBox().enterText(query);
		this.getDriver().sendKeyEvent(66);
		return new CarboniteDevicePhotosAndVideosView();
	}

	/**
	 * @return the searchTextBox
	 */
	public TextBox getSearchTextBox() {
		try {
			searchTextBox = new TextBox(
					env.getLocatorByName("SEACH_CHUNK_SEARCH_TEXT_BOX"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return searchTextBox;
	}
}
