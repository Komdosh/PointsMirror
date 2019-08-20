plugins {
    java
}

dependencies {
    compile(project(":PointsBuilder"))
    testCompile("junit", "junit", "4.12")
}

val moduleName by project.extra("bootstrap")
