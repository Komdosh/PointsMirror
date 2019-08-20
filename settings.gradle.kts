rootProject.name = "PointsMirror"

include("Bootstrap", "PointsBuilder")

val bootstrapProject = findProject(":Bootstrap")
val pointsBuilderProject = findProject(":PointsBuilder")

pointsBuilderProject?.apply{
    name = "PointsBuilder"
}

bootstrapProject?.apply{
    name = "Bootstrap"
}
