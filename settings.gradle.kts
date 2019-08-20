rootProject.name = "PointsMirror"

include("Bootstrap", "PointsBuilder")

val bootstrapProject = findProject(":Bootstrap")
val pointsBuilderProject = findProject(":PointsBuilder")

pointsBuilderProject?.apply{
    name = "PointsBuilder"
    extra["moduleName"] = "pointsBuilder"
}

bootstrapProject?.apply{
    name = "Bootstrap"
    extra["moduleName"] = "bootstrap"
}
