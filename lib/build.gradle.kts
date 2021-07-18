plugins {
    id("org.springframework.boot") version "2.4.7"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
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
    api("org.springframework.security:spring-security-core")
    implementation("org.springframework.data:spring-data-r2dbc")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // This dependency is exported to consumers, that is to say found on their compile classpath.
    api("org.springframework.boot:spring-boot-starter-webflux")
    api("io.jsonwebtoken:jjwt-impl:0.11.2")
    api("io.jsonwebtoken:jjwt-jackson:0.11.2")
}
