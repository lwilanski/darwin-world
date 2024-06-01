package agh.ics.oop.model;

public enum MapDirection {
    NORTH(0, "N", 0, 1),
    EAST(1, "E", 1, 0),
    SOUTH(2, "S", 0, -1),
    WEST(3, "W", -1, 0);

    private final int index;
    private final String description;
    private final Vector2d vector;

    MapDirection(int index, String description, int x, int y) {
        this.index = index;
        this.description = description;
        this.vector = new Vector2d(x, y);
    }

    @Override
    public String toString() {
        return description;
    }

    public MapDirection next() {
        return values()[(this.index + 1) % values().length];
    }

    public MapDirection previous() {
        return values()[(this.index + values().length - 1) % values().length];
    }

    public Vector2d toUnitVector() {
        return vector;
    }
}
