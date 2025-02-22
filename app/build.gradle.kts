plugins {
    id("com.android.application") version "8.7.1"
    kotlin("android") version "1.9.22"
    id("com.google.devtools.ksp")
}

android {
    namespace = "ru.otus.daggerhomework"
    compileSdk = 35

    defaultConfig {
        applicationId = "ru.otus.daggerhomework"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.google.material)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.constraintlayout)
    ksp(libs.daggerCompiler)
    implementation(libs.dagger)
}