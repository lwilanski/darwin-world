package agh.ics.oop.model;

public class RectangularMap extends AbstractWorldMap {
    private final int height;
    private final int width;
    public RectangularMap(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(width, height)) && position.precedes(new Vector2d(0, 0)) && !isOccupied(position);
    }

    @Override
    public Boundary getCurrentBounds() {
        return new Boundary(new Vector2d(0, 0), new Vector2d(width, height));
    }
}
