package agh.ics.oop.model;

public class Animal implements WorldElement {
    private MapDirection direction;
    private Vector2d position;
    public Animal() {
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }

    public Animal(Vector2d initialPosition) {
        this.direction = MapDirection.NORTH;
        this.position = initialPosition;
    }

    @Override
    public String toString() {
        return direction.toString();
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

//    public void move(MoveDirection direction) {
//        switch (direction) {
//            case RIGHT:
//                this.direction = this.direction.next();
//                break;
//            case LEFT:
//                this.direction = this.direction.previous();
//                break;
//            case FORWARD:
//                Vector2d newPosition1 = this.position.add(this.direction.toUnitVector());
//                if (isValidPosition(newPosition1)) {
//                    this.position = newPosition1;
//                }
//                break;
//            case BACKWARD:
//                Vector2d newPosition2 = this.position.subtract(this.direction.toUnitVector());
//                if (isValidPosition(newPosition2)) {
//                    this.position = newPosition2;
//                }
//                break;
//        }
//    }

    public void move(MoveDirection direction, MoveValidator moveValidator) {
        switch (direction) {
            case RIGHT:
                this.direction = this.direction.next();
                break;
            case LEFT:
                this.direction = this.direction.previous();
                break;
            case FORWARD:
                Vector2d newPosition1 = this.position.add(this.direction.toUnitVector());
                if (moveValidator.canMoveTo(newPosition1)) {
                    this.position = newPosition1;
                }
                break;
            case BACKWARD:
                Vector2d newPosition2 = this.position.subtract(this.direction.toUnitVector());
                if (moveValidator.canMoveTo(newPosition2)) {
                    this.position = newPosition2;
                }
                break;
        }
    }


    public boolean isValidPosition(Vector2d position) {
        return position.follows(new Vector2d(4, 4)) && position.precedes(new Vector2d(0, 0));
    }

    public MapDirection getDirection() {
        return direction;
    }

    public Vector2d getPosition() {
        return position;
    }
}

