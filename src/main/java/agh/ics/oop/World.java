package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args) {
        try {
            List<Simulation> simulations = new ArrayList<>();

            String[] moves = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f"};
            List<MoveDirection> directions = OptionsParser.parse(moves);
            List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));

            ConsoleMapDisplay observer = new ConsoleMapDisplay();

            for (int i = 0; i < 1000; i++) {
                RectangularMap map = new RectangularMap(10, 10);
                map.addObserver(observer);
                simulations.add(new Simulation(directions, positions, map));
            }

            SimulationEngine engine = new SimulationEngine(simulations);
//            try{
//                engine.runAsync();
//            }catch (InterruptedException e){System.out.println(e.getMessage());}

            engine.runAsyncInThreadPool();

            try {
                engine.awaitSimulationsEnd();
            }catch (InterruptedException e){System.out.println(e.getMessage());}

            System.out.println("Wszystkie symulacje zakończone.");

        } catch (IllegalArgumentException e) {System.out.println(e.getMessage());}
    }


    public static void run(List<MoveDirection> directions) {
        System.out.println();
        if (!directions.isEmpty()) {  // zmieniamy sprawdzenie z directions.length na directions.isEmpty()
            for (MoveDirection direction : directions) {
                switch (direction) {
                    case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                    case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                    case RIGHT -> System.out.println("Zwierzak idzie w prawo");
                    case LEFT -> System.out.println("Zwierzak idzie w lewo");
                }
            }
            System.out.println();
        }
    }
}
