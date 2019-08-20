package pro.komdosh.points.builder.implementation;


import pro.komdosh.points.builder.api.PointsBuilder;
import pro.komdosh.points.builder.model.Point;

import java.util.Collections;
import java.util.List;

public class PointsBuilderImp implements PointsBuilder {
    public PointsBuilderImp() {
        Point p = new Point();
        System.out.println(p.toString());
    }

    @Override
    public List<Point> getRandomPointsList() {
        return Collections.emptyList();
    }

    @Override
    public List<Point> getMirrorPointsList() {
        return Collections.emptyList();
    }
}
