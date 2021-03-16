import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.20"
}

version = "0.0.1-SNAPSHOT"
allprojects {
    group = "com.nokinori.leetcode"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "kotlin")

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }
}