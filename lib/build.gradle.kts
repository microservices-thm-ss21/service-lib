plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.20"
    java
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
    implementation("org.springframework.security:spring-security-core:5.4.6")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc:2.4.5")



    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // This dependency is exported to consumers, that is to say found on their compile classpath.
    api("org.springframework.boot:spring-boot-starter-webflux:2.4.5")
    api("io.jsonwebtoken:jjwt-impl:0.11.2")
    api("io.jsonwebtoken:jjwt-jackson:0.11.2")
}
