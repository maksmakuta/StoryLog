package ua.mstudio.droid.model

fun initDroid() : ArrayList<DroidVersion> {
    val droid : ArrayList<DroidVersion> = ArrayList()

    for (a in names.indices) {
        droid.add(
            DroidVersion(prefix[a], hostName + names[a], apiLevels[a], ch[a], dates[a])
        )
    }
    return droid
}

var prefix = arrayOf(
    "Apple Pie" ,"Banana Cake"          ,"Cupcake"      ,"Donut"        ,"Eclair"    ,
    "Eclair"    ,"Froyo"                ,"Gingerbread"  ,"Honeycomb"    ,"Honeycomb" ,
    "Honeycomb" ,"Ice Cream Sandwich"   ,"Jelly Bean"   ,"Jelly Bean"   ,"Jelly Bean",
    "KitKat"    ,"Lollipop"             ,"Lollipop"     ,"Marshmallow"  ,"Nougat"    ,
    "Nougat"    ,"Oreo"                 ,"Oreo"         ,"Pie"          ,"Q"         ,
    "R"
)

var hostName = "Android "

var names = arrayOf(
        "1.0","1.1","1.5","1.6","2.0",
        "2.1","2.2","2.3","3.0","3.1",
        "3.2","4.0","4.1","4.2","4.3",
        "4.4","5.0","5.1","6.0","7.0",
        "7.1","8.0","8.1","9  ","10 ",
        "11(R)"
    )

var apiLevels = arrayOf(
        1 ,2 ,3 ,4 ,5,
        6 ,8 ,9 ,11,12,
        13,14,15,16,17,
        19,21,22,23,24,
        25,26,27,28,29,
        30
)
/*
var screens = arrayOf(
        0                   ,0                  ,R.drawable.droid15 ,R.drawable.droid16 ,R.drawable.droid20 ,
        R.drawable.droid21  ,R.drawable.droid22 ,R.drawable.droid23 ,R.drawable.droid30 ,0                  ,
        0                   ,R.drawable.droid40 ,R.drawable.droid41 ,0                  ,0                  ,
        R.drawable.droid44  ,R.drawable.droid50 ,0                  ,R.drawable.droid60 ,R.drawable.droid70 ,
        R.drawable.droid71  ,R.drawable.droid80 ,R.drawable.droid81 ,R.drawable.droid90 ,R.drawable.droid100,
        R.drawable.droid110
)
*/
var dates = arrayOf(
    "September 23, 2008",   "February 9, 2009", "April 27, 2009",   "September 15, 2009",   "October 26, 2009",
    "October 26, 2009",     "May 20, 2010",     "December 6, 2010", "February 22, 2011",    "February 22, 2011",
    "February 22, 2011",    "October 18, 2011", "July 9, 2012",     "July 9, 2012",         "July 9, 2012",
    "October 31, 2013",     "November 12, 2014","November 12, 2014","October 5, 2015",      "August 22, 2016",
    "August 22, 2016",      "August 21, 2017",  "August 21, 2017",  "August 6, 2018",       "September 3, 2019",
    "September, 2020"
)

var ch10 = "Android Market allowed application downloads and updates through the Market application.\n" +
        "Web browser to show, zoom and pan full HTML and XHTML web pages – multiple pages show as windows (\"cards\").\n" +
        "Camera support – however, this version lacked the option to change the camera's resolution, white balance, quality, etc.\n" +
        "Folders allowing the grouping of a number of application icons into a single folder icon on the Home screen.\n" +
        "Access to web email servers, supporting POP3, IMAP4, and SMTP.\n" +
        "Gmail synchronization with the Gmail application.\n" +
        "Google Contacts synchronization with the People application.\n" +
        "Google Calendar synchronization with the Calendar application.\n" +
        "Google Maps with Street View to view maps and satellite imagery, as well as find local businesses and obtain driving directions using GPS.\n" +
        "Google Sync, allowing management of over-the-air synchronization of Gmail, People, and Calendar.\n" +
        "Google Search, allowing users to search the Internet and phone applications, contacts, calendar, etc.\n" +
        "Google Talk instant messaging.\n" +
        "Instant messaging, text messaging, and MMS.\n" +
        "Media Player, enabling management, importing, and playback of media files – however, this version lacked video and stereo Bluetooth support.\n" +
        "Notifications appear in the Status bar, with options to set ringtone, LED or vibration alerts.\n" +
        "Voice Dialer allows dialing and placing of phone calls without typing a name or number.\n" +
        "Wallpaper allows the user to set the background image or photo behind the Home screen icons and widgets.\n" +
        "YouTube video player.\n" +
        "Other applications include: Alarm Clock, Calculator, Dialer (Phone), Home screen (Launcher), Pictures (Gallery), and Settings.\n" +
        "Wi-Fi and Bluetooth support."

var ch11 = "Details and reviews available when a user searches for businesses on Maps.\n" +
        "Longer in-call screen timeout by default when using the speakerphone, plus the ability to show/hide the dialpad.\n" +
        "Ability to save attachments in messages.\n" +
        "Support added for marquee in system layouts."

var ch15 = "Support for third-party virtual keyboards with text prediction and a user dictionary for custom words.\n" +
        "Support for Widgets – miniature application views that can be embedded in other applications (such as the Home screen) and receive periodic updates.\n" +
        "Video recording and playback in MPEG-4 and 3GP formats.\n" +
        "Auto-pairing and stereo support for Bluetooth (A2DP and AVRCP profiles).\n" +
        "Copy and paste features in web browser.\n" +
        "User pictures shown for Favorites in Contacts.\n" +
        "Specific date/time stamp shown for events in call log, and one-touch access to a contact card from a call log event.\n" +
        "Animated screen transitions.\n" +
        "Auto-rotation option.\n" +
        "New stock boot animation.\n" +
        "Ability to upload videos to YouTube.\n" +
        "Ability to upload photos to Picasa.\n" +
        "Ability to check phone usage history."

var ch16 = "Voice and text entry search enhanced to include bookmark history, contacts, and the web.\n" +
        "Ability for developers to include their content in search results.\n" +
        "Multi-lingual speech synthesis engine to allow any Android application to \"speak\" a string of text.\n" +
        "Easier searching and the ability to view app screenshots in Android Market.\n" +
        "Gallery, Camera and camcorder more fully integrated, with faster camera access.\n" +
        "Ability for users to select multiple photos for deletion.\n" +
        "Updated technology support for CDMA/EVDO, 802.1x, VPNs, and a text-to-speech engine.\n" +
        "Support for WVGA screen resolutions.\n" +
        "Speed improvements in searching and camera applications.\n" +
        "Expanded Gesture framework and a new GestureBuilder development tool."

var ch20 = "Expanded Account sync, allowing users to add multiple accounts to a device for synchronization of an email and contacts.\n" +
        "Microsoft Exchange email support, with a combined inbox to browse an email from multiple accounts in one page.\n" +
        "Bluetooth 2.1 support.\n" +
        "Ability to tap a Contacts photo and select to call, SMS, or email the person.\n" +
        "Ability to search all saved SMS and MMS messages, with the added ability to delete the oldest messages in a conversation automatically deleted when a defined limit is reached.\n" +
        "Numerous new camera features, including flash support, digital zoom, scene mode, white balance, color effect and macro focus.\n" +
        "Improved typing speed on a virtual keyboard, with a smarter dictionary that learns from word usage and includes contact names as suggestions.\n" +
        "Refreshed browser UI with bookmark thumbnails, double-tap zoom and support for HTML5.\n" +
        "Calendar agenda view enhanced, showing attending status for each invitee, and the ability to invite new guests to events.\n" +
        "Optimized hardware speed and revamped UI.\n" +
        "Support for more screen sizes and resolutions, with better contrast ratio.\n" +
        "Improved Google Maps 3.1.2.\n" +
        "MotionEvent class enhanced to track multi-touch events.\n" +
        "Addition of live wallpapers, allowing the animation of home-screen background images to show movement."

var ch21 = "Minor amendments to the API and bug fixes."

var ch22 = "Speed, memory, and performance optimizations.\n" +
        "Additional application speed improvements, implemented through JIT compilation.\n" +
        "Integration of Chrome's V8 JavaScript engine into the Browser application.\n" +
        "Support for the Android Cloud to Device Messaging (C2DM) service, enabling push notifications.\n" +
        "Improved Microsoft Exchange support, including security policies, auto-discovery, GAL look-up, calendar synchronization and remote wipe.\n" +
        "Improved application launcher with shortcuts to Phone and Browser applications.\n" +
        "USB tethering and Wi-Fi hotspot functionality\n" +
        "Option to disable data access over a mobile network.\n" +
        "Updated Market application with batch and automatic update features.\n" +
        "Quick switching between multiple keyboard languages and their dictionaries.\n" +
        "Support for Bluetooth-enabled car and desk docks.\n" +
        "Support for numeric and alphanumeric passwords.\n" +
        "Support for file upload fields in the Browser application.\n" +
        "The browser now shows all frames of animated GIFs instead of just the first frame only.\n" +
        "Support for installing applications to expandable memory.\n" +
        "Adobe Flash support.\n" +
        "Support for high-PPI displays (up to 320 ppi), such as four-inch 720p screens.\n" +
        "Gallery allows users to view picture stacks using a zoom gesture."

var ch23 = "Updated user interface design with increased simplicity and speed.\n" +
        "Support for extra-large screen sizes and resolutions (WXGA and higher).\n" +
        "Native support for SIP VoIP internet telephones.\n" +
        "Faster, more intuitive text input on a virtual keyboard, with improved accuracy, better suggested text and voice input mode.\n" +
        "Enhanced copy/paste functionality, allowing users to select a word by press-holding, copying, and pasting.\n" +
        "Support for Near Field Communication (NFC), allowing the user to read an NFC tag embedded in a poster, sticker, or advertisement.\n" +
        "New audio effects such as reverb, equalization, headphone virtualization, and bass boost.\n" +
        "New Download Manager, giving users easy access to any file downloaded from the browser, email, or another application.\n" +
        "Support for multiple cameras on the device, including a front-facing camera, if available.\n" +
        "Support for WebM/VP8 video playback, and AAC audio encoding.\n" +
        "Improved power management with a more active role in managing applications that are keeping the device awake for too long.\n" +
        "Enhanced support for native code development.\n" +
        "Switched from YAFFS to ext4 on newer devices.\n" +
        "Audio, graphical, and input enhancements for game developers.\n" +
        "Concurrent garbage collection for increased performance.\n" +
        "Native support for more sensors (such as gyroscopes and barometers).\n" +
        "First Android version to feature an Easter egg. It was an image of the Bugdroid standing next to a zombie gingerbread man, with many more zombies in the background."

var ch30 = "Optimized tablet support with a new “holographic” user interface (removed again the following year with version 4.2).\n" +
        "New Easter egg, an image of a Tron-themed bumblebee.\n" +
        "Added System Bar, featuring quick access to notifications, status, and soft navigation buttons, available at the bottom of the screen.\n" +
        "Added the Action Bar, giving access to contextual options, navigation, widgets, or other types of content at the top of the screen.\n" +
        "Simplified multitasking – tapping Recent Applications in the System Bar allows users to see snapshots of the tasks underway and quickly jump from one application to another.\n" +
        "Redesigned the keyboard, making typing fast, efficient and accurate on larger screen sizes\n" +
        "Simplified, more intuitive copy/paste interface.\n" +
        "Multiple browser tabs replacing browser windows, plus form auto-fill and a new “incognito” mode allowing anonymous browsing.\n" +
        "Quick access to camera exposure, focus, flash, zoom, front-facing camera, time-lapse, and other camera features.\n" +
        "Ability to view albums and other collections in full-screen mode in Gallery, with easy access to thumbnails for other photos.\n" +
        "New two-pane Contacts UI and Fast Scroll to let users easily organize and locate contacts.\n" +
        "New two-pane Email UI to make viewing and organizing messages more efficient, allowing users to select one or more messages.\n" +
        "Hardware acceleration.\n" +
        "Support for multi-core processors.\n" +
        "Ability to encrypt all user data.\n" +
        "HTTPS stack improved with Server Name Indication (SNI).\n" +
        "Filesystem in Userspace (FUSE; kernel module).\n" +
        "Disallows applications from having to write access to secondary storage (memory cards on devices with internal primary storage) outside of designated, application-specific directories. Full access to primary internal storage is still allowed through a separate application-level permission."

var ch31 = "UI refinements.\n" +
        "Connectivity for USB accessories (USB On-The-Go).\n" +
        "Expanded Recent Applications list.\n" +
        "Resizable Home screen widgets.\n" +
        "Support for external keyboards and pointing devices.\n" +
        "Support for joysticks and gamepads.\n" +
        "Support for FLAC audio playback.\n" +
        "High-performance Wi-Fi lock, maintaining high-performance Wi-Fi connections when the device screen is off.\n" +
        "Support for HTTP proxy for each connected Wi-Fi access point."

var ch32 = "Improved hardware support, including optimizations for a wider range of tablets.\n" +
        "Increased ability of applications to access files on the SD card, e.g. for synchronization.\n" +
        "Compatibility display mode for applications that have not been optimized for tablet screen resolutions.\n" +
        "New display support functions, giving developers more control over display appearance on different Android devices.\n"

var ch40 = "Major refinements to the \"Holo\" interface with the new Roboto font family.\n" +
        "Soft buttons from Android 3.x are now available for use on phones.\n" +
        "Separation of widgets in a new tab, listed in a similar manner to applications.\n" +
        "Easier-to-create folders, with a drag-and-drop style.\n" +
        "Improved visual voicemail with the ability to speed up or slow down voicemail messages.\n" +
        "Pinch-to-zoom functionality in the Calendar.\n" +
        "Integrated screenshot capture (accomplished by holding down the Power and Volume-Down buttons).\n" +
        "Improved error correction on the keyboard.\n" +
        "Ability to access applications directly from the lock screen.\n" +
        "Improved copy-and-paste functionality.\n" +
        "Better voice integration and continuous, real-time speech-to-text dictation.\n" +
        "Face Unlock, a feature that allows users to unlock handsets using facial recognition software.\n" +
        "Automatic syncing of browser with users' Chrome bookmarks.\n" +
        "Data Usage section in settings that lets users set warnings when they approach a certain usage limit, and disable data use when the limit is exceeded.\n" +
        "Ability to shut down applications from the recent apps list with a swipe.\n" +
        "Improved camera application with zero shutter lag, time lapse settings, panorama mode, and the ability to zoom while recording.\n" +
        "Built-in photo editor.\n" +
        "New gallery layout, organized by location and person.\n" +
        "Refreshed the \"People\" application with social network integration, status updates and hi-res images.\n" +
        "Android Beam, a near-field communication feature allowing the rapid short-range exchange of web bookmarks, contact info, directions, YouTube videos and other data.\n" +
        "Support for the WebP image format.\n" +
        "Hardware acceleration of the UI.\n" +
        "Wi-Fi Direct.\n" +
        "1080p video recording for stock Android devices.\n" +
        "Android VPN Framework (AVF), and TUN (but not TAP) kernel module. Prior to 4.0, VPN software required a rooted Android device."

var ch41 = "Smoother user interface:\n" +
        " - Vsync timing across all drawing and animation done by the Android framework, including application rendering, touch events, screen composition and display refresh.\n" +
        " - Triple buffering in the graphics pipeline.\n" +
        " - CPU input boost.\n" +
        " - Synchronizing touch to vsync timing.\n" +
        "Enhanced accessibility.\n" +
        "Bi-directional text and other language support.\n" +
        "User-installable keyboard maps.\n" +
        "Expandable notifications.\n" +
        "Ability to turn off notifications on an application-specific basis.\n" +
        "Shortcuts and widgets can automatically be re-arranged or re-sized to allow new items to fit on home screens.\n" +
        "Bluetooth data transfer for Android Beam.\n" +
        "Tablets with smaller screens now use an expanded version of the interface layout and home screen used by phones.[112]\n" +
        "Improved camera application.\n" +
        "Multichannel audio.\n" +
        "The Fraunhofer FDK AAC codec becomes standard in Android, adding AAC 5.1 channel encoding/decoding.\n" +
        "USB audio (for external sound DACs).\n" +
        "Audio chaining (also known as gapless playback).\n" +
        "Ability for other launchers to add widgets from the application drawer without requiring root access."

var ch42 = "Lock screen improvements, including widget support (removed again in 2014)and the ability to swipe directly to the camera.\n" +
        "Notification power controls (\"Quick Settings\").\n" +
        "\"Daydream\" screensavers, showing information when idle or docked (later renamed to \"screen saver\" following the launch of the unrelated Google Daydream VR platform in 2016).\n" +
        "Multiple user accounts (tablets only).\n" +
        "Rewritten Bluetooth stack, switching from Bluez to Broadcom open source BlueDroid, allowing improved support for multiple displays and wireless display (Miracast).\n" +
        "Native right-to-left, always-on VPN and application verification. A new NFC stack was added at the same time.\n" +
        "Accessibility improvements: triple-tap to magnify the entire screen, pan and zoom with two fingers. Speech output and Gesture Mode navigation for blind users.\n" +
        "New clock application with a built-in world clock, stop watch and timer.\n" +
        "All devices now use the same interface layout, previously adapted from phones on 4.1 for smaller tablets (with centered software buttons, the system bar at the top of the screen, and a home screen with a dock and centered application menu), regardless of screen size.\n" +
        "Increased number of extended notifications and Actionable Notifications for more applications, allowing users to respond to certain notifications within the notification bar and without launching the application directly.\n" +
        "SELinux support.\n" +
        "Premium SMS confirmation.\n" +
        "Group Messaging support."

var ch43 = "Bluetooth low energy support.\n" +
        "Bluetooth Audio/Video Remote Control Profile (AVRCP) 1.3 support.\n" +
        "OpenGL ES 3.0 support, allowing improved game graphics.\n" +
        "Restricted access mode for new user profiles.\n" +
        "Filesystem performance improvement by running the fstrim command while a device is idle.\n" +
        "Dial pad auto-complete in the Phone application.\n" +
        "Volume for incoming calls (ringtone) and notification alerts is no longer adjustable separately.\n" +
        "Improvements to Photo Sphere.\n" +
        "Reworked camera UI, previously introduced on Google Play edition phones.\n" +
        "Addition of \"App Ops\", a fine-grained application permissions control system (hidden by default).\n" +
        "SELinux enabled by default.\n" +
        "4K resolution support.\n" +
        "Numerous security updates, performance enhancements, and bug fixes.\n" +
        "System-level support for geofencing and Wi-Fi scanning APIs.\n" +
        "Background Wi-Fi location still runs even when Wi-Fi is turned off.\n" +
        "Developer logging and analyzing enhancements.\n" +
        "Added support for five more languages.\n" +
        "Changed digital rights management (DRM) APIs.\n" +
        "Right-to-left (RTL) languages now supported.\n" +
        "Clock in the status bar disappears if it is selected as a lockscreen widget.\n" +
        "Native emoji support.\n"

var ch44 = "Refreshed interface with white elements instead of blue.\n" +
        "Clock no longer shows bold hours; all digits are thin. The H, M, and S markings for the stopwatch and timer have been removed, leaving just the numbers.\n" +
        "Ability for applications to trigger translucency in the navigation and status bars.\n" +
        "Ability for applications to use \"immersive mode\" to keep the navigation and status bars hidden while maintaining user interaction.\n" +
        "Action overflow menu buttons are always visible, even on devices with a \"Menu\" key, which was officially deprecated by Android 4.0.\n" +
        "Write access disabled for user-installed applications om external storage (i.e. MicroSD), except for their own directories inside Android/data.\n" +
        "Purging of app data directories in user storage (internal user storage and MicroSD) upon uninstallation\n" +
        "Optimizations for performance on devices with lower specifications, including zRAM support and \"low RAM\" device API.\n" +
        "Wireless printing capability.\n" +
        "NFC host card emulation, enabling a device to replace smart cards.\n" +
        "WebViews are now based on the Chromium engine (feature parity with Chrome for Android 30).\n" +
        "Expanded functionality for notification listener services.\n" +
        "Public API for developing and managing text messaging clients.\n" +
        "Storage Access Framework, an API allowing apps to retrieve files in a consistent manner. As part of the framework, a new system file picker allows users to access files from various sources (including those exposed by apps, such as online storage services).\n" +
        "New framework for UI transitions.\n" +
        "Sensor batching, step detector and counter APIs.\n" +
        "Settings application now makes it possible to select default text messaging and the home (launcher) application.\n" +
        "Audio tunneling, audio monitoring and loudness enhancer.\n" +
        "Built-in screen recording feature (primarily for developers, as usage of ADB is required).\n" +
        "Native infrared blaster API.\n" +
        "Verified boot.\n" +
        "Enforcing SELinux.\n" +
        "Expanded accessibility APIs and system-level closed captioning settings.\n" +
        "Android Runtime (ART) introduced as a new experimental application runtime environment, not enabled by default, as a replacement for the Dalvik virtual machine.\n" +
        "Bluetooth Message Access Profile (MAP) support.\n" +
        "Disabled access to battery statistics by third-party applications.\n" +
        "Settings application no longer uses a multi-pane layout on devices with larger screens.\n" +
        "Wi-Fi and mobile data activity (TX/RX) indicators are moved to quick settings.\n" +
        "Disables text wrapping in the WebView browser component."

var ch50 = "Android Runtime (ART) with ahead-of-time (AOT) compilation and improved garbage collection (GC), replacing Dalvik that combines bytecode interpretation with trace-based just-in-time (JIT) compilation.\n" +
        "Support for 64-bit CPUs.\n" +
        "OpenGL ES 3.1 and Android Extension Pack (AEP) on supported GPU configurations.\n" +
        "Recent activities screen with tasks instead of applications, up to a configured maximum of tasks per application.\n" +
        "Vector drawables, which scale without losing definition.\n" +
        "Support for print previews.\n" +
        "Material design, bringing a restyled user interface and “ripple effect” for buttons.\n" +
        "Refreshed lock screen, no longer supporting widgets.\n" +
        "Refreshed notification tray and quick settings pull-down.\n" +
        "Project Volta, for battery life improvements.\n" +
        "Searches can be performed within the system settings for quicker access to particular settings.\n" +
        "Lock screen provides shortcuts to application and notification settings.\n" +
        "Guest logins and multiple user accounts are available on more devices, such as phones.\n" +
        "Audio input and output through USB devices.\n" +
        "Third-party applications regain the ability to read and modify data located anywhere on external storage, such as on SD cards. However, those must be adapted to the storage access framework of Android API level 21 or higher.\n" +
        "Pinning of an application's screen for restricted user activity.\n" +
        "Recently used applications are remembered even after restarting the device.\n" +
        "WebViews receive updates independently through Google Play for security reasons, instead of relying on system-wide vendor updates.\n" +
        "Addition of 15 new languages: Basque, Bengali, Burmese, Chinese (Hong Kong), Galician, Icelandic, Kannada, Kyrgyz, Macedonian, Malayalam, Marathi, Nepali, Sinhala, Tamil and Telugu.\n" +
        "Tap and Go allows users to quickly migrate to a new Android device, using NFC and Bluetooth to transfer Google Account details, configuration settings, user data and installed applications.\n" +
        "A flashlight-style application is included, working on supported devices with a camera flash.\n" +
        "User-customizable priorities for application notifications.\n" +
        "Smart lock feature.\n" +
        "SELinux in enforcing mode for all domains.\n" +
        "Updated emoji.\n" +
        "Improved accessibility support (e.g. switch access support).\n" +
        "Block-based over-the-air (OTA) updates for new devices.\n" +
        "Task listing access disabled for third-party applications"

var ch51 = "Improvements and bug fixes to the Overview screen.\n" +
        "Ability to join Wi-Fi networks and control paired Bluetooth devices from quick settings.\n" +
        "Official support for multiple SIM cards.\n" +
        "Device protection: if a device is lost or stolen it will remain locked until the owner signs into their Google account, even if the device is reset to factory settings.\n" +
        "High-definition voice calls, available between compatible 4G LTE devices running Android 5.1.\n" +
        "Improvements to the notification priority system, to more closely replicate the silent mode that was removed from Android 5.0.\n"

var ch60 = "Contextual search from keywords within apps.\n" +
        "Introduction of Doze mode, which reduces CPU speed while the screen is off in order to save battery life.\n" +
        "App Standby feature.\n" +
        "Alphabetically accessible vertical application drawer.\n" +
        "Application search bar and favorites.\n" +
        "Native fingerprint reader support.\n" +
        "Direct Share feature for target-specific sharing between apps.\n" +
        "Renamed \"Priority\" mode to \"Do Not Disturb\" mode.\n" +
        "App Linking for faster instinctive opening of links with corresponding applications.\n" +
        "Larger Application folders with multiple pages.\n" +
        "Post-install/run-time permission requests.\n" +
        "USB-C support.\n" +
        "Demo Mode feature for screenshot-capture usage.\n" +
        "Automatic full data backup and restore for apps.\n" +
        "4K display mode for apps.\n" +
        "Adoptable External storage to behave like Internal Storage. (However, this causes more actual problems than the hypothetical ones it was probably designed to solve.)\n" +
        "MIDI support for musical instruments.\n" +
        "Experimental multi-window feature.\n" +
        "Support for actions by third-party apps in the text selection menu.\n" +
        "App permissions now granted individually at run-time, not all-or-nothing at install time. Similar to App Ops.\n" +
        "Miracast support dropped.\n" +
        "Many new essential commands supported by Android's Linux shell (/bin/sh).\n" +
        "No screen rotation during touch."

var ch70 = "Support for file-based encryption.\n" +
        "Unicode 9.0 emoji and skin tone modifier support (and exposes a subset of ICU4J APIs).\n" +
        "Ability to display color calibration.\n" +
        "Ability to zoom in the screen.\n" +
        "Ability to switch to the last opened app by double-tapping the overview button.\n" +
        "Added an Emergency information part.\n" +
        "Added the \"Clear All\" button to the Overview screen.\n" +
        "Another system partition, which gets updated when not in use, allowing for seamless system updates.\n" +
        "Daydream virtual reality platform (VR interface).\n" +
        "Improved Doze functionality, which aims to prolong battery life.\n" +
        "Improvements to the file browser.\n" +
        "More Quick Settings options.\n" +
        "Multi-window support, which supports floating apps on a desktop layout.\n" +
        "New Data Saver mode, which can force apps to reduce bandwidth usage.\n" +
        "New JIT Compiler, making for 75 percent faster app installations and a 50 percent reduction in compiled code size.\n" +
        "Just in Time (JIT) compiler with code profiling to ART, which lets it constantly improve the performance of Android apps as they run.\n" +
        "Picture-in-picture support for Android TV.\n" +
        "Redesigned notification shade, featuring instant access to certain settings.\n" +
        "Redesigned Overview screen.\n" +
        "Replaced notification cards with notification sheets.\n" +
        "Settings app navigation drawer.\n" +
        "Vulkan 3D rendering API.\n" +
        "Multiple Device Locales\n" +
        "Discontinuation of Android Camera V1 API\n" +
        "Restricted file system access"

var ch71 = "Rearranged notification shade.\n" +
        "Touch/display performance improvements.\n" +
        "Moves (Fingerprint swipe down gesture – opt-in).\n" +
        "Opt-in with new hardware required:\n" +
        " - Seamless A/B system updates.\n" +
        " - Daydream VR mode.\n" +
        "Developer features:\n" +
        " - Shortcut manager APIs.\n" +
        " - Circular app icons support.\n" +
        " - Keyboard image insertion.\n" +
        " - Fingerprint sensor gesture to open/close notification shade.\n" +
        " - Manual storage manager Intent for apps.\n" +
        " - Improved VR thread scheduling.\n" +
        " - Enhanced wallpaper metadata.\n" +
        " - Multi-endpoint call support.\n" +
        "      Support for various MNO requirements.\n" +
        "    - PCDMA voice privacy property.\n" +
        "    - Source type support for Visual Voicemail.\n" +
        "    - Carrier config options for managing telephone videos.\n" +
        "Manual storage manager – identifies files and apps using storage."

var ch80 = "Project Treble, the biggest change to the foundations of Android to date: a modular architecture that makes it easier and faster for hardware makers to deliver Android updates.\n" +
        "Picture-in-picture support.\n" +
        "Support for Unicode 10.0 emoji (5.0) and replacement of all blob-shaped emojis by round ones with gradients and outlines.\n" +
        "Redesigned Quick Settings and Settings with a white background and respectively black and Accent font colors.\n" +
        "Restructured Settings by regrouping sections into similar entries.\n" +
        "Adaptive icons\n" +
        "Notification improvements.\n" +
        "Notification channels.\n" +
        "Notification dots (badges).\n" +
        "Notification snoozing.\n" +
        "Notification shade multi-colors (for music album art, messengers, etc.).\n" +
        "System-wide Autofill framework.\n" +
        "Support for AAC, Sony's LDAC and Qualcomm's aptX and aptX HD codecs.\n" +
        "App-specific unknown sources.\n" +
        "Multi-display support.\n" +
        "2 times faster boot time compared to Nougat according to Google, testing on their Pixel devices.\n" +
        "Apps background execution and location limits.\n" +
        "Google Play Protect.\n" +
        "Downloadable fonts.\n" +
        "Integrated printing support.\n" +
        "Color management (deep color and wide color gamut).\n" +
        "Wi-Fi Assistant."

var ch81 = "Neural networks API.\n" +
        "Shared memory API.\n" +
        "WallpaperColors API.\n" +
        "Bluetooth battery level for connected devices, accessible in Quick Settings.\n" +
        "Android Oreo Go Edition, a lightweight distribution of Android that runs better than normal Android on devices with less than 1 GB of RAM.\n" +
        "Autofill framework updates.\n" +
        "Programmatic Safe Browsing actions.\n" +
        "Navigation buttons dim when not in use.\n" +
        "Visual changes to 'Power Off' and 'Restart', including a new screen and floating toolbar.\n" +
        "Toast messages are now white with the same existing transparency.\n" +
        "Automatic light and dark themes.\n" +
        "New Easter egg in the form of an official Oreo cookie picture."

var ch90 = "New user interface for the quick settings menu.\n" +
        "The clock has moved to the left of the notification bar.\n" +
        "The \"dock\" now has a semi-transparent background.\n" +
        "Battery Saver no longer shows an orange overlay on the notification and status bars.\n" +
        "A \"screenshot\" button has been added to the power options.\n" +
        "A new \"Lockdown\" mode which disables biometric authentication once activated.\n" +
        "Rounded corners across the UI.\n" +
        "New transitions for switching between apps, or activities within apps.\n" +
        "Richer messaging notifications, where a full conversation can be seen within a notification, full-scale images, and smart replies akin to Google's new app, Reply.\n" +
        "Support for display cutouts.\n" +
        "Redesigned volume slider.\n" +
        "Battery percentage now shown in Always-On Display.\n" +
        "Lock screen security changes include the possible return of an improved NFC Unlock.\n" +
        "Experimental features (which are currently hidden within a menu called Feature Flags) such as a redesigned About Phone page in settings, and automatic Bluetooth enabling while driving.\n" +
        "DNS over TLS.\n" +
        "A new optional gesture-based system interface, allowing users to navigate the OS using swipes more often than the traditional UI.\n" +
        "Redesigned multitask app switcher with the Google search bar and app drawer built-in.\n" +
        "Android Dashboard, which tells the user how much time they are spending on their device and in apps, and allows the user to set time limits on apps.\n" +
        "\"Shush\", an enhanced version of Do Not Disturb mode activated by placing the phone face down, which mutes standard notifications.\n" +
        "\"Adaptive Battery\" prediction, which makes use of Doze to hibernate user apps the OS determines the user will not use.\n" +
        "Auto-Brightness feature modifies screen brightness based on user habits.\n" +
        "Wind Down option lets Android users set a specific bedtime that enables Do Not Disturb and turns the entire phone's interface gray to discourage further use at night.\n" +
        "Vulkan 1.1 support.\n" +
        "Call recording options fully disabled[248]"

var ch100 = "New permissions required to access location in background and to access photo, video and audio files.\n" +
        "Background apps can no longer jump into the foreground.\n" +
        "Limited access to non-resettable device identifiers.\n" +
        "Background (idle) access to camera, microphone and sensors disabled for more privacy protection with the side effect of disabling antitheft software.\n" +
        "Sharing shortcuts, which allow sharing content with a contact directly.\n" +
        "Floating settings panel, that allows changing system settings directly from apps.\n" +
        "Dynamic depth format for photos, which allow changing background blur after taking a photo.\n" +
        "Support for the AV1 video codec, the HDR10+ video format and the Opus audio codec.\n" +
        "Support for aptX Adaptive, LHDC, LLAC, CELT and AAC LATM codecs\n" +
        "A native MIDI API, allowing interaction with music controllers.\n" +
        "Better support for biometric authentication in apps.\n" +
        "Support for the WPA3 Wi-Fi security protocol.\n" +
        "Support for foldable phones.\n" +
        "Support for Notification Bubbles.\n" +
        "New system-wide dark theme/mode\n" +
        "Project Mainline, allows core OS components to be updated via the Google Play Store, without requiring a complete system update"

var ch110 = "New permissions controls.\n" +
        "API distinction between standalone"


var ch = arrayOf(
    ch10 , ch11 ,ch15, ch16, ch20,
    ch21 , ch22 ,ch23, ch30, ch31,
    ch32 , ch40 ,ch41, ch42, ch43,
    ch44 , ch50 ,ch51, ch60, ch70,
    ch71 , ch80 ,ch81, ch90, ch100,
    ch110
    )

data class DroidVersion(
    var prefix : String,
    var name : String ,
    var apiLevel : Int,
    var changeLog : String,
    var stableDate : String
)
