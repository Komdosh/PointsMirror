package pro.komdosh.builder.implementation;


import pro.komdosh.builder.api.PointsBuilder;
import pro.komdosh.builder.model.Point;

import java.util.ArrayList;
import java.util.List;

public class PointsBuilderImp implements PointsBuilder {
    private int count;
    private List<Point> random = new ArrayList<>();
    private List<Point> mirror = new ArrayList<>();

    public PointsBuilderImp(int count) {
        this.count = count;
    }

    @Override
    public List<Point> getRandom() {
        if (random.isEmpty()) {
            random = getRandom(count);
        }
        return random;
    }

    private List<Point> getRandom(int count) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            points.add(new Point());
        }
        return points;
    }

    @Override
    public List<Point> getMirror() {
        if (mirror.isEmpty()) {
            mirror = getMirror(count);
        }
        return mirror;
    }

    private List<Point> getMirror(int count) {
        List<Point> points = new ArrayList<>();
        final int halfCount = count / 2;
        for (int i = 0; i < halfCount; ++i) {
            Point p0 = new Point();
            Point p1 = new Point(p0);

            p1.x = -p1.x;

            points.add(p0);
            points.add(p1);
        }
        return points;
    }
}
