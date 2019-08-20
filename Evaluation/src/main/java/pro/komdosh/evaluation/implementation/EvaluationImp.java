package pro.komdosh.evaluation.implementation;

import pro.komdosh.evaluation.api.Evaluation;

public class EvaluationImp implements Evaluation {
    @Override
    public boolean isHorizontalMirrorLineExists() {
        return false;
    }

    @Override
    public boolean isVerticalMirrorLineExists() {
        return false;
    }
}
