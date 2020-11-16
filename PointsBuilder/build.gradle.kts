plugins {
    java
}

val moduleName by project.extra("pointsBuilder")

dependencies {
    testCompileOnly("junit", "junit", "4.12")
}
