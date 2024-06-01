package agh.ics.oop.presenter;

import agh.ics.oop.model.MapChangeListener;
import agh.ics.oop.model.WorldMap;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SimulationPresenter implements MapChangeListener {
    private WorldMap map;

    @FXML
    private Label infoLabel; // Kontrolka Label z FXML

    public void setWorldMap(WorldMap map) {
        this.map = map;
        map.addObserver(this); // Dodanie obserwatora
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        drawMap(); // Aktualizacja widoku po każdej zmianie
    }

    public void drawMap() {
        // Na razie ustawia zawartość mapy jako tekst w infoLabel
        if (map != null) {
            infoLabel.setText(map.toString());
        }
    }

    // Dodatkowe metody, które będą wykorzystywać mapę, np. do aktualizacji widoku
}

