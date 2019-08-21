package pro.komdosh.builder.api;

import pro.komdosh.builder.model.Point;

import java.util.List;

public interface PointsBuilder {
    List<Point> getRandom();

    List<Point> getMirror();
}
