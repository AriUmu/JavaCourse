package SolitareOld;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arina on 17.07.17.
 */
class TablePile extends CardPile {

    class StackSelectedCard{
        private int size = 0;
        private Card[] selectedCard;

        public StackSelectedCard() {
            selectedCard = new Card[54];
        }

        public boolean push(Card card){
            /*
            когда карта попадает в стек ее статус меняется на true
            загорается зеленым пока находится в стеке
             */

            if(size >= selectedCard.length){
                return false;
            }

            selectedCard[size] = card;
            size++;
            return true;
        }

        public Card tos(){
            return (size<=0)? null:selectedCard[size-1];
        }

        public Card popOneCard(){ //вытаскивать по одной карте
            if(size <= 0){
                return null;
            }

            size--;
            Card result = selectedCard[size];
             //карта гасится
            selectedCard[size] = null;
            return result;
        }

        public int getSize() {
            return size;
        }

    }

StackSelectedCard stackSelectedCard = new StackSelectedCard();


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
                y <= ty && ty <= y + Card.height * 4;

        // return (x <= tx && tx <= x + Card.width);// && y * 3 < ty; //рабочий
    }


   static int countSelected = 0; //сколько карт было выбрано

    @Override
    public Card select(int tx, int ty, Graphics g) { //метод селект в DiscartPile TadlePile дублируются
        if (isEmpty()) {
            return null;
        }

        // if face down, then flip
//        Card topCard = top();

//        if (!topCard.isFaceUp()) {
//            topCard.flip();
//            return;
//        }
        // else see if any suit pile can take card

        Card topCard = top();
        int y = stackDisplay(g, topCard);
        topCard.draw(g, x, y - 35, Color.GREEN);//изменяется цвет при нажатии только последняя одиночная карта
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countSelected ++; //+1 в стек
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
    public void selectNewPlace(int tx, int ty, Graphics g, Card topCard, int num, int newNum) { //переделать

        for (int i = 0; i < 4; i++) {
            if (Solitare.suitPile[i].canTake(topCard)) {

                if(topCard.link != null && !topCard.link.isFaceUp()){
                    topCard.link.flip();
                }
                Solitare.allPiles[num].pop(); //только в этот момент мы забираем карту
                Solitare.suitPile[i].push(topCard);
                return;
            }
        }

       //  else see if any other table pile can take card
        /*
        когда мы нажимаем второй и след разы то записываем в стек
         */
        if(num != newNum) {
            for (int i = 0; i < 7; i++) {

//                for (int j = 0; j < countSelected ; j++) {
//                    stackSelectedCard.push(Solitare.allPiles[num].pop()); //стек с выбраными картами
//                }


//                Card topCard1 = stackSelectedCard.tos();

                if (Solitare.tableau[i].canTake(topCard)) { //при перекладывании карты открываем следуюзую

                    if (!Solitare.tableau[i].isEmpty()) { //если в стеке есть карта

                        int y = stackDisplay(g, Solitare.tableau[i].top());
                        Solitare.tableau[i].top().draw(g, x, y - 35, Color.RED);

                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                  }

                    if (topCard.link != null && !topCard.link.isFaceUp()) {
                        topCard.link.flip();
                    }

                   Solitare.allPiles[num].pop(); //только в этот момент мы забираем карту

//                    for (int j = 0; j < countSelected ; j++) {
//                        Solitare.tableau[i].push(stackSelectedCard.popOneCard());
//                        countSelected--;
//                    }

                   Solitare.tableau[i].push(topCard);
                    return;
                }
            }
        }
        else{ //если кликаем несколько раз по одной колоде
            countSelected++; //увеличиваем количество
//            topCard = topCard.link;
//            int y = stackDisplay(g, topCard);
//            topCard.link.draw(g,x,y-35,Color.GREEN); //типо зеленые

        }
        return;
    }


    public int numberCard(int tx, int ty){ //возвращает номер карты сверху
        int result = ((ty - 80)/35)+1;
        return result;
    }
}
