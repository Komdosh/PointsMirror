plugins {
    java
}

val moduleName by project.extra("bootstrap")

dependencies {
    compile(project(":PointsBuilder"))
    compile(project(":Evaluation"))
    compile(project(":Printer"))
    testCompile("junit", "junit", "4.12")
}


