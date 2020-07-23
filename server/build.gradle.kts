plugins {
    id("com.android.library")
    id("kotlin-android")
    id("koin")
 }



android {
    compileSdkVersion(29)
    buildToolsVersion("30.0.0")

    sourceSets {
        val main by getting
        main.java.srcDirs("src/kotlin")
        main.manifest.srcFile("src/main/AndroidManifest.xml")
        main.res.srcDirs("src/res")
    }
}
dependencies {
    val getLocalVersion = rootProject.extra.get("version") as (String) -> String
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("stdlib", getLocalVersion("kotlin_version")))
    implementation("com.koushikdutta.async", "androidasync", "3.0.9")
 }

