// Please, do not change this file!

// A class for representing points with integer coordinates in 2D.
// Please, do not change this class definition.
//
public class Point {
    private final int x, y;

    // Initializes this point with its coordinates.
    public Point(int x, int y) {

        this.x = x;
        this.y = y;
    }

    // Returns 'true' if 'this' and 'point' have the same coordinates. Otherwise, 'false' is
    // returned.
    public boolean isEqualTo(Point point) {
        return x == point.x && y == point.y;
    }

    // Returns the city block distance (Manhattan distance) between 'this' and 'p'.
    // Precondition: p != null.
    public int distanceTo(Point p) {

        int dX = this.x - p.x;
        int dY = this.y - p.y;
        dX = dX < 0 ? -dX : dX;
        dY = dY < 0 ? -dY : dY;
        return dX + dY;

    }

    @Override
    // Returns a string representation of this point.
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}
