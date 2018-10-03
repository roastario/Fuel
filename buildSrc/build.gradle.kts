import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.3.0-rc-116"
}

repositories {
    jcenter()
    google()
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
}
allprojects {
    repositories {
        google()
        jcenter()
        maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
    }
}
dependencies {
    compile(kotlin("stdlib-jdk8"))
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}