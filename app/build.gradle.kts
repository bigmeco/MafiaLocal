plugins {
    id("com.android.application")
 //   id("koin")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

val getLocalVersion = rootProject.extra.get("version") as (String) -> String
android {
    compileSdkVersion(29)
    buildToolsVersion("30.0.0")

    defaultConfig {
        applicationId = "com.bigmeco.mafialocal"
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }


    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerVersion = "1.3.70-dev-withExperimentalGoogleExtensions-20200424"
        kotlinCompilerExtensionVersion = getLocalVersion("compose_version")
    }

    packagingOptions {
        exclude ("META-INF/kotlinx-io.kotlin_module")
        exclude ("META-INF/atomicfu.kotlin_module")
        exclude ("META-INF/kotlinx-coroutines-io.kotlin_module")
        exclude ("META-INF/kotlinx-coroutines-core.kotlin_module")
        exclude ("META-INF/INDEX.LIST")
        exclude ("META-INF/io.netty.versions.properties")
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    //core
    implementation ("org.jetbrains.kotlin","kotlin-stdlib",getLocalVersion("kotlin_version"))
    implementation ("androidx.core","core-ktx","1.3.0")
    implementation ("org.jetbrains.kotlinx","kotlinx-coroutines-core","1.3.7")
    implementation ("org.jetbrains.kotlinx","kotlinx-coroutines-android","1.3.7")

    //UI
    kapt ("androidx.compose","compose-compiler",getLocalVersion("compose_version"))
    implementation ("androidx.appcompat","appcompat","1.1.0")
    implementation ("com.google.android.material","material","1.1.0")
    implementation ("androidx.ui","ui-core",getLocalVersion("compose_version"))
    implementation ("androidx.ui","ui-layout",getLocalVersion("compose_version"))
    implementation ("androidx.ui","ui-material",getLocalVersion("compose_version"))
    implementation ("androidx.ui","ui-tooling",getLocalVersion("compose_version"))

    // scan and create qr code
    implementation ("com.github.SumiMakito","AwesomeQRCode","1.2.0")
    implementation ("com.dlazaro66.qrcodereaderview","qrcodereaderview","2.0.3")

    // server host ws
    implementation ("com.koushikdutta.async","androidasync","2.2.1")

    // REST
    implementation ("com.google.code.gson","gson","2.8.6")

    //TEST
    testImplementation ("junit","junit","4.13")
    androidTestImplementation ("androidx.test.ext","junit","1.1.1")
    androidTestImplementation ("androidx.test.espresso","espresso-core","3.2.0")

}