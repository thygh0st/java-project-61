plugins {
    id("se.patrikerdes.use-latest-versions") version "0.2.18"
    id("com.github.ben-manes.versions") version "0.52.0"
    application
    checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("hexlet.code.App")
}

//dependencies {
//}

//tasks.test {
//    useJUnitPlatform()
//}

// для запуска через `run`, иначе NoSuchElementException
tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}
