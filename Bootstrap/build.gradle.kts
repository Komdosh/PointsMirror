plugins {
    java
}

val moduleName by project.extra("bootstrap")

dependencies {
    implementation(project(":PointsBuilder"))
    implementation(project(":Evaluation"))
    implementation(project(":Printer"))
    testCompileOnly("junit", "junit", "4.12")
}


