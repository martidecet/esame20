/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esameminesweeper;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/**
 *
 * @author MartinaDeCet
 */
public abstract class Casella extends StackPane {

    int posCol = 0;
    int rigCol = 0;
    GameArea gameArea;

    public Casella(int i, int j, GameArea gameArea) {
        this.posCol = i;
        this.rigCol = j;
        this.gameArea = gameArea;
        
        setStyle("-fx-border-colo: #000000; -fx-border-width: 1px; -fx-background-color: blue");

        addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Casella source = (Casella) event.getSource();
                manageClick();
            }

        });

    }

    public abstract void manageClick();
    
}
