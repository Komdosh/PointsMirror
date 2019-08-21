plugins {
    java
}

val moduleName by project.extra("pointsBuilder")

dependencies {
    compileOnly("org.projectlombok", "lombok", "1.18.8")
    compileOnly("org.mapstruct", "mapstruct-processor", "1.3.0.Final")
    annotationProcessor("org.projectlombok", "lombok", "1.18.8")
    testCompile("junit", "junit", "4.12")
}


