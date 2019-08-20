rootProject.name = "PointsMirror"

include("Bootstrap", "PointsBuilder", "Evaluation")

val bootstrapProject = findProject(":Bootstrap")
val pointsBuilderProject = findProject(":PointsBuilder")
val evaluationProject = findProject(":Evaluation")

pointsBuilderProject?.apply{
    name = "PointsBuilder"
}

bootstrapProject?.apply{
    name = "Bootstrap"
}

evaluationProject?.apply {
    name = "Evaluation"
}
