package Entities;

/**
 *
 * Points refers to entries in a list of points. The starting index being 0.
 *
 */
public class Face {

    private int[] points;

    public Face(int a, int b, int c) {
        int[] face = new int[]{a, b, c};
        this.points = face;
    }

    public int[] getPoints() {
        return this.points;
    }
}
