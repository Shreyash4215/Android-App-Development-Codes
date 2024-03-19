plugins {
    alias(libs.plugins.androidApplication)
    id("com.chaquo.python")
}

android {
    namespace = "com.example.pythonasbackenddemo"
    compileSdk = 34

    defaultConfig {

        ndk {
            // On Apple silicon, you can omit x86_64.
            abiFilters += listOf("arm64-v8a", "x86_64")
        }

        chaquopy {
            defaultConfig {
                version = "3.8"
            }
        }

        chaquopy {
            defaultConfig {
                buildPython("C:/Users/Shreyash/AppData/Local/Programs/Python/Python312/python.exe")
            }
        }
        applicationId = "com.example.pythonasbackenddemo"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    chaquopy {
        sourceSets {
            getByName("main") {
                srcDir("src/main/python")
            }
        }
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}