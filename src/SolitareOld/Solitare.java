package SolitareOld;

/**
 * Created by arina on 17.07.17.
 */
/*
Simple Solitare Card Game in Java
Written by Tim Budd, Oregon State University, 1996
*/

import java.applet.Applet;
import java.awt.*;

public class Solitare extends Applet {
    static DeckPile deckPile;
    static DiscardPile discardPile;
    static TablePile tableau[];
    static SuitPile suitPile[];
    static CardPile allPiles[];


    @Override
    public void init() {
        // first allocate the arrays
        allPiles = new CardPile[13]; //всего 13 колод
        suitPile = new SuitPile[4]; //4 колоды сверху
        tableau = new TablePile[7]; //7 колод внизу
        // then fill them in
        allPiles[0] = deckPile = new DeckPile(335, 5);
        allPiles[1] = discardPile = new DiscardPile(268, 5);
        for (int i = 0; i < 4; i++) {
            allPiles[2 + i] = suitPile[i] =
                    new SuitPile(15 + 60 * i, 5);
        }
        for (int i = 0; i < 7; i++) {
            allPiles[6 + i] = tableau[i] =
                    new TablePile(5 + 55 * i, 80, i + 1);
        }
    }

    @Override
    public void paint(Graphics g) { //перебирает все стопки и обрисовывает
        for (int i = 0; i < 13; i++) {
            allPiles[i].display(g);
        }
    }

    static Card topCard; //выбранная
    int num; //номер колоды из всех
    int newNum; //номер выбранной колоды

    //  @Override
    public boolean mouseDown(Event evt, int x, int y) { //куда щелкнули мышкой

        if (topCard == null) {
            for (int i = 0; i < 13; i++) {
                if (allPiles[i].includes(x, y)) { // выбирается стопка
                    topCard = allPiles[i].select(x, y, getGraphics());  // выбрать карту //положить в стек с выбранными картами
                    num = i;
                    System.out.println("->" + topCard);
                }
            }
        } else {
            for (int i = 0; i < 13; i++) {
                if (allPiles[i].includes(x, y)) { // выбирается стопка
                    newNum = i;
                    allPiles[i].selectNewPlace(x, y, getGraphics(), topCard, num, newNum);
                    topCard = null;
                }
            }
        }
        repaint();
        return true;
    }


}