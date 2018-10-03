
dependencies {
    api(project(":fuel"))
    implementation(Dependencies.kotlinStdlib)
    testImplementation(Dependencies.robolectric)
    testImplementation(Dependencies.junit)
    testCompile(Dependencies.mockServer)
    compile(kotlin("stdlib-jdk7", Versions.kotlinVersion))
}
apply {
    plugin("kotlin-android")
}
repositories {
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
    mavenCentral()
}