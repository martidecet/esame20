/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esameminesweeper;

import java.util.Random;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author MartinaDeCet
 */
public class Scacchiera extends GridPane {

    final static int NCOL = 9;
    final static int NROW = 9;
    Random generatoreIRandom;
    Random generatoreJRandom;

    GameArea game;

    public Scacchiera(GameArea game) {
        this.game = game;
        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(100. / NCOL);

        RowConstraints row = new RowConstraints();
        row.setPercentHeight(100. / NROW);

        generatoreIRandom = new Random();
        generatoreJRandom = new Random();

        this.getColumnConstraints().addAll(col, col, col, col, col, col, col, col, col);
        this.getRowConstraints().addAll(row, row, row, row, row, row, row, row, row);

        Casella c = null;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                c = new Inoffensiva(i, j, game);
                this.add(c, i, j);
            }
        }

    }

    public void buttonTest() {
        Casella c = null;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ((i == j) || (i == 8 && j == 0)) {
                    c = new Bomba(i, j, game);
                } else {
                    if ((i == j + 1) || (i == j - 1)) {
                        c = new Inoffensiva(i, j, game);
                        ((Inoffensiva) c).labelBombe.setText(String.valueOf(2));

                    } else if ((i == j + 2) || (i == j - 2) || ((i == 7) && (j == 0)) || ((i == 7) && (j == 1)) || ((i == 8) && (j == 1))) {
                        c = new Inoffensiva(i, j, game);
                        ((Inoffensiva) c).labelBombe.setText(String.valueOf(1));

                    } else {
                        c = new Inoffensiva(i, j, game);
                        ((Inoffensiva) c).labelBombe.setText(String.valueOf(0));
                    }
                }
                this.add(c, i, j);
            }
        }
        this.setDisable(false);
    }

    public void buttonRandom() {
        Casella c = null;
        int valoreI, valoreJ;
        for (int k = 0; k < 10; k++) {
            valoreI = generatoreIRandom.nextInt(9);
            valoreJ = generatoreJRandom.nextInt(9);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if ((i == valoreI) && (j == valoreJ)) {
                        System.out.println("entrato in generatore");
                        System.out.println("Qui c'è una bomba in " + i + "e in " + j);
                        c = new Bomba(i, j, game);
                    } else {
                        if (c == null) {
                            System.out.println("entrato in else");
                            c = new Inoffensiva(i, j, game);
                            ((Inoffensiva) c).labelBombe.setText(String.valueOf(0));
                        }
                    }
                    this.add(c, i, j);
                }
            }
        }
    }
}
