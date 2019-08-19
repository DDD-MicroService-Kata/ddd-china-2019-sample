plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":purchase-order:resource"))
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}