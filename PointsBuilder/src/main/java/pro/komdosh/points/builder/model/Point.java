package pro.komdosh.points.builder.model;


import java.util.Random;

public class Point {
    public int x = 0;
    public int y = 0;

    public Point() {
        randomize();
    }

    public void randomize() {
        this.randomize(10);
    }

    public void randomize(int bound) {
        Random random = new Random();
        this.x = random.nextInt(bound);
        this.y = random.nextInt(bound);
    }

    @Override
    public String toString() {
        return "Point{" +
            "x=" + x +
            ", y=" + y +
            '}';
    }
}
