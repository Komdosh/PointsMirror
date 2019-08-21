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
    private char[][] matrix;

    public PrinterImp(List<Point> points) {
        MatrixInfo infoWidth = getMatrixOffset(points, p -> p.x);
        width = infoWidth.getLength();
        offsetX = infoWidth.offset;

        MatrixInfo infoHeight = getMatrixOffset(points, p -> p.y);
        height = infoHeight.getLength();
        offsetY = infoHeight.offset;

        matrix = new char[height][width];
        fillMatrix(matrix, points);
    }

    @Override
    public void print() {
        System.out.println("--------------------");
        for (int row = 0; row < height; ++row) {
            System.out.printf("%d  ", row);
            for (int column = 0; column < width; ++column) {
                System.out.printf("%c  ", matrix[row][column]);
            }
            System.out.println();

            if (row + 1 == height) {
                System.out.printf("   ");
                for (int column = 0; column < width; ++column) {
                    System.out.printf("%d  ", column);
                }
                System.out.println();
            }
        }
        System.out.println("--------------------");
    }

    private void fillMatrix(char[][] matrix, List<Point> points) {
        points.forEach(p -> matrix[offsetY + p.y][offsetX + p.x] = 'x');
    }

    private MatrixInfo getMatrixOffset(List<Point> points, final ToIntFunction<Point> pointToIntFunction) {
        IntSummaryStatistics stat = points.stream().mapToInt(pointToIntFunction).summaryStatistics();
        int min = stat.getMin();
        int max = stat.getMax();
        final int minOffset = (min < 0 ? Math.abs(min) : min);
        return new MatrixInfo(max, min, minOffset);
    }

    private class MatrixInfo {
        int max;
        int min;
        int offset;

        public MatrixInfo(int max, int min, int offset) {
            this.max = max;
            this.min = min;
            this.offset = offset;
        }

        private int getLength() {
            return max + offset + 1;
        }
    }
}
