package pro.komdosh.evaluation;

import pro.komdosh.builder.api.PointsBuilder;
import pro.komdosh.builder.implementation.PointsBuilderImp;
import pro.komdosh.evaluation.api.Evaluation;
import pro.komdosh.evaluation.implementation.EvaluationImp;
import pro.komdosh.printer.api.Printer;
import pro.komdosh.printer.implementation.PrinterImp;

public class Bootstrap {
    public static void main(String[] args) {
        PointsBuilder p = new PointsBuilderImp(10);
        Evaluation e = new EvaluationImp();
        Printer printer = new PrinterImp(p.getMirror());
        printer.print();
    }
}
