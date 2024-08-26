plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.dip"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.example.dip"
        minSdk = 23
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
    dependencies {
        // Import the Firebase BoM
        implementation(platform("com.google.firebase:firebase-bom:33.0.0"))

        // TODO: Add the dependencies for Firebase products you want to use
        // When using the BoM, don't specify versions in Firebase dependencies
        implementation("com.google.firebase:firebase-analytics")

        // Add the dependency for the Realtime Database library
        implementation("com.google.firebase:firebase-database")
        implementation("com.google.firebase:firebase-storage:21.0.0")


        implementation(libs.appcompat)
        implementation(libs.material)
        implementation(libs.activity)
        implementation(libs.constraintlayout)
        implementation(libs.firebase.auth)
        testImplementation(libs.junit)
        androidTestImplementation(libs.ext.junit)
        androidTestImplementation(libs.espresso.core)
    }
}
dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
}



