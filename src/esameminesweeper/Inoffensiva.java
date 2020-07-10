/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esameminesweeper;

import static esameminesweeper.Bomba.sbirciaBomba;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author MartinaDeCet
 */
public class Inoffensiva extends Casella {

    Label labelBombe;
    static boolean sbirciaInoffensiva = false;

    public Inoffensiva(int i, int j, GameArea gameArea) {
        super(i, j, gameArea);
        labelBombe = new Label();
        setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: blue");
    }

    @Override
    public void manageClick() {
        setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: yellow");
        this.setDisable(true);

        if (sbirciaInoffensiva) {
            Label eccoInoffensiva = new Label("Questa casella è inoffensiva");
            StackPane inoffensivaPane = new StackPane();
            inoffensivaPane.getChildren().add(eccoInoffensiva);
            Scene scene = new Scene(inoffensivaPane, 200, 200);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            sbirciaInoffensiva = false;
            Bomba.sbirciaBomba = false;
            gameArea.sbircia.setDisable(true);
        } else {
            if (gameArea.celleDaScoprire > 0) {
                gameArea.labelCelleDascoprire.setText("Celle da scoprire:" + String.valueOf(--gameArea.celleDaScoprire));
            } else if (gameArea.celleDaScoprire == 0) {
                Label haiVinto = new Label("HAI VINTO, COMPLIMENTI!");
                StackPane vittoria = new StackPane();
                vittoria.getChildren().add(haiVinto);
                Scene scene = new Scene(vittoria, 200, 200);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        gameArea.initialize();
                    }

                });

            }
        }
        this.getChildren().add(labelBombe);
    }

}
