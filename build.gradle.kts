plugins {
    java
}

allprojects {
    group = "pro.komdosh"
    version = "0.0.1"

    repositories {
        mavenCentral()
    }

    afterEvaluate {
        val project = this
        tasks {
            compileJava {
                if (JavaVersion.current() >= JavaVersion.VERSION_1_9) {
                    inputs.property("moduleName", project.extra["moduleName"])
                    doFirst {
                        classpath = files()

                        options.compilerArgs = listOf(
                                // include Gradle dependencies as modules
                                "--module-path", classpath.asPath,
                                "--add-modules", "lombok"
                        )
                    }
                }
            }
        }
    }
}

dependencies {
    implementation("org.projectlombok", "lombok", "1.18.8")
    implementation("org.mapstruct", "mapstruct-processor", "1.3.0.Final")
    annotationProcessor("org.projectlombok", "lombok", "1.18.8")
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_12
}

val moduleName by project.extra("pointsMirror")
