package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{
    public int counter = 0;
    @Override
    public synchronized void mapChanged(WorldMap worldMap, String message){
        System.out.println("Map ID: " + worldMap.getId());
        System.out.println(message);
        System.out.println(counter + " changes so far");
        System.out.println(worldMap);
        counter += 1;
    }
}
