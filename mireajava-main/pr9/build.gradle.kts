plugins {
    id("java")
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
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register("doStuff") {
    dependsOn(tasks["build"])

    doLast {
        val dockerDir = File(projectDir, "dedicated")
        val jarFile = File(buildDir, "libs").listFiles()?.find { it.name.endsWith(".jar") }

        if (jarFile == null || !jarFile.exists()) {
            println("Jar file is not found.")
            return@doLast
        }

        jarFile.copyTo(File(dockerDir, "app.jar"), overwrite = true)

        exec {
            workingDir = dockerDir
            commandLine("docker", "build", "-t", "some-pr9", '.')
        }

        exec {
            workingDir = dockerDir
            commandLine("docker", "run", "some-pr9")
        }
    }
}