package SolitareOld;

import java.awt.*;

/**
 * Created by arina on 17.07.17.
 */
class Card {

    @Override
    public String toString() {
        return "Масть " + suil + " ранг " + rank;
    }

    // data fields for colors and suits
    final static int width = 50;
    final static int height = 70;

    final static int red = 0;
    final static int black = 1;

    final static int heart = 0;
    final static int spade = 1;

    final static int diamond = 2;
    final static int club = 3;
    //private static String names[] = {"A", "2", "3", "4", "5", "6",
//	"7", "8", "9", "10", "J", "Q", "K"};
    // data fields
   private static final String names[] = {"A", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "J", "Q", "K"};

    private boolean faceup;
    private int rank;
    private int suil;


    public Card link; //ссылка на след карту

    // constructor
    Card(int sv, int rv) {
        suil = sv; //масть
        rank = rv;
        faceup = false;
        link = null;
    }

    // access attributes of card
    public int rank() {
        return rank;
    }

    public int suit() {
        return suil;
    }

    public boolean isFaceUp() {
        return faceup;
    }  //лицом вниз

    public void flip() {
        faceup = !faceup;
    }  //перевернуть

    public int getColor() {
        if (suit() == heart || suit() == diamond) {
            return red;
        }
        return black;
    }

    public void draw(Graphics g, int x, int y, Color color) {

        // clear rectangle, draw border
        g.clearRect(x, y, width, height); //стиреть рамку
        g.setColor(color);
        g.drawRect(x, y, width, height);
        // draw body of card

            if (isFaceUp()) {
                if (getColor() == red) {
                    g.setColor(Color.red); //устанавлиевам цвет
                } else {
                    g.setColor(Color.blue);
                }
                g.drawString(names[rank()], x + 3, y + 15);
                if (suit() == heart) {
                    g.drawLine(x + 25, y + 30, x + 35, y + 20);
                    g.drawLine(x + 35, y + 20, x + 45, y + 30);
                    g.drawLine(x + 45, y + 30, x + 25, y + 60);
                    g.drawLine(x + 25, y + 60, x + 5, y + 30);
                    g.drawLine(x + 5, y + 30, x + 15, y + 20);
                    g.drawLine(x + 15, y + 20, x + 25, y + 30);
                } else if (suit() == spade) {
                    g.drawLine(x + 25, y + 20, x + 40, y + 50);
                    g.drawLine(x + 40, y + 50, x + 10, y + 50);
                    g.drawLine(x + 10, y + 50, x + 25, y + 20);
                    g.drawLine(x + 23, y + 45, x + 20, y + 60);
                    g.drawLine(x + 20, y + 60, x + 30, y + 60);
                    g.drawLine(x + 30, y + 60, x + 27, y + 45);
                } else if (suit() == diamond) {
                    g.drawLine(x + 25, y + 20, x + 40, y + 40);
                    g.drawLine(x + 40, y + 40, x + 25, y + 60);
                    g.drawLine(x + 25, y + 60, x + 10, y + 40);
                    g.drawLine(x + 10, y + 40, x + 25, y + 20);
                } else if (suit() == club) {
                    g.drawOval(x + 20, y + 25, 10, 10);
                    g.drawOval(x + 25, y + 35, 10, 10);
                    g.drawOval(x + 15, y + 35, 10, 10);
                    g.drawLine(x + 23, y + 45, x + 20, y + 55);
                    g.drawLine(x + 20, y + 55, x + 30, y + 55);
                    g.drawLine(x + 30, y + 55, x + 27, y + 45);
                }
            } else { // face down - рисуем рубашку
                g.setColor(Color.yellow);
                g.drawLine(x + 15, y + 5, x + 15, y + 65);
                g.drawLine(x + 35, y + 5, x + 35, y + 65);
                g.drawLine(x + 5, y + 20, x + 45, y + 20);
                g.drawLine(x + 5, y + 35, x + 45, y + 35);
                g.drawLine(x + 5, y + 50, x + 45, y + 50);
            }
        }

    @Override
    public boolean equals(Object obj) {
        return (this.rank == rank && this.suil == suil);
    }
}