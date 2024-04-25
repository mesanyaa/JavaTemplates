plugins {
    id("java")
}

group = "ru.sejapoe"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    flatDir {
        dirs("libs")
    }
}

allprojects {
    apply {
        plugin("java")
    }

    dependencies {
        // https://mvnrepository.com/artifact/org.projectlombok/lombok
        compileOnly("org.projectlombok:lombok:1.18.30")
        annotationProcessor("org.projectlombok:lombok:1.18.30")

        // https://mvnrepository.com/artifact/org.apache.commons/commons-collections4
        implementation("org.apache.commons:commons-collections4:4.4")

        // https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
        implementation("org.apache.commons:commons-lang3:3.14.0")

        // https://mvnrepository.com/artifact/com.google.guava/guava
        implementation("com.google.guava:guava:33.1.0-jre")

        testImplementation(platform("org.junit:junit-bom:5.9.1"))
        testImplementation("org.junit.jupiter:junit-jupiter")
    }

    tasks.test {
        useJUnitPlatform()
    }
}