val kotlin_version: String by extra
dependencies {
    api(project(":fuel"))
    implementation(Dependencies.kotlinStdlib)
    implementation(Dependencies.androidArchExtensions)
    testImplementation(Dependencies.robolectric)
    testImplementation(Dependencies.junit)
    testCompile(Dependencies.mockServer)
    compile(kotlinModule("stdlib-jdk7", kotlin_version))
}
apply {
    plugin("kotlin-android")
}
repositories {
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
    mavenCentral()
}