dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("io.rest-assured:rest-assured")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "junit")
    }

    testImplementation(project(":purchase-order"))
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}