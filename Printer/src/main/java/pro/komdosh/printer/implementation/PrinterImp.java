package pro.komdosh.printer.implementation;


import pro.komdosh.builder.model.Point;
import pro.komdosh.printer.api.Printer;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.ToDoubleFunction;

public class PrinterImp implements Printer {

    private int width;
    private int height;
    private double offsetX;
    private double offsetY;
    private MatrixChars[][] matrix;

    private double verticalPosition;
    private double horizontalPosition;
    private boolean showOnlyExists = false;

    public PrinterImp(List<Point> points) {
        MatrixInfo infoWidth = getMatrixInfo(points, p -> p.x);
        width = infoWidth.getLength();
        offsetX = infoWidth.offset;

        MatrixInfo infoHeight = getMatrixInfo(points, p -> p.y);
        height = infoHeight.getLength();
        offsetY = infoHeight.offset;

        matrix = new MatrixChars[height][width];
        fillMatrix(matrix, points);
    }

    public PrinterImp(List<Point> points, int verticalLinePos) {
        this(points);
        if (verticalLinePos > -1) {
            setVerticalLine(verticalLinePos);
        }
    }

    public PrinterImp(List<Point> points, double verticalLinePos, double horizontalLinePos) {
        this(points);
        verticalPosition = verticalLinePos;
        if (verticalLinePos > -1) {
            setVerticalLine((int) verticalLinePos);
        }
        horizontalPosition = horizontalLinePos;
        if (horizontalLinePos > -1) {
            setHorizontalLine((int) horizontalLinePos);
        }
    }

    public void showOnlyExists() {
        this.showOnlyExists = true;
    }

    public void setVerticalLine(int pos) {
        for (int row = 0; row < height; ++row) {
            printLine(pos, row, MatrixChars.verticalLine, MatrixChars.verticalCross);
        }
    }

    public void setHorizontalLine(int pos) {
        for (int column = 0; column < width; ++column) {
            printLine(column, pos, MatrixChars.horizontalLine, MatrixChars.horizontalCross);
        }
    }

    private void printLine(int column, int row, MatrixChars line, MatrixChars cross) {
        final MatrixChars[] matrixRow = this.matrix[row];
        if (matrixRow[column] == MatrixChars.point) {
            matrixRow[column] = cross;
        } else {
            matrixRow[column] = line;
        }
    }

    @Override
    public void print() {
        if (showOnlyExists && verticalPosition == -1 && horizontalPosition == -1) {
            return;
        }
        System.out.println("=============================================");
        System.out.println("-----");
        System.out.printf("Vertical line exists: %b\n", verticalPosition != -1);
        System.out.printf("Vertical line pos: %f\n", verticalPosition);
        System.out.printf("Horizontal line exists: %b\n", horizontalPosition != -1);
        System.out.printf("Horizontal line pos: %f\n", horizontalPosition);
        System.out.println("-----");

        for (int row = 0; row < height; ++row) {
            for (int column = 0; column < width; ++column) {
                char printChar = ' ';
                if (matrix[row][column] != null) {
                    printChar = matrix[row][column].asChar;
                }
                System.out.printf("%c  ", printChar);
            }
            System.out.println();
        }

        System.out.println("=============================================");
    }

    private void fillMatrix(MatrixChars[][] matrix, List<Point> points) {
        points.forEach(p -> matrix[(int) (offsetY + p.y)][(int) (offsetX + p.x)] = MatrixChars.point);
    }

    private MatrixInfo getMatrixInfo(List<Point> points, final ToDoubleFunction<Point> pointToDoubleFunction) {
        DoubleSummaryStatistics stat = points.stream().mapToDouble(pointToDoubleFunction).summaryStatistics();
        double min = stat.getMin();
        double max = stat.getMax();
        final double minOffset = (min < 0 ? Math.abs(min) : min);
        return new MatrixInfo(max, min, minOffset);
    }

    private enum MatrixChars {
        empty(' '), point('*'), verticalLine('|'), horizontalLine('-'), verticalCross('+'), horizontalCross('+');

        private final char asChar;

        MatrixChars(char asChar) {
            this.asChar = asChar;
        }
    }

    private static class MatrixInfo {
        double max;
        double min;
        double offset;

        MatrixInfo(double max, double min, double offset) {
            this.max = max;
            this.min = min;
            this.offset = offset;
        }

        private int getLength() {
            return (int) (max + offset) + 1;
        }
    }
}
