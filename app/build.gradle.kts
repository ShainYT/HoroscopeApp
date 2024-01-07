plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //Dagger
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
//    Navegacion segura
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.shainDev.horoscapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.shainDev.horoscapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

//        testInstrumentationRunner =
//            "androidx.test.runner.AndroidJUnitRunner" //Este funciona para cuando no usas dagger hilt
        testInstrumentationRunner =
            "com.shainDev.horoscapp.CustomTestRunner" //Este funciona para cuando no usas dagger hilt
    }
    packaging {
        resources.excludes.add("META-INF/*")
    }
    buildTypes {

        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            resValue("string", "alvaroname", "HoroscApp")
            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app/\"")
        }
        getByName("debug") {
            isDebuggable = true
            resValue("string", "alvaroname", "[DEBUG] HoroscApp")
            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app/\"")
            //buildConfigField("String", "BASE_URL", "\"https://newastro-debug.vercel.app/\"")
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
        viewBinding = true
        buildConfig = true //si es que te da error
    }
}

dependencies {

    val nav_version = "2.7.6"
    val dagger_version = "2.50"
    val retrofit_version = "2.9.0"
    val logginginterceptor_version = "4.12.0"
    val cameraVersion = "1.2.3"
    val mockkVersion = "1.13.8"


    //NavigationComponent
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    //Dagger Hilt
    implementation("com.google.dagger:hilt-android:$dagger_version")
    kapt("com.google.dagger:hilt-compiler:$dagger_version")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")
    //Interceptor que va con retrofit
    implementation("com.squareup.okhttp3:logging-interceptor:$logginginterceptor_version")

    //Camera X
    implementation("androidx.camera:camera-core:${cameraVersion}")
    implementation("androidx.camera:camera-camera2:${cameraVersion}")
    implementation("androidx.camera:camera-lifecycle:${cameraVersion}")
    implementation("androidx.camera:camera-view:${cameraVersion}")
    implementation("androidx.camera:camera-extensions:${cameraVersion}")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //Testing incluidos
    //UnitTesting
    testImplementation("junit:junit:4.13.2") //Solo funciona en el directorio test
    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2") //Agregado por el ide
    androidTestImplementation("org.junit.jupiter:junit-jupiter:5.8.2") //Agregado por el ide
    //Mockk
    testImplementation("io.mockk:mockk:${mockkVersion}")

    //Cmd + shift + t mac seleccionando una clase para que cre los test
    androidTestImplementation("androidx.test.ext:junit:1.1.5") //Solo funciona en el  directorio androidtest
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //UITesting
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test.espresso:espresso-contrib:3.5.1")
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.5.1")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.48")
    androidTestImplementation("androidx.fragment:fragment-testing:1.6.2")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.48")

}