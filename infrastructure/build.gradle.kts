plugins {
    java
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter")
    implementation(project(":domain"))
}