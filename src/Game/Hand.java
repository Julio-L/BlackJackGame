package Game;

import java.util.ArrayList;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 *
 * @author JulioL
 */
public class Hand {

    private int score;
    private int pos;
    private HBox handImages;
    private int aceCards;
    private String name;
    private int oneChips;
    private int fiveChips;
    private int tenChips;
    private int tfiveChips;
    private int numChips = 5;

    private ArrayList<ImageView> images = new ArrayList<ImageView>();
    private ArrayList<Card> cards = new ArrayList<Card>();

    public Hand(String name) {
        handImages = new HBox();
        this.name = name;
        oneChips = numChips;
        fiveChips = numChips;
        tenChips = numChips;
        tfiveChips = numChips;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addToHand(Card card) {
        images.add(card.getFront());
        handImages.getChildren().add(images.get(pos++));
        cards.add(card);
        score += card.getValue();

        if (card.getValue() == 11) {
            aceCards++;
        }

        if (aceCards != 0 && score > 21) {
            score -= 10;
            aceCards--;
        }

    }

    public void cpuAddToHand(Card card) {
        if (this.score == 0) {
            images.add(card.getBack());
            handImages.getChildren().add(images.get(pos++));
        } else {
            images.add(card.getFront());
            handImages.getChildren().add(images.get(pos++));
        }

        cards.add(card);
        score += card.getValue();

        if (card.getValue() == 11) {
            aceCards++;
        }
        if (aceCards != 0 && score > 21) {
            score -= 10;
            aceCards--;
        }

    }

    public ArrayList<ImageView> getImages() {
        return images;
    }

    public void setUserHBox() {
        handImages.setLayoutX(140);
        handImages.setLayoutY(230);
    }

    public void setCpuHBox() {
        handImages.setLayoutX(140);
        handImages.setLayoutY(50);
    }

    public HBox getHandImages() {
        return handImages;
    }

    public void setHandImages(HBox handImages) {
        this.handImages = handImages;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getAceCards() {
        return aceCards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void resetHand() {
        handImages.getChildren().clear();
        images.clear();
        cards.clear();
        pos = 0;
        score = 0;
        aceCards = 0;
        handImages.setStyle("");
    }


    public int getOneChips() {
        return oneChips;
    }

    public int getFiveChips() {
        return fiveChips;
    }

    public int getTenChips() {
        return tenChips;
    }

    public int getTfiveChips() {
        return tfiveChips;
    }

    public void setOneChips(int oneChips) {
        this.oneChips = oneChips;
    }

    public void setFiveChips(int fiveChips) {
        this.fiveChips = fiveChips;
    }

    public void setTenChips(int tenChips) {
        this.tenChips = tenChips;
    }

    public void setTfiveChips(int tfiveChips) {
        this.tfiveChips = tfiveChips;
    }

    public int getTotalMoney(){
        int total = 0;
        total += oneChips;
        total += fiveChips * 5;
        total += tenChips * 10;
        total += tfiveChips * 25;
        return total;
    }
    
    public void betPlace(int[] chips){
        oneChips -= chips[0];
        fiveChips -= chips[1];
        tenChips -= chips[2];
        tfiveChips -= chips[3];
    }
    
    public void getEarnings(int[] chips){
        oneChips += chips[0];
        fiveChips += chips[1];
        tenChips += chips[2];
        tfiveChips += chips[3];
    }
    
}
