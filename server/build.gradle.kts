import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.2.31"
    id("org.springframework.boot") version "2.0.0.RELEASE"
    id("org.jetbrains.kotlin.jvm") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.jpa") version kotlinVersion
    id("io.spring.dependency-management") version "1.0.4.RELEASE"
    idea
    eclipse
}

version = "1.0.0-SNAPSHOT"

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}

repositories {
    mavenCentral()
}

dependencies {

    compile("org.springframework.boot:spring-boot-starter-data-jpa")
    compile("org.springframework.boot:spring-boot-starter-data-rest")
    compile("org.springframework.boot:spring-boot-starter-jdbc")
    compile("org.springframework.boot:spring-boot-starter-security")
    compile("org.springframework.boot:spring-boot-starter-web")
    compile("org.springframework.boot:spring-boot-starter-websocket")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin")
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compile("org.jetbrains.kotlin:kotlin-reflect")
    runtime("org.springframework.boot:spring-boot-devtools")
    runtime("com.h2database:h2")
    testCompile("org.springframework.restdocs:spring-restdocs-mockmvc")
    testCompile("org.springframework.security:spring-security-test")
    testCompile("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "junit")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}
