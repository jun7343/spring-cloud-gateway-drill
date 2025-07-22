import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

plugins {
    kotlin("jvm") version "2.1.21"
    kotlin("kapt") version "2.1.21"
    kotlin("plugin.spring") version "2.1.21"
    id("org.springframework.boot") version "3.5.3"
    id("io.spring.dependency-management") version "1.1.7"
}

repositories {
    mavenCentral()
}

subprojects {
    repositories {
        mavenCentral()
    }

    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.kapt")
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }

    dependencies {
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    }

    tasks.test {
        useJUnitPlatform()
    }

    kotlin {
        jvmToolchain(21)
    }

    tasks.jar {
        enabled = false
    }

    tasks.named<BootBuildImage>("bootBuildImage") {
        imageName.set("${project.name}:latest")
    }
}

tasks.register("gatewayWebmvcBuildImage") {
    group = "gateway-webmvc"

    dependsOn(
        ":gateway-config:bootBuildImage",
        ":gateway-webmvc:bootBuildImage",
        ":example-service:a-service:bootBuildImage",
        ":example-service:b-service:bootBuildImage",
        ":example-service:c-service:bootBuildImage"
    )
}

tasks.register("gatewayWebfluxBuildImage") {
    group = "gateway-webmvc"

    dependsOn(
        ":gateway-config:bootBuildImage",
        ":gateway-webflux:bootBuildImage",
        ":example-service:a-service:bootBuildImage",
        ":example-service:b-service:bootBuildImage",
        ":example-service:c-service:bootBuildImage"
    )
}