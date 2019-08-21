package pro.komdosh.printer.implementation;


import pro.komdosh.builder.model.Point;
import pro.komdosh.printer.api.Printer;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.ToIntFunction;

public class PrinterImp implements Printer {

    private int width;
    private int height;
    private int offsetX;
    private int offsetY;
    private MatrixChars[][] matrix;

    public PrinterImp(List<Point> points) {
        MatrixInfo infoWidth = getMatrixOffset(points, p -> p.x);
        width = infoWidth.getLength();
        offsetX = infoWidth.offset;

        MatrixInfo infoHeight = getMatrixOffset(points, p -> p.y);
        height = infoHeight.getLength();
        offsetY = infoHeight.offset;

        matrix = new MatrixChars[height][width];
        fillMatrix(matrix, points);
    }

    public PrinterImp(List<Point> points, int verticalLinePos) {
        this(points);
        setVerticalLine(verticalLinePos);
    }

    public PrinterImp(List<Point> points, int verticalLinePos, int horizontalLinePos) {
        this(points);
        setVerticalLine(verticalLinePos);
        setHorizontalLine(horizontalLinePos);
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
        System.out.println("=============================================");

        for (int row = 0; row < height; ++row) {
            printYAxis(row, "%d  ");
            for (int column = 0; column < width; ++column) {
                char printChar = ' ';
                if (matrix[row][column] != null) {
                    printChar = matrix[row][column].asChar;
                }
                System.out.printf("%c  ", printChar);
            }
            System.out.println();

            printXAxis(row);
        }
        System.out.println("==============================================");
    }

    private void printYAxis(int row, String s) {
        System.out.printf(s, row);
    }

    private void printXAxis(int row) {
        if (row + 1 == height) {
            System.out.printf("   ");
            for (int column = 0; column < width; ++column) {
                System.out.printf("%d  ", column);
            }
            System.out.println();
        }
    }

    private void fillMatrix(MatrixChars[][] matrix, List<Point> points) {
        points.forEach(p -> matrix[offsetY + p.y][offsetX + p.x] = MatrixChars.point);
    }

    private MatrixInfo getMatrixOffset(List<Point> points, final ToIntFunction<Point> pointToIntFunction) {
        IntSummaryStatistics stat = points.stream().mapToInt(pointToIntFunction).summaryStatistics();
        int min = stat.getMin();
        int max = stat.getMax();
        final int minOffset = (min < 0 ? Math.abs(min) : min);
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
        int max;
        int min;
        int offset;

        MatrixInfo(int max, int min, int offset) {
            this.max = max;
            this.min = min;
            this.offset = offset;
        }

        private int getLength() {
            return max + offset + 1;
        }
    }
}
