plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
    id("com.google.devtools.ksp") version "1.7.21-1.0.8"
    kotlin("kapt")
}

android {
    namespace = "com.jh.mangareader"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.jh.mangareader"
        minSdk = 29
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        kotlinCompilerExtensionVersion = "1.4.0-alpha02"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    applicationVariants.all {
        kotlin.sourceSets {
            getByName(name) {
                kotlin.srcDir("build/generated/ksp/$name/kotlin")
            }
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    //compose
    val composeVersion = "1.4.0-alpha02"
    val navVersion = "2.5.3"
    implementation("androidx.compose.ui:ui:${composeVersion}")
    implementation("androidx.compose.ui:ui-tooling-preview:${composeVersion}")
    implementation("androidx.navigation:navigation-compose:${navVersion}")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${composeVersion}")
    debugImplementation("androidx.compose.ui:ui-tooling:${composeVersion}")
    debugImplementation("androidx.compose.ui:ui-test-manifest:${composeVersion}")

    //navigation
    val navigationVersion = "1.7.27-beta"
    implementation("io.github.raamcosta.compose-destinations:core:${navigationVersion}")
    ksp("io.github.raamcosta.compose-destinations:ksp:${navigationVersion}")

    //hilt
    implementation("com.google.dagger:hilt-android:2.44.2")
    kapt("com.google.dagger:hilt-android-compiler:2.44.2")

    //fire-base
    implementation(platform("com.google.firebase:firebase-bom:31.1.0"))
    implementation ("com.google.firebase:firebase-analytics-ktx")
    implementation ("com.google.firebase:firebase-auth-ktx")

    val lifecycleVersion = "2.5.1"
    implementation("androidx.lifecycle:lifecycle-viewmodel:${lifecycleVersion}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${lifecycleVersion}")

    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.compose.material3:material3:1.1.0-alpha02")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")
}