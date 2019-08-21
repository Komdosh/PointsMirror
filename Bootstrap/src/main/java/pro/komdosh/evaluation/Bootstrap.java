package pro.komdosh.evaluation;

import pro.komdosh.builder.api.PointsBuilder;
import pro.komdosh.builder.implementation.PointsBuilderImp;
import pro.komdosh.evaluation.api.Evaluation;
import pro.komdosh.evaluation.implementation.EvaluationImp;
import pro.komdosh.printer.api.Printer;
import pro.komdosh.printer.implementation.PrinterImp;

public class Bootstrap {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; ++i) {
            PointsBuilder p = new PointsBuilderImp(10);
            Evaluation e = new EvaluationImp(p.getMirror());
            Printer printer = new PrinterImp(p.getMirror(), e.getVerticalMirrorLinePos(), e.getHorizontalMirrorLinePos());
            printer.showOnlyExists();
            printer.print();
        }
    }
}
