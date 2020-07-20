buildscript {

    extra.set("version", { it: String -> rootProject.extra.get(it) as String })
    extra.set("kotlin_version", "1.3.72")
    extra.set("compose_version", "0.1.0-dev14")


    repositories {
        google()
        jcenter()
    }
    dependencies {
        val getLocalVersion = rootProject.extra.get("version") as (String) -> String
        classpath ("com.android.tools.build:gradle:4.1.0-alpha10")
        classpath(kotlin("gradle-plugin", getLocalVersion("kotlin_version")))

    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven(url="https://dl.bintray.com/kotlin/ktor")
        maven(url="https://jitpack.io")
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}