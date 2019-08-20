plugins {
    java
}

val moduleName by project.extra("bootstrap")

dependencies {
    compile(project(":PointsBuilder"))
    compile(project(":Evaluation"))
    testCompile("junit", "junit", "4.12")
}


