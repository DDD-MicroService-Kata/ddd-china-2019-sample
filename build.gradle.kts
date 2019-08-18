plugins {
    java

    application
   
    idea

    id("org.springframework.boot") version "2.1.7.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
}

repositories {
    jcenter()
}

dependencies {
    implementation("com.google.guava:guava:28.0-jre")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-hateoas")
    implementation("org.springframework.boot:spring-boot-starter-jersey")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.0")
    implementation("org.springframework.boot:spring-boot-actuator")


    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.2")
}

application {
    mainClassName = "com.victory.ddd.china.sample.App"
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}
