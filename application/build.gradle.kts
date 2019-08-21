plugins {
    java
    application
    id("org.springframework.boot") version "2.1.7.RELEASE"
}

application {
    mainClassName = "com.victory.ddd.china.sample.application.App"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    implementation(project(":purchase-order"))
}

