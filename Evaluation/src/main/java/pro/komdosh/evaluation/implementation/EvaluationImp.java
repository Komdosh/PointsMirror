package pro.komdosh.evaluation.implementation;

import pro.komdosh.builder.model.Point;
import pro.komdosh.evaluation.api.Evaluation;
import pro.komdosh.evaluation.api.HorizontalEvaluation;
import pro.komdosh.evaluation.api.VerticalEvaluation;

import java.util.List;

public class EvaluationImp implements Evaluation {
    private VerticalEvaluation verticalEvaluation;
    private HorizontalEvaluation horizontalEvaluation;

    public EvaluationImp(List<Point> points) {
        verticalEvaluation = new VerticalEvaluationImp(points);
        horizontalEvaluation = new HorizontalEvaluationImp(points);
    }

    @Override
    public double getHorizontalMirrorLinePos() {
        return horizontalEvaluation.getHorizontalMirrorLinePos();
    }

    @Override
    public boolean isHorizontalMirrored() {
        return horizontalEvaluation.isHorizontalMirrored();
    }

    @Override
    public double getVerticalMirrorLinePos() {
        return verticalEvaluation.getVerticalMirrorLinePos();
    }

    @Override
    public boolean isVerticalMirrored() {
        return verticalEvaluation.isVerticalMirrored();
    }
}
