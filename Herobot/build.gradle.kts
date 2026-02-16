plugins {
    id("java")
    id("application")
}

group = "com.herobot"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {

    // SQLite
    implementation("org.xerial:sqlite-jdbc:3.45.1.0")

    // Apache Commons Math
    implementation("org.apache.commons:commons-math3:3.6.1")

    // JSON
    implementation("org.json:json:20240303")
    implementation("org.json:json:20231013")

}

application {
    mainClass.set("Chatbot")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}
