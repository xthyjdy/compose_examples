object MyDependencies {
    const val coreKtx = "androidx.core:core-ktx:${MyVersions.coreKtx}"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${MyVersions.lifecycleRuntimeKtx}"
    const val activityCompose = "androidx.activity:activity-compose:${MyVersions.activityCompose}"
    const val composeUi = "androidx.compose.ui:ui:${MyVersions.composeUi}"
    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${MyVersions.composeUi}"
    const val composeMaterial = "androidx.compose.material:material:${MyVersions.composeMaterial}"
    const val junit = "junit:junit:${MyVersions.junit}"
    const val testExtJunit = "androidx.test.ext:junit:${MyVersions.testExtJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${MyVersions.espressoCore}"
    const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4:${MyVersions.composeUi}"
    const val uiTooling = "androidx.compose.ui:ui-tooling:${MyVersions.composeUi}"
    const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:${MyVersions.composeUi}"
    const val appcompat = "androidx.appcompat:appcompat:${MyVersions.appcompat}"
    const val androidMaterial = "com.google.android.material:material:${MyVersions.androidMaterial}"
    //dagger_hilt
    const val daggerHiltAndroid = "com.google.dagger:hilt-android:${MyVersions.daggerHiltAndroid}"
    const val daggerHiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${MyVersions.daggerHiltAndroid}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${MyVersions.hiltCompiler}"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${MyVersions.hiltNavigationCompose}"
    //fix for navigation
    const val navigationCompose = "androidx.navigation:navigation-compose:${MyVersions.navigationCompose}"
    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${MyVersions.retrofit}"
    // OkHttp3 (Retrofit depends on this)
    const val okhttp = "com.squareup.okhttp3:okhttp:${MyVersions.okhttp}"
    //moshi
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${MyVersions.moshiKotlin}"
    // Moshi Converter (if you're using Moshi)
    const val converterMoshi = "com.squareup.retrofit2:converter-moshi:${MyVersions.converterMoshi}"
    // OkHttp Interceptor (for intercepting network requests)
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${MyVersions.loggingInterceptor}"
    //coroutines
    const val kotlinxCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${MyVersions.kotlinxCoroutinesAndroid}"
    const val splashscreen = "androidx.core:core-splashscreen:${MyVersions.splashscreen}"
    const val foundation = "androidx.compose.foundation:foundation:${MyVersions.foundation}"
    const val coilCompose = "io.coil-kt:coil-compose:${MyVersions.coilCompose}"
}

object MyModules {
    const val utilities = ":utilities"
}