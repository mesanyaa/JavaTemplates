//plugins {
//    id("java")
//}

group = "ru.sejapoe"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    flatDir {
        dirs("libs")
    }
}

dependencies {
    // https://mvnrepository.com/artifact/org.slf4j/slf4j-api
    implementation("org.slf4j:slf4j-api:2.0.12")
    // https://mvnrepository.com/artifact/org.slf4j/slf4j-simple
    implementation("org.slf4j:slf4j-simple:2.0.12")

    implementation(fileTree(mapOf("dir" to "../lib", "include" to listOf("*.jar"))))
}