package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;
import agh.ics.oop.presenter.SimulationPresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class SimulationApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("simulation.fxml"));
            BorderPane viewRoot = loader.load();
            SimulationPresenter presenter = loader.getController();

            WorldMap map = new RectangularMap(10, 10); // Możesz użyć GrassField lub innego typu mapy
            presenter.setWorldMap(map); // Ustawienie mapy w prezenterze
            String[] moves = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f"};
            List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
            List<MoveDirection> directions = OptionsParser.parse(moves);
            Simulation simulation = new Simulation(directions, positions, map);
            presenter.drawMap(); // Rysowanie mapy na ekranie
            configureStage(primaryStage, viewRoot);
            primaryStage.show();
        }catch (IOException e){e.printStackTrace();}
    }


    private void configureStage(Stage primaryStage, BorderPane viewRoot) {
        Scene scene = new Scene(viewRoot); // Tworzy nową scenę z widokiem uzyskanym z FXML
        primaryStage.setScene(scene); // Ustawia nową scenę w oknie aplikacji
        primaryStage.setTitle("Symulacja"); // Ustawia tytuł okna aplikacji
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty()); // Ustawia minimalną szerokość okna
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty()); // Ustawia minimalną wysokość okna
    }

}

