package pro.komdosh.builder.model;


import java.util.Random;

public class Point {
    private static final int RANDOM_BOUND = 10;
    private static final Random random = new Random();

    public double x = 0;
    public double y = 0;

    public Point() {
        randomize();
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        x = p.x;
        y = p.y;
    }

    private void randomize() {
        this.randomize(RANDOM_BOUND);
    }

    private void randomize(int bound) {
        this.x = getNextRandom(bound);
        this.y = getNextRandom(bound);
    }

    private int getNextRandom(int bound) {
        return random.nextInt(bound) - (RANDOM_BOUND / 2);
    }

    @Override
    public String toString() {
        return "Point{" +
            "x=" + x +
            ", y=" + y +
            '}';
    }
}
