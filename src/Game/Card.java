package Game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author JulioL
 */
public class Card {
    
    private String suit;
    private int value;
    private ImageView front;
    private ImageView back;
    
    public Card( int value, String suit, ImageView front, ImageView back){
        this.suit = suit;
        this.value = value;
        this.front = front;
        this.back = back;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public ImageView getFront() {
        return front;
    }

    public ImageView getBack() {
        return back;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setFront(ImageView front) {
        this.front = front;
    }

    public void setBack(ImageView back) {
        this.back = back;
    }

    
    
    
    
    
}
