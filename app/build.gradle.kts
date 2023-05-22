plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}

android {

    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = "br.com.aldemir.composenavigationeasier"
        minSdk = Versions.minSdk
        targetSdk = Versions.targeSdk
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled =  false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.lifecycleKtx)

    implementation(platform(Dependencies.composeBom))
    implementation(Dependencies.ActivityCompose)
    implementation(Dependencies.composeGraphics)
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeUiToolingPreview)
    implementation(Dependencies.material3)

    implementation(Dependencies.navigationCompose)
    implementation(Dependencies.navigationAnimation)
    implementation(Dependencies.gson)
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltAndroidCompilerKapt)
    kapt(Dependencies.hiltCompilerKapt)
    implementation(Dependencies.hiltNavigationCompose)

    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.junitExt)
    androidTestImplementation(Dependencies.expresso)

    androidTestImplementation(platform(Dependencies.composeBom))
    androidTestImplementation(Dependencies.junitCompose)
    debugImplementation(Dependencies.composeUiTooling)
    debugImplementation(Dependencies.composeTestManifest)
}