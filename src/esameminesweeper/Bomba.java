/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esameminesweeper;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author MartinaDeCet
 */
public class Bomba extends Casella {

    Circle bomba;
    static boolean sbirciaBomba = false;

    public Bomba(int i, int j, GameArea gameArea) {
        super(i, j, gameArea);
        bomba = new Circle(10);
        bomba.setFill(Color.RED);
        bomba.setStroke(Color.BLACK);
        setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: blue");
    }

    @Override
    public void manageClick() {

        if (sbirciaBomba) {
            System.out.println("entrato in sbircia bomba");
            Label eccoLaBomba = new Label("Questa casella è una bomba");
            StackPane bombaPane = new StackPane();
            bombaPane.getChildren().add(eccoLaBomba);
            Scene scene = new Scene(bombaPane, 200, 200);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            sbirciaBomba = false;
            Inoffensiva.sbirciaInoffensiva = false;
            gameArea.sbircia.setDisable(true);
        } else {
            
        setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: yellow");
        this.getChildren().add(bomba);
        this.setDisable(true);
            Label haiPerso = new Label("HAI PERSO");
            StackPane perso = new StackPane();
            perso.getChildren().add(haiPerso);
            Scene scene = new Scene(perso, 200, 200);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    gameArea.initialize();
                }

            });

            stage.show();
        }
        
        /* QUESTO SAREBBE FIGO PER CHIUDERE, QUI NON RICHIESTO
        stage.setOnCloseRequest(new EventHandler<WindowEvent>(){
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
            }
            
        });
         */

    }

}
