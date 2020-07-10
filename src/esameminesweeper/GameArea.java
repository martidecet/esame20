/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esameminesweeper;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;

/**
 *
 * @author MartinaDeCet
 */
public class GameArea extends BorderPane {

    Scacchiera scacchiera;
    Button test;
    Button random;
    Button sbircia;
    Button abbandona;
    Label labelCelleDascoprire;
    TilePane contenitoreVario;
    int celleDaScoprire;

    public GameArea() {
        initialize();

    }

    public void initialize() {
        
        scacchiera = new Scacchiera(this);        
        this.setCenter(scacchiera);
        celleDaScoprire = 71;
        
        test = new Button("Test");
        test.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                test.setDisable(true);
                random.setDisable(true);
                sbircia.setDisable(false);
                abbandona.setDisable(false);
                scacchiera.buttonTest();
            }

        });
        
        random = new Button("Random");
        random.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
             @Override
            public void handle(ActionEvent event) {
                test.setDisable(true);
                random.setDisable(true);
                sbircia.setDisable(false);
                abbandona.setDisable(false);
                scacchiera.buttonRandom();
            }

        });
        
        sbircia = new Button("Sbircia");
        sbircia.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Bomba.sbirciaBomba = true;
                Inoffensiva.sbirciaInoffensiva = true;
                
                System.out.println("Bomba" + Bomba.sbirciaBomba + "inoffensiva" + Inoffensiva.sbirciaInoffensiva);
            }
            
        });
        
        abbandona = new Button("Abbandona");
        abbandona.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent> (){
            @Override
            public void handle(ActionEvent event) {
                GameArea.this.initialize();
            }
            
        });
        
        labelCelleDascoprire = new Label("Celle da scoprire: " + String.valueOf(celleDaScoprire));

        contenitoreVario = new TilePane();
        contenitoreVario.getChildren().addAll(random, test, sbircia, abbandona, labelCelleDascoprire);
        this.setBottom(contenitoreVario);
        
        sbircia.setDisable(true);
        abbandona.setDisable(true);
    }

}
