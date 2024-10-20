    // Splash Screen
    implementation(libs.androidx.core.splashscreen)

    // Icons
    implementation(libs.androidx.material.icons.extended)

    // System UI Controller
    implementation(libs.accompanist.systemuicontroller)

    // Koin
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)

    // Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    annotationProcessor(libs.androidx.room.compiler)
    ksp(libs.androidx.room.compiler)
