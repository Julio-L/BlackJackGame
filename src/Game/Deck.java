package Game;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author JulioL
 */
public class Deck {

    private ArrayList<Card> deckOfCards = new ArrayList<Card>();

    private Image backImage = new Image("/playing_cards_images/Back_Of_Card.png");

    private int[] cardValues = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        
    private ImageView[] diamonds;
    private ImageView[] spades;
    private ImageView[] hearts;
    public ImageView[] clubs;
    
    private ImageView[] backDiamond;
    private ImageView[] backSpade;
    private ImageView[] backHeart;
    public ImageView[] backClub;

    public Deck() {
        diamonds = new ImageView[13];
        spades = new ImageView[13];
        hearts = new ImageView[13];
        clubs = new ImageView[13];
        
        backDiamond = new ImageView[13];
        backSpade = new ImageView[13];
        backHeart = new ImageView[13];
        backClub = new ImageView[13];
        
        this.createDeck();
        
        this.resetDeck();

    }

    private String cardPrefix = "/playing_cards_images/Playing_card_";
    String[] cardSuffix = {"_A.jpg", "_2.jpg", "_3.jpg", "_4.jpg", "_5.jpg", "_6.jpg", "_7.jpg", "_8.jpg", "_9.jpg", "_10.jpg", "_J.jpg", "_K.jpg", "_Q.jpg"};;

     
            
    public void createDeck(){
        
        //diamonds
        for(int i = 0; i < diamonds.length; i++ ){
            diamonds[i] = new ImageView(cardPrefix + "diamond" + cardSuffix[i]);
            backDiamond[i] = new ImageView(backImage);
        }
        
        //spades
        for(int i = 0; i < spades.length; i++ ){
            spades[i] = new ImageView(cardPrefix + "spade" + cardSuffix[i]);
            backSpade[i] = new ImageView(backImage);
        }
        
        //hearts
        for(int i = 0; i < hearts.length; i++ ){
            hearts[i] = new ImageView(cardPrefix + "heart" + cardSuffix[i]);
            backHeart[i] = new ImageView(backImage);
        }
        
        //hearts
        for(int i = 0; i < clubs.length; i++ ){
            clubs[i] = new ImageView(cardPrefix + "club" + cardSuffix[i]);
            backClub[i] = new ImageView(backImage);
        }

    }

    public void shuffle() {

        for (int i = 0; i < deckOfCards.size(); i++) {
            int rand = (int) (Math.random() * 52);
            Card temp = deckOfCards.get(i);
            deckOfCards.set(i, deckOfCards.get(rand));
            deckOfCards.set(rand, temp);
        }

    }

    public ArrayList<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public void resetDeck() {
        deckOfCards.clear();

        for (int r = 0; r < clubs.length; r++) {
            clubs[r].setFitHeight(100);
            clubs[r].setFitWidth(100);
            backClub[r].setFitHeight(100);
            backClub[r].setFitWidth(100);
        }

        for (int r = 0; r < clubs.length; r++) {

            Card c1 = new Card(cardValues[r], "clubs", clubs[r], backClub[r]);

            deckOfCards.add(c1);

        }

        for (int r = 0; r < hearts.length; r++) {
            hearts[r].setFitHeight(100);
            hearts[r].setFitWidth(100);
            backHeart[r].setFitHeight(100);
            backHeart[r].setFitWidth(100);
        }

        for (int r = 0; r < hearts.length; r++) {
            Card c2 = new Card(cardValues[r], "hearts", hearts[r], backHeart[r]);
            deckOfCards.add(c2);
        }

        for (int r = 0; r < spades.length; r++) {
            spades[r].setFitHeight(100);
            spades[r].setFitWidth(100);
            backSpade[r].setFitHeight(100);
            backSpade[r].setFitWidth(100);
        }

        for (int r = 0; r < spades.length; r++) {
            Card c2 = new Card(cardValues[r], "spades", spades[r], backSpade[r]);
            deckOfCards.add(c2);
        }

        for (int r = 0; r < diamonds.length; r++) {
            diamonds[r].setFitHeight(100);
            diamonds[r].setFitWidth(100);

            backDiamond[r].setFitHeight(100);
            backDiamond[r].setFitWidth(100);
        }

        for (int r = 0; r < diamonds.length; r++) {
            Card c2 = new Card(cardValues[r], "diamonds", diamonds[r], backDiamond[r]);
            deckOfCards.add(c2);
        }
        shuffle();
    }

   
}
