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
                        options.encoding = "UTF-8"
                        options.compilerArgs = listOf(
                                // include Gradle dependencies as modules
                                "--module-path", classpath.asPath
                        )
                        classpath = files()
                    }
                }
            }
        }
    }
}

val moduleName by project.extra("pointsMirror")
