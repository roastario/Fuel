import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins { java
    kotlin("jvm") version "1.3.0-rc-116"
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
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}