rootProject.name = "PointsMirror"



include("Bootstrap", "PointsBuilder", "Evaluation", "Printer")

val bootstrapProject = findProject(":Bootstrap")
val pointsBuilderProject = findProject(":PointsBuilder")
val evaluationProject = findProject(":Evaluation")
val printerProject = findProject(":Printer")

pointsBuilderProject?.apply{
    name = "PointsBuilder"
}

bootstrapProject?.apply{
    name = "Bootstrap"
}

evaluationProject?.apply {
    name = "Evaluation"
}

printerProject?.apply {
    name = "Printer"
}
