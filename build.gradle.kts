import org.gradle.internal.impldep.org.apache.maven.model.Build
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    var kotlin_version: String by extra
    kotlin_version = "1.2.41"

    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(kotlinModule("gradle-plugin", kotlin_version))
    }
}

group = "io.jivimberg"
version = "1.0-SNAPSHOT"

apply {
    plugin("kotlin")
}

plugins {
    java
}

val kotlin_version: String by extra

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlinModule("stdlib-jdk8", kotlin_version))
    compile("org.jetbrains.kotlin", "kotlin-script-runtime", kotlin_version)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks {
    "copy"(Copy::class) {
        from("src/main/kotlin/io/jivimberg/githook/pre-push.kts") {
            rename { it.removeSuffix(".kts") }
        }
        into(".git/hooks")
    }

    "build" {
        dependsOn("copy")
    }
}