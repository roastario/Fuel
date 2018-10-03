import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins { java
    kotlin("jvm")
}

dependencies {
    compile(project(":fuel"))
    compile(Dependencies.forge)
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