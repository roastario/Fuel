
import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins { java
    kotlin("jvm") version "1.3.0-rc-116"
}

dependencies {
    compile(project(":fuel"))
    compile(project( Dependencies.kotlinCoroutinesJvm))
    testCompile(Dependencies.mockServer)
    compile(kotlin("stdlib-jdk8"))
}

configure<KotlinJvmProjectExtension> {
    experimental.coroutines = Coroutines.ENABLE
}
repositories {
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
    mavenCentral()
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}