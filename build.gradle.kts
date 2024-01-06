plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.22"
}

group = "io.github.dmitrytsyvtsyn.algorithmsdesignpatterns"
version = "1.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation("junit:junit:4.13.1")
}