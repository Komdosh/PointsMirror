package pro.komdosh.evaluation.implementation;

import pro.komdosh.builder.model.Point;
import pro.komdosh.evaluation.api.HorizontalEvaluation;

import java.util.List;

public class HorizontalEvaluationImp extends AbstractEvaluation implements HorizontalEvaluation {

    public HorizontalEvaluationImp(List<Point> points) {
        super(points, LineDirection.HORIZONTAL);
    }

    @Override
    public double getHorizontalMirrorLinePos() {
        return getMedianPos();
    }

    @Override
    public boolean isHorizontalMirrored() {
        return IsMedianMirrored();
    }
}
