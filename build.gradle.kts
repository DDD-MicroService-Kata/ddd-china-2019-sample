plugins {
    idea
    java
}

subprojects {
    version = "1.1"
//    apply(plugin = "org.springframework.boot")
    apply(plugin = "java")

    repositories {
        jcenter()
    }

    dependencies {
        constraints {
            testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")
            testImplementation("io.rest-assured:rest-assured:4.0.0")
            testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.2")
            implementation("org.springframework.boot:spring-boot-dependencies:2.1.7.RELEASE")
            implementation("com.google.guava:guava:28.0-jre")
            implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.0")
        }
    }

    dependencies {
        implementation(platform("org.springframework.boot:spring-boot-dependencies"))
        implementation("com.google.guava:guava")
    }

    configure<JavaPluginConvention> {
        sourceCompatibility = JavaVersion.VERSION_11
    }
}
