
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

plugins {
    java
    kotlin("jvm")
}

dependencies {
    compile(Dependencies.result)
    testCompile(Dependencies.json)
    testCompile(Dependencies.mockServer)
    compile(kotlin("stdlib-jdk8"))
}
repositories {
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
    mavenCentral()
}
val compileKotlin: KotlinCompile<KotlinJvmOptions> by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile<KotlinJvmOptions> by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}