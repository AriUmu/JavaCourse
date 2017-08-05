package SolitareOld;

import java.awt.*;
import java.util.Stack;

/**
 * Created by arina on 17.07.17.
 */
class TablePile extends CardPile {

    Stack<Card> stack = new Stack();

    TablePile(int x, int y, int c) {
        // initialize the parent class
        super(x, y);
        // then initialize our pile of cards
        for (int i = 0; i < c; i++) {
            push(Solitare.deckPile.pop());
        }
        // flip topmost card face up
        top().flip();
    }

    @Override
    public boolean canTake(Card aCard) { //класть в стопку на столе
        if (isEmpty()) {
            return aCard.rank() == 12;
        }
        Card topCard = top();
        return (aCard.getColor() != topCard.getColor()) &&
                (aCard.rank() == topCard.rank() - 1) && (aCard.isFaceUp()); //можно положить если она лицом вверх
    }

    @Override
    public boolean includes(int tx, int ty) {
        // don't test bottom of card
        return x <= tx && tx <= x + Card.width &&
                y <= ty && ty <= y + Card.height * 6;

    }

    public Card select(int count, int tx, int ty, Graphics g) { //метод селект в DiscartPile TadlePile дублируются
        if (isEmpty()) {
            return null;
        }

        int numberOfPile = count - 6;

        int trololo = Solitare.tableau[count - 6].getSize() - 1;
        System.out.println(trololo * 35 - (ty - Solitare.tableau[count - 6].y)); //если отризательная то нажата по последней карте

        int numberOfCard = 0;
        if (trololo * 35 - (ty - Solitare.tableau[count - 6].y) < 0) {
            numberOfCard = trololo;
        }
        if (trololo * 35 - (ty - Solitare.tableau[count - 6].y) > 0) {
            numberOfCard = ((ty - Solitare.tableau[count - 6].y) / 35);
        }

        System.out.println("numberOfPile =  " + numberOfPile); //номер колоды
        System.out.println("numberOfCard =  " + numberOfCard); //номер карты


        Card topCard = top(); //берем верхнюю карту в колоде


        int HowCardInPile = Solitare.allPiles[count].getSize(); //сколько карт в данной колоде
        Solitare.HowToGet = HowCardInPile - numberOfCard; //сколько карт нужно полодить к стек


        int y = stackDisplay(g, topCard);
        topCard.draw(g, x, y - 35, Color.GREEN);//изменяется цвет при нажатии только последняя одиночная карта
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return topCard;
    }

    private int stackDisplay(Graphics g, Card aCard) { //обрисовка карт в стопках
        int localy; //y
        if (aCard == null) {
            return y;
        }
        localy = stackDisplay(g, aCard.link);
        aCard.draw(g, x, localy, Color.BLACK);
        return localy + 35;
    }

    @Override
    public void display(Graphics g) {
        stackDisplay(g, top());

    }

    @Override
    public void selectNewPlace(int tx, int ty, Graphics g, int num, int newNum) { //переделать

        for (int i = 0; i < Solitare.HowToGet; i++) {
            if (Solitare.allPiles[num].top().isFaceUp()) { //если карта рубашкой вверх

                Solitare.stackofcard.push(Solitare.allPiles[num].pop());   //то кладем ее в стек

                System.out.println("В стеке " + Solitare.HowToGet + " карт");
            }
        }

        Card topCardBuffStack = Solitare.stackofcard.peek();

        //ниже запись карты в колоду с мастями
        if(newNum == num) {
            for (int i = 0; i < 4; i++) {
                if (Solitare.suitPile[i].canTake(topCardBuffStack)) { //не трогать

                    if (topCardBuffStack.link != null && !topCardBuffStack.link.isFaceUp()) {
                        topCardBuffStack.link.flip();
                    }
                    Solitare.suitPile[i].push(topCardBuffStack);
                    Solitare.stackofcard.pop();
                    System.out.println("Стeк пуст");
                    return;
                }
            }
        }

        //перекладываем на новую колоду

        if (Solitare.allPiles[newNum].canTake(topCardBuffStack) && num != newNum) { //при перекладывании карты открываем следуюзую

            Card returnTopCard = Solitare.allPiles[num].top();
            if (returnTopCard != null && !returnTopCard.isFaceUp()) { //переворачиваем следуюзую
                returnTopCard.flip();
            }

            while (!Solitare.stackofcard.isEmpty()) {
                Solitare.allPiles[newNum].push(Solitare.stackofcard.pop());
            }

            System.out.println("Стек пуст");
            return;
        } else {
            while (!Solitare.stackofcard.isEmpty()) {
                Solitare.allPiles[num].push(Solitare.stackofcard.pop());

            }
            System.out.println("Никуда не положили В стеке " + Solitare.stackofcard.size() + " карт");
            return;
        }
    }

}
