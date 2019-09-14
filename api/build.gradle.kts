plugins {
    java
    application
    id("org.springframework.boot") version "2.1.7.RELEASE"
}

application {
    mainClassName = "com.victory.ddd.china.sample.api.App"
}


repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-jersey")

    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("io.rest-assured:rest-assured")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "junit")
    }
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}

