package com.applause.carbonite.auto.pageframework.locators;

public class CarboniteAndroidAppLocators {

	// content
	public static final String CONTENT = "android:id/content";

	public static final String REGISTERING_LOADING_MESSAGE = "new UiSelector().resourceId(\"android:id/message\").textContains(\"Registering device protection…\")";

	// Options button
	public static final String OPTIONS_BUTTON = "new UiSelector().className(\"android.widget.ImageButton\")";

	// Locators for NewUserView

	public static final String NEW_USER_VIEW_LOGIN_BUTTON = "com.carbonite.android:id/btnLogin";

	public static final String NEW_USER_VIEW_CREATE_USER_BUTTON = "com.carbonite.android:id/navigateSwitcher";

	// Locators for WelcomeView
	public static final String WELCOME_VIEW_PROTECT_CHECK_BOX = "com.carbonite.android:id/checkBoxProtect";

	public static final String WELCOME_VIEW_BACKUP_CHECK_BOX = "com.carbonite.android:id/checkBoxSync";

	public static final String WELCOME_VIEW_OK_BUTTON = "com.carbonite.android:id/btnOk";

	// Locators for YoureReadyView
	public static final String YOUR_READY_VIEW_OK_BUTTON = "com.carbonite.android:id/btnOk";
	// Locators for LoginView

	public static final String LOGIN_VIEW_USERNAME_TEXTBOX = "com.carbonite.android:id/txtEmail";

	public static final String LOGIN_VIEW_PASSWORD_TEXTBOX = "com.carbonite.android:id/txtPassword";

	public static final String LOGIN_VIEW_LOGIN_BUTTON = "com.carbonite.android:id/btnLogin";

	public static final String LOGIN_VIEW_SHOW_OPTIONS_BUTTON = "new UiSelector().descriptionContains(\"More Options\")";
	// Locators for OptionsMenu
	public static final String OPTIONS_MENU_LOG_OUT_LINK = "new UiSelector().resourceId(\"android:id/title\").textContains(\"Log out\")";

	public static final String OPTIONS_MENU_SAVED_FILES_LINK = "new UiSelector().resourceId(\"android:id/title\").textContains(\"Saved files\")";

	public static final String OPTIONS_MENU_SETTINGS_LINK = "new UiSelector().resourceId(\"android:id/title\").textContains(\"Settings\")";

	public static final String OPTIONS_MENU_HELP_LINK = "new UiSelector().resourceId(\"android:id/title\").textContains(\"Help\")";

	public static final String OPTIONS_MENU_SEARCH_LINK = "com.carbonite.android:id/mnuSearch";

	public static final String OPTIONS_MENU_OPTION_TITLE = "new UiSelector().className(\"android.widget.LinearLayout\").index(%s).childSelector(resourceId(\"android:id/title\"))";

	public static final String OPTIONS_MENU_GENERAL = "new UiSelector().className(\"android.widget.LinearLayout\")";
	// Locators for LandingView

	public static final String LANDING_VIEW_BACKUP_BUTTON = "//android.view.View[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.Button[1]";

	public static final String LANDING_VIEW_ADD_COMPUTER_BACKUP_BUTTON = "com.carbonite.android:id/addComputer";

	public static final String LANDING_VIEW_DEVICE_ICON = "new UiSelector().resourceId(\"com.carbonite.android:id/deviceType\")";

	public static final String LANDING_VIEW_DEVICE_ADD_COMPUTER_BUTTON = "com.carbonite.android:id/addComputer";

	// Locators for DeviceBackupView
	public static final String DEVICE_BACKUP_AND_ACHRIVE_VIEW_PHOTOS_AND_VIDEOS_LINK = "new UiSelector().resourceId(\"com.carbonite.android:id/ContentName\").textContains(\"Photos and Videos\")";

	public static final String DEVICE_BACKUP_AND_ACHRIVE_VIEW_LAST_BACKUP_TEXT = "new UiSelector().resourceId(\"com.carbonite.android:id/ContentDescription\").textContains(\"Last backed up:\")";

	// Locators for PhotosAndVideosView
	public static final String DEVICE_PHOTOS_AND_VIDEO_VIEW_SWITCH_VIEW_BUTTON = "com.carbonite.android:id/switchView";

	public static final String DEVICE_PHOTOS_AND_VIDEO_VIEW_THUMBNAIL_GENERIC = "com.carbonite.android:id/ivThumbnail";

	public static final String DEVICE_PHOTOS_AND_VIDEO_VIEW_THUMBNAIL_SEARCH = "new UiSelector().resourceId(\"com.carbonite.android:id/ivThumbnail\")";

	public static final String DEVICE_PHOTOS_AND_VIDEO_VIEW_SHOW_OPTIONS_BUTTON = "new UiSelector().descriptionContains(\"More Options\")";
	// Locators for SearchChunk
	public static final String SEACH_CHUNK_SEARCH_TEXT_BOX = "android:id/search_src_text";

	// locators for Backup and Protection Chunk
	public static final String BACKUP_PROTECTION_CHUNK_GENERAL = "new UiSelector().className(\"android.widget.RelativeLayout\")";

	public static final String BACKUP_PROTECTION_CHUNK_BACKUP_BUTTON = "new UiSelector().className(\"android.widget.RelativeLayout\").index(%s).resourceId(\"Backup\"))";

	public static final String BACKUP_PROTECTION_CHUNK_DEVICE_TITLE = "new UiSelector().className(\"android.widget.RelativeLayout\").index(%s).childSelector(resourceId(\"com.carbonite.android:id/name\"))";

	public static final String BACKUP_PROTECTION_CHUNK_DEVICE = "new UiSelector().className(\"android.widget.RelativeLayout\").index(%s)";

	public static final String BACKUP_PROTECTION_CHUNK_DEVICE_STATUS = "new UiSelector().className(\"android.widget.RelativeLayout\").index(%s).childSelector(resourceId(\"com.carbonite.android:id/backup_status\"))";

	public static final String BACKUP_PROTECTION_CHUNK_PROTECT_BUTTON = "new UiSelector().className(\"android.widget.RelativeLayout\").index(%s).childSelector(textContains(\"Protection\"))";

	// locators for Settings View
	public static final String UREGISTER_THIS_DEVICE_BUTTON = "new UiSelector().resourceId(\"android:id/title\").textContains(\"Unregister this device\")";

	// locators for Help View
	public static final String HELP_VIEW_EMAIL = "new UiSelector().className(\"android.widget.LinearLayout\").index(1).childSelector(resourceId(\"android:id/summary\"))";

	// locators for User's computer
	public static final String USERS_COMPUTER_DEVICE_TITLE = "android:id/action_bar_title";

	public static final String USERS_COMPUTERS_SCREEN_CHUNK_GENERAL = "new UiSelector().resourceId(\"com.carbonite.android:id/ContentName\")";

	public static final String USERS_COMPUTERS_SCREEN_CHUNK_TITLE = "new UiSelector().className(\"android.widget.ListView\").childSelector(new UiSelector().className(\"android.widget.LinearLayout\").index(%s)).childSelector(resourceId(\"com.carbonite.android:id/ContentName\"))";

	// locators for Key folder view
	public static final String KEY_FOLDER_DEVICE_TITLE = "android:id/action_bar_title";

	// locators for Activate device administrator view
	public static final String DEVICE_ADMINISTRATOR_ACTIVATE_BUTTON = "com.android.settings:id/action_button";

	public static final String DEVICE_ADMINISTRATOR_CANCEL_BUTTON = "com.android.settings:id/cancel_button";

}