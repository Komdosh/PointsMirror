package pro.komdosh.points.builder.api;

import pro.komdosh.points.builder.model.Point;

import java.util.List;

public interface PointsBuilder {
    List<Point> getRandomPointsList();

    List<Point> getMirrorPointsList();
}
