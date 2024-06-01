package agh.ics.oop.model;

import java.util.UUID;

/**
 * The interface responsible for interacting with the map of the world.
 * Assumes that MoveDirection class is defined.
 *
 * @author apohllo, idzik
 * @param <T> The type of objects that can be placed on the map.
 * @param <P> The type of position on the map.
 */
public interface WorldMap<T extends WorldElement, P> extends MoveValidator<P> {

    /**
     * Place an object on the map.
     *
     * @param object The object to place on the map.
     * @return True if the object was placed. The object cannot be placed if the move is not valid.
     */
    void place(T object) throws PositionAlreadyOccupiedException;

    /**
     * Moves an object (if it is present on the map) according to specified direction.
     * If the move is not possible, this method has no effect.
     */
    void move(T object, MoveDirection direction);

    /**
     * Return true if given position on the map is occupied. Should not be
     * confused with canMove since there might be empty positions where the object
     * cannot move.
     *
     * @param position Position to check.
     * @return True if the position is occupied.
     */
    boolean isOccupied(P position);

    void addObserver(MapChangeListener observer);

    /**
     * Return an object at a given position.
     *
     * @param position The position of the object.
     * @return object or null if the position is not occupied.
     */
    WorldElement objectAt(P position);

    /**
     * Return map boundaries as Boundary
     */
    Boundary getCurrentBounds();

    UUID getId();
}
