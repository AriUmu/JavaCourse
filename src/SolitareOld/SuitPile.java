package SolitareOld;

import java.awt.*;

/**
 * Created by arina on 17.07.17.
 */
class SuitPile extends CardPile { //верхняя стопка из 4х карты

    SuitPile(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canTake(Card aCard) {
        if (isEmpty()) {
            return aCard.rank() == 0;
        }
        Card topCard = top();
        return (aCard.suit() == topCard.suit()) &&
                (aCard.rank() == 1 + topCard.rank());
    }
}
