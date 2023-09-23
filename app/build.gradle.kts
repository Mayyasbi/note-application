val appCompatVersion = "1.5.1"
val constraintLayoutVersion = "2.1.4"
val coreTestingVersion = "2.1.0"
val lifecycleVersion = "2.3.1"
val materialVersion = "1.3.0"
val roomVersion = "2.3.0"
// testing
val junitVersion = "4.13.2"
val espressoVersion = "3.4.0"
val androidxJunitVersion = "1.1.2"
buildscript {
    repositories {
        mavenCentral()
        google()
        jcenter()
    }
}
plugins {
    id("com.android.application")

}

android {
    namespace = "com.example.noteapplication"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.noteapplication"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}


dependencies {
    implementation ("androidx.room:room-runtime:${roomVersion}")
    implementation ("androidx.room:room-common:2.5.2")
    annotationProcessor ("androidx.room:room-compiler:${roomVersion}")
    androidTestImplementation ("androidx.room:room-testing:${roomVersion}")

    implementation ("androidx.lifecycle:lifecycle-viewmodel:${lifecycleVersion}")
    implementation ("androidx.lifecycle:lifecycle-livedata:${lifecycleVersion}")
    implementation ("androidx.lifecycle:lifecycle-common-java8:${lifecycleVersion}")

    implementation ("androidx.constraintlayout:constraintlayout:${constraintLayoutVersion}")
    implementation ("com.google.android.material:material:${materialVersion}")

    testImplementation ("junit:junit:${junitVersion}")
    androidTestImplementation ("androidx.arch.core:core-testing:${coreTestingVersion}")
    androidTestImplementation ("androidx.test.ext:junit:${androidxJunitVersion}")
    androidTestImplementation ("androidx.test.espresso:espresso-core:${espressoVersion}")
}