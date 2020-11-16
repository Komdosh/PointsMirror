plugins {
    java
}

val moduleName by project.extra("printer")

dependencies {
    implementation(project(":PointsBuilder"))
    testCompileOnly("junit", "junit", "4.12")
}
