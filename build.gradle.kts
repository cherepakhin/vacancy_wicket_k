
plugins {
	id("org.springframework.boot") version "2.6.15"
//	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
}

group = "ru.perm.v"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web:2.6.15")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.2")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.0")
	implementation("com.google.code.gson:gson:2.8.9")

	testImplementation("org.junit.platform:junit-platform-launcher:1.9.3")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")

	testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.15")

	testImplementation("org.mockito:mockito-core:5.1.1")
	testImplementation("com.ninja-squad:springmockk:3.0.1")
	implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<Test> {
	useJUnitPlatform()
}
kotlin {
	jvmToolchain(11)
}