plugins {
    java
    kotlin("jvm") version "1.4.32"
    kotlin("plugin.spring") version "1.4.32"
    `maven-publish`
}

group = "de.thm.mni.microservices.gruppe6"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenLocal()
    mavenCentral()
}

publishing {
    publications {
        create<MavenPublication>("service-lib") {
            from(components["java"])
            artifactId = "service-lib"
        }
    }
    repositories {
        mavenLocal()
    }
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    api("org.springframework.security:spring-security-core:5.4.6")
    api("org.springframework:spring-web:5.3.8")
    api("org.springframework.data:spring-data-r2dbc:1.2.9")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    api("io.jsonwebtoken:jjwt-impl:0.11.2")
    api("io.jsonwebtoken:jjwt-jackson:0.11.2")
}
