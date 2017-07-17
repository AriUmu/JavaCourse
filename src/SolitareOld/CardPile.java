package SolitareOld;

import java.awt.*;

/**
 * Created by arina on 17.07.17.
 */
class CardPile { //абстрактная стопка не создает экземляров класса
    // coordinates of the card pile
    protected int x;
    protected int y;
    private Card firstCard;

    CardPile(int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
        firstCard = null;
    }

    // access to cards are not overridden

    public Card top() {
        return firstCard;
    }

    public boolean isEmpty() {
        return firstCard == null;
    }

    public void push(Card aCard) { //push
        aCard.link = firstCard;
        firstCard = aCard;
    }

    public Card pop() {
        Card result = null;
        if (firstCard != null) {
            result = firstCard;
            firstCard = firstCard.link;
        }
        return result;
    }

    // the following are sometimes overridden

    public boolean includes(int tx, int ty) { //координаты куда кликнули мышков находятся в рамках координат стопки
        return x <= tx && tx <= x + Card.width &&
                y <= ty && ty <= y + Card.height;
    }

    public void select(int tx, int ty) {
        // do nothing
    }



    public void display(Graphics g) { //обрисовка карт в стопках если первая - лицом,если не первая, то рубашкой вверх
        g.setColor(Color.black);
        if (firstCard == null) {
            g.drawRect(x, y, Card.width, Card.height);
        } else {
            firstCard.draw(g, x, y);
        }
    }

    public boolean canTake(Card aCard) {
        return false;
    }
}
