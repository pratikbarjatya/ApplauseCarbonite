package com.applause.carbonite.auto.pageframework.views;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.applause.auto.framework.pageframework.device.AbstractDeviceView;
import com.applause.auto.framework.pageframework.devicecontrols.Link;
import com.applause.auto.framework.pageframework.devicecontrols.Text;
import com.applause.auto.framework.pageframework.util.environment.LocatorKeyNotFoundException;
import com.applause.carbonite.auto.pageframework.chunks.CarboniteBackUpAndProtectChunk;

/**
 * Class represents the Device Backup View
 *
 */
public class CarboniteDeviceBackupAndArchiveView extends CarboniteAbstractView<CarboniteDeviceBackupAndArchiveView> {
	private Logger logger = Logger
			.getLogger(CarboniteDeviceBackupAndArchiveView.class);

	private Link photosAndVideoLink;
	private Text lastBackupText;

	private ArrayList<CarboniteBackUpAndProtectChunk> devices = new ArrayList<CarboniteBackUpAndProtectChunk>();

	/**
	 * Create device backup view
	 */
	public CarboniteDeviceBackupAndArchiveView() {
		super();
		syncHelper.waitForElementToAppear(getPhotosAndVideoLink());
		loadAllDeviceChunks();
		snapshotManager.takeRemoteDeviceSnapShot(
				"Device_Backup_and_Archives_View_", driver);
		logger.info("Created Device Backup View.");
	}

	/**
	 * Iterates through the page to load all the device chunks
	 */
	private void loadAllDeviceChunks() {

	}

	/**
	 * Tap the Photo and Video Link
	 * 
	 * @return CarboniteDevicePhotosAndVideosView
	 */
	public CarboniteDevicePhotosAndVideosView tapPhotoAndVideoLink() {
		logger.info("On Device Backup view, clicking Photo and Video link.");
		getPhotosAndVideoLink().tap();
		return new CarboniteDevicePhotosAndVideosView();
	}

	/**
	 * @return the photosAndVideoLink
	 */
	public Link getPhotosAndVideoLink() {
		try {
			photosAndVideoLink = new Link(
					env.getLocatorByName("DEVICE_BACKUP_AND_ACHRIVE_VIEW_PHOTOS_AND_VIDEOS_LINK"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return photosAndVideoLink;
	}

	/**
	 * @return the lastBackupText
	 */
	public Text getLastBackupText() {
		try {
			lastBackupText = new Text(
					env.getLocatorByName("DEVICE_BACKUP_AND_ACHRIVE_VIEW_LAST_BACKUP_TEXT"));
		} catch (LocatorKeyNotFoundException e) {
			e.printStackTrace();
		}
		return lastBackupText;
	}

}
