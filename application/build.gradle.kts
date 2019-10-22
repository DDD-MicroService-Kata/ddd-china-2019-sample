plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":infrastructure"))
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
}
