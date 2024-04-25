plugins {
    id("java")
    id("org.springframework.boot") version "3.2.4"
}

group = "ru.sejapoe"
version = "1.0-SNAPSHOT"

tasks.withType<Jar>() {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
        attributes["Main-Class"] = "ru.sejapoe.Main"
    }
}

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
