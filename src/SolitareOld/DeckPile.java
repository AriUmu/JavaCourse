package SolitareOld;

/**
 * Created by arina on 17.07.17.
 */
class DeckPile extends CardPile { //верхняя правая стопка

    DeckPile(int x, int y) {
        // first initialize parent
        super(x, y);
        // then create the new deck
        // first put them into a local pile
        CardPile pileOne = new CardPile(0, 0);
        CardPile pileTwo = new CardPile(0, 0);
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= 12; j++) {
                pileOne.push(new Card(i, j));
                count++;
            }
        }
        // then pull them out randomly
        for (; count > 0; count--) {
            int limit = ((int) (Math.random() * 1000)) % count;
            // move down to a random location
            for (int i = 0; i < limit; i++) {
                pileTwo.push(pileOne.pop());
            }
            // then add the card found there
            push(pileOne.pop());
            // then put the decks back together
            while (!pileTwo.isEmpty()) {
                pileOne.push(pileTwo.pop());
            }
        }
    }

    @Override
    public void select(int tx, int ty) { //реакция на клик мышкой по стопке
        if (isEmpty()) {
            return;
        }
        Solitare.discardPile.push(pop()); //перекладывается карта (сначала извлекли потом перевернули и положили в стопку)
    }
}
