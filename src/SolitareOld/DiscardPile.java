package SolitareOld;

import java.awt.*;

/**
 * Created by arina on 17.07.17.
 */
class DiscardPile extends CardPile { //стопка перевернутых карт

    DiscardPile(int x, int y) {
        super(x, y);
    }

    @Override
    public void push(Card aCard) {
        if (!aCard.isFaceUp()) {
            aCard.flip();
        }
        super.push(aCard);
    }

    @Override
    public Card select(int tx, int ty, Graphics g) { //что делать если на карту кликнули
        if (isEmpty()) {
            return null;
        }
        Card topCard = pop();
        for (int i = 0; i < 4; i++) {
            if (Solitare.suitPile[i].canTake(topCard)) {
                Solitare.suitPile[i].push(topCard);
                return null;
            }
        }
        for (int i = 0; i < 7; i++) {
            if (Solitare.tableau[i].canTake(topCard)) {
                Solitare.tableau[i].push(topCard);
                return null;
            }
        }
        // nobody can use it, put it back on our list
        push(topCard);
        return null;
    }
}
