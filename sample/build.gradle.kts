import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

dependencies {
    implementation(Dependencies.kotlinStdlib)
    implementation(Dependencies.androidAppCompat)
    implementation(Dependencies.kotlinCoroutinesAndroid)
    implementation(Dependencies.rxJavaAndroid)

    apiElements(project(":fuel-rxjava"))
    apiElements(project(":fuel-android"))
    apiElements(project(":fuel-livedata"))
    apiElements(project(":fuel-gson"))
    apiElements(project(":fuel-coroutines"))

    androidTestImplementation(Dependencies.androidAnnotation)
    androidTestImplementation(Dependencies.androidTestRunner)
    androidTestImplementation(Dependencies.androidTestRules)
    androidTestImplementation(Dependencies.androidEspressoCore)
    androidTestImplementation(Dependencies.androidEspressoIntents)
}

configure<BaseExtension> {
    compileSdkVersion(Versions.fuelCompileSdkVersion)

    defaultConfig {
        applicationId = "com.example.fuel"
        minSdkVersion(Versions.fuelMinSdkVersion)
        targetSdkVersion(Versions.fuelCompileSdkVersion)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    packagingOptions {
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/NOTICE.txt")
    }
}

configure<KotlinProjectExtension> {
    experimental.coroutines = Coroutines.ENABLE
}

configurations.all {
    resolutionStrategy.eachDependency {
        if (requested.group == "android.arch.lifecycle") {
            useVersion("1.1.1")
        }
    }
}
