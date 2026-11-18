plugins {
    id("com.android.application")
}

android {
    namespace = "com.jayjaytech.jtechforums"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jayjaytech.jtechforums"
        minSdk = 24            // Android 7.0 and newer
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        // The forum the app shows. CHANGE THESE TWO if the address is different (host only in SITE_HOST, no https://).
        buildConfigField("String", "SITE_URL", "\"https://jtechforums.org/\"")
        buildConfigField("String", "SITE_HOST", "\"jtechforums.com\"")
    }

    buildFeatures {
        buildConfig = true
    }

    // The same key signs every build, so a newer APK installs over an older one (sideloading, not the Play Store).
    signingConfigs {
        create("release") {
            storeFile = file("../keystore/jtechforums.jks")
            storePassword = "jtechforums-sideload"
            keyAlias = "jtechforums"
            keyPassword = "jtechforums-sideload"
            enableV1Signing = true   // classic signature too, for the oldest Android 7 builds
            enableV2Signing = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
