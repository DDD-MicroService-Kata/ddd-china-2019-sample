plugins {
    java
    application
    id("org.springframework.boot") version "2.1.8.RELEASE"
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
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter")
    runtimeOnly("mysql:mysql-connector-java")
    implementation("org.flywaydb:flyway-core")
    implementation(project(":application"))
    implementation(project(":infrastructure"))

    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.flywaydb.flyway-test-extensions:flyway-spring-test")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("io.rest-assured:rest-assured")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "junit")
    }
    testImplementation(project(":domain"))
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}

