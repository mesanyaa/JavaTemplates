import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("java")
    id("org.springframework.boot") version "3.2.4"
}

group = "ru.sejapoe"
version = "1.0-SNAPSHOT"

springBoot {
    mainClass = "ru.sejapoe.Main"
}

//tasks.withType<BootJar>() {
//    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
//    manifest {
//        attributes["Main-Class"] = "ru.sejapoe.Main"
//    }
//}

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter
    implementation("org.springframework.boot:spring-boot-starter:3.2.4")
}

tasks.test {
    useJUnitPlatform()
}
