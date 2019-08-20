package pro.komdosh.evaluation;

import pro.komdosh.evaluation.api.Evaluation;
import pro.komdosh.evaluation.implementation.EvaluationImp;
import pro.komdosh.points.builder.api.PointsBuilder;
import pro.komdosh.points.builder.implementation.PointsBuilderImp;

public class Bootstrap {
    public static void main(String[] args) {
        PointsBuilder p = new PointsBuilderImp();
        Evaluation e = new EvaluationImp();
        System.out.println(p);
        System.out.println(e);
    }
}
