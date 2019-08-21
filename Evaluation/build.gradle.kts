plugins {
    java
}

val moduleName by project.extra("evaluation")

dependencies {
    compile(project(":PointsBuilder"))
    testCompile("junit", "junit", "4.12")
}
