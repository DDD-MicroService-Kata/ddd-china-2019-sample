plugins {
    idea
    java
}

subprojects {
    version = "1.1"
    apply(plugin = "java")

    repositories {
        jcenter()
        mavenCentral()
    }

    dependencies {
        constraints {
            testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")
            testImplementation("io.rest-assured:rest-assured:4.0.0")
            testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.2")
            testImplementation("org.flywaydb.flyway-test-extensions:flyway-spring-test:6.0.0")
            implementation("org.springframework.boot:spring-boot-dependencies:2.1.8.RELEASE")
            implementation("com.google.guava:guava:28.0-jre")
            implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.0")
            implementation("javax.inject:javax.inject:1")
            implementation("org.flywaydb:flyway-core:5.2.4")
            implementation("io.jsonwebtoken:jjwt:0.9.1")
            runtimeOnly("mysql:mysql-connector-java:8.0.17")
        }
    }

    dependencies {
        implementation(platform("org.springframework.boot:spring-boot-dependencies"))
        implementation("com.google.guava:guava")
        implementation("javax.inject:javax.inject")
        implementation("org.apache.commons:commons-lang3:3.1")

        annotationProcessor("org.projectlombok:lombok:1.18.10")
        compileOnly("org.projectlombok:lombok:1.18.10")
        testCompileOnly("org.projectlombok:lombok:1.18.10")
        testAnnotationProcessor("org.projectlombok:lombok:1.18.10")
    }

    configure<JavaPluginConvention> {
        sourceCompatibility = JavaVersion.VERSION_11
    }
}
