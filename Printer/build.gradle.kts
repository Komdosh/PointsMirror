plugins {
    java
}

val moduleName by project.extra("printer")

dependencies {
    compile(project(":PointsBuilder"))
    testCompile("junit", "junit", "4.12")
}
