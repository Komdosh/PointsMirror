plugins {
    java
}

val moduleName by project.extra("evaluation")

dependencies {
    implementation(project(":PointsBuilder"))
    testCompileOnly("junit", "junit", "4.12")
}
