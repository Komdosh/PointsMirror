package pro.komdosh.evaluation.implementation;

import pro.komdosh.builder.model.Point;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

public abstract class AbstractEvaluation {
    protected List<Point> points;
    private LineDirection lineDirection;
    private List<Point> left;
    private List<Point> right;
    private double medianFromZero;
    private double median;

    public AbstractEvaluation(List<Point> points, LineDirection lineDirection) {
        this.points = List.copyOf(points);
        this.lineDirection = lineDirection;

        final int initialCapacity = points.size();
        left = new ArrayList<>(initialCapacity);
        right = new ArrayList<>(initialCapacity);

        switch (lineDirection) {
            case VERTICAL:
                setMedianWithOffset(points, p -> p.x);
                separateListByPredicates(p -> p.x < median, p -> p.x > median);
                break;
            case HORIZONTAL:
                setMedianWithOffset(points, p -> p.y);
                separateListByPredicates(p -> p.y < median, p -> p.y > median);
                break;
        }
    }

    protected double getMedianPos() {
        if (IsMedianMirrored()) {
            return medianFromZero;
        } else {
            return -1;
        }

    }

    protected boolean IsMedianMirrored() {
        if (left.size() != right.size()) {
            return false;
        }

        Comparator<Point> comparator = getPointComparator();

        left.sort(comparator);
        right.sort(comparator);

        int size = left.size();
        for (int i = 0; i < size; ++i) {
            final Point leftPoint = left.get(i);
            final Point rightPoint = right.get(i);

            if (pointIsNotMirrored(leftPoint.x, rightPoint.x, LineDirection.VERTICAL)) return false;

            if (pointIsNotMirrored(leftPoint.y, rightPoint.y, LineDirection.HORIZONTAL))
                return false;
        }
        return true;
    }

    private boolean pointIsNotMirrored(double firstCord, double secondCord, LineDirection lineDirection) {
        double first = firstCord;
        double second = secondCord;

        if (this.lineDirection == lineDirection) {
            first = distanceFromMedian(first);
            second = distanceFromMedian(second);
        }

        return first != second;
    }

    private double distanceFromMedian(double cord) {
        return Math.abs(cord - median);
    }

    private Comparator<Point> getPointComparator() {
        Comparator<Point> comparator = null;
        switch (lineDirection) {
            case VERTICAL:
                comparator = Comparator.comparing(p -> p.y);
                break;
            case HORIZONTAL:
                comparator = Comparator.comparing(p -> p.x);
                break;
        }
        return comparator;
    }

    private void separateListByPredicates(Predicate<Point> lesserCondition, Predicate<Point> greaterCondition) {
        for (Point p : points) {
            if (lesserCondition.test(p)) {
                left.add(p);
            } else if (greaterCondition.test(p)) {
                right.add(p);
            }
        }
    }

    private void setMedianWithOffset(List<Point> points, final ToDoubleFunction<Point> pointToDoubleFunction) {
        DoubleSummaryStatistics stat = points.stream().mapToDouble(pointToDoubleFunction).summaryStatistics();
        double min = stat.getMin();
        double max = stat.getMax();
        double offset = (min < 0 ? Math.abs(min) : min);
        medianFromZero = (Math.abs(max) + Math.abs(min)) / 2;
        median = medianFromZero - offset;
    }

    protected enum LineDirection {
        VERTICAL, HORIZONTAL
    }
}
