plugins {
    id("java-library")
    id("kotlin")
    id("koin")

}


dependencies {
    val getLocalVersion = rootProject.extra.get("version") as (String) -> String
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("stdlib", getLocalVersion("kotlin_version")))
    implementation("com.koushikdutta.async", "androidasync", "3.0.9")

}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}