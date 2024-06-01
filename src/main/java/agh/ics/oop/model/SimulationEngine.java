package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {
    private final List<Simulation> simulations;
    private ExecutorService executorService;

    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
    }

    public void runAsyncInThreadPool() {
        executorService = Executors.newFixedThreadPool(4);

        for (Simulation simulation : simulations) {
            executorService.submit(simulation::run);
        }

        executorService.shutdown();
    }

    public void awaitSimulationsEnd() throws InterruptedException {
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }

    public void runAsync() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        // Uruchamianie wszystkich symulacji w osobnych wątkach
        for (Simulation simulation : simulations) {
            Thread thread = new Thread(simulation::run);
            thread.start();
            threads.add(thread);
        }

        // Czekanie na zakończenie każdego z wątków
        for (Thread thread : threads) {
            thread.join();
        }
    }


    public void runSync(){
        for (Simulation simulation : simulations) {
            simulation.run();
        }
    }
}

