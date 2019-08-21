package pro.komdosh.evaluation.implementation;

import pro.komdosh.builder.model.Point;
import pro.komdosh.evaluation.api.VerticalEvaluation;

import java.util.List;

public class VerticalEvaluationImp extends AbstractEvaluation implements VerticalEvaluation {

    public VerticalEvaluationImp(List<Point> points) {
        super(points, LineDirection.VERTICAL);
    }

    @Override
    public double getVerticalMirrorLinePos() {
        return getMedianPos();
    }

    @Override
    public boolean isVerticalMirrored() {
        return IsMedianMirrored();
    }
}
