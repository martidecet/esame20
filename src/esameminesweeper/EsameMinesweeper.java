/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esameminesweeper;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author MartinaDeCet
 */
public class EsameMinesweeper extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        GameArea root = new GameArea();
        
        EventHandler<KeyEvent> keyEventHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCharacter()) {
                    case "a":
                    case "A":
                        root.abbandona.fireEvent(new ActionEvent());
                        root.abbandona.requestFocus();
                        break;
                    case "r":
                    case "R":
                        root.random.fireEvent(new ActionEvent());
                        root.random.requestFocus();
                        break;
                    case "s":
                    case "S":
                        root.sbircia.fireEvent(new ActionEvent());
                        root.sbircia.requestFocus();
                        break;
                    case "t":
                    case "T":
                        root.test.fireEvent(new ActionEvent());
                        root.test.requestFocus();
                        break;
                }
            }
        };
        
        Scene scene = new Scene(root, 700, 700);
        
        primaryStage.addEventHandler(KeyEvent.KEY_TYPED, keyEventHandler);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
