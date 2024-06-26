plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "vch.compose_ex"
    compileSdk = 34

    defaultConfig {
        applicationId = "vch.compose_ex"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            val proguards = fileTree("proguard") {
                include("*.pro")
            }
            proguardFiles(*proguards.toList().toTypedArray())
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    //for empty project
    implementation(MyDependencies.coreKtx)
    implementation(MyDependencies.lifecycleRuntimeKtx)
    implementation(MyDependencies.activityCompose)
    implementation(MyDependencies.composeUi)
    implementation(MyDependencies.uiToolingPreview)
    implementation(MyDependencies.composeMaterial)
    testImplementation(MyDependencies.junit)
    androidTestImplementation(MyDependencies.testExtJunit)
    androidTestImplementation(MyDependencies.espressoCore)
    androidTestImplementation(MyDependencies.uiTestJunit4)
    debugImplementation(MyDependencies.uiTooling)
    debugImplementation(MyDependencies.uiTestManifest)
    //dagger_hilt_compose_navigation block
    implementation(MyDependencies.daggerHiltAndroid)
    kapt(MyDependencies.daggerHiltAndroidCompiler)
    kapt(MyDependencies.hiltCompiler)
    implementation(MyDependencies.hiltNavigationCompose)
    implementation(MyDependencies.navigationCompose)
    // Retrofit
    implementation(MyDependencies.retrofit)
    //moshi
    implementation(MyDependencies.moshiKotlin)
    // Moshi Converter (if you're using Moshi)
    implementation(MyDependencies.converterMoshi)
    // OkHttp3 (Retrofit depends on this)
    implementation(MyDependencies.okhttp)
    // OkHttp Interceptor (for intercepting network requests)
    implementation(MyDependencies.loggingInterceptor)
    //coroutines
    implementation(MyDependencies.kotlinxCoroutinesAndroid)
    // Optional - APIs for SplashScreen, including compatibility helpers on devices prior Android 12
    implementation(MyDependencies.splashscreen)
    implementation(MyDependencies.foundation)//pager
    implementation(MyDependencies.coilCompose)
    //! modify!!!
//    implementation 'androidx.compose.foundation:foundation:1.4.0-alpha03'


    //include modules
    implementation(project(MyModules.utilities))
}

kapt {
    correctErrorTypes = true
}