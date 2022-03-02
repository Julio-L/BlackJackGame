package Game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.ImageView;

/**
 *
 * @author JulioL
 */
public class GamePlay {

    private Deck deck = new Deck();
    private Hand user = new Hand("User");
    private Hand cpu = new Hand("Dealer");
    private int cursor = 0;
    private int[] chipsBet = new int[4];
    private int betAmount;
    private Rank[] topThree = new Rank[4];
    private int rankCursor = 0;
    private File rankFile = new File("Ranks.txt");
    private BufferedReader bf;
    private PrintWriter pf;
    private FileWriter write;
    private BufferedWriter bw;

    public GamePlay() {
        loadRanks();
    }

    public void loadRanks() {

        int index = 0;

        try {
            bf = new BufferedReader(new FileReader(rankFile));

            String line;

            while ((line = bf.readLine()) != null) {
                String[] rankObj = line.split(" ");
                Rank tempR = new Rank(rankObj[0], Integer.parseInt(rankObj[1]));
                topThree[index++] = tempR;
                rankCursor++;
            }
            bf.close();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }

    }

    public void updateFileRankings(String name, int totalMoney) {
        Rank user = new Rank(name, totalMoney);

        if (rankCursor == 0) {
            topThree[rankCursor++] = user;
        } else {
            topThree[rankCursor++] = user;
            sortRankings(topThree);

        }

        try {
            write = new FileWriter(rankFile);
            bw = new BufferedWriter(write);
            pf = new PrintWriter(bw);

            int index = 0;
            while (index < rankCursor && index < 3) {
                pf.println(topThree[index].getName() + " " + topThree[index].getTotalMoney());
                index++;
            }

            pf.close();
        } catch (IOException ex) {

        }

        if (rankCursor > 2) {
            rankCursor = 3;
        }

    }

    public void sortRankings(Rank[] ranks) {

        for (int i = 0; i < rankCursor ; i++) {
            for (int r = 1; r < rankCursor - i; r++) {

                if (ranks[r - 1].getTotalMoney() < ranks[r].getTotalMoney()) {

                    Rank temp = ranks[r];
                    ranks[r] = ranks[r - 1];
                    ranks[r - 1] = temp;
                }
            }
        }

    }

    public void dealCards() {
        user.addToHand(deck.getDeckOfCards().get(cursor++));
        user.addToHand(deck.getDeckOfCards().get(cursor++));
        cpu.cpuAddToHand(deck.getDeckOfCards().get(cursor++));
        cpu.cpuAddToHand(deck.getDeckOfCards().get(cursor++));
    }

    public Deck getDeck() {
        return deck;
    }

    public Hand getUser() {
        return user;
    }

    public Hand getCpu() {
        return cpu;
    }

    public int getCursor() {
        return cursor;
    }

    public void hitUser() {
        user.addToHand(deck.getDeckOfCards().get(cursor++));

    }

    public void cpuHit() {

        if (cpu.getScore() < 17) {
            cpu.cpuAddToHand(deck.getDeckOfCards().get(cursor++));
            this.cpuHit();
        }
    }

    public void setCpuFirstCard() {
        ImageView cpuFirst = cpu.getImages().get(0);
        cpuFirst.setImage(cpu.getCards().get(0).getFront().getImage());
    }

    public boolean over21(Hand player) {
        if (player.getScore() > 21) {
            return true;
        } else {
            return false;
        }
    }

    public Hand winner() {

        if (user.getScore() == 21 && cpu.getScore() != 21) {
            return user;
        } else if (user.getScore() == 21 && cpu.getScore() == 21) {
            return null;
        } else if (!over21(user) && !over21(cpu) && user.getScore() != cpu.getScore()) {
            return (user.getScore() > cpu.getScore()) ? user : cpu;
        } else if (over21(user) && !over21(cpu)) {
            return cpu;
        } else if (!over21(user) && over21(cpu)) {
            return user;
        } else {
            return null;
        }
    }

    public void resetGame() {
        cursor = 0;
        deck.resetDeck();
        cpu.resetHand();
        user.resetHand();
    }

    public void userBet(int oneChips, int fiveChips, int tenChips, int tfiveChips) {
        chipsBet[0] = oneChips;
        chipsBet[1] = fiveChips;
        chipsBet[2] = tenChips;
        chipsBet[3] = tfiveChips;

        betAmount = oneChips + (fiveChips * 5) + (tenChips * 10) + (tfiveChips * 25);

        user.betPlace(chipsBet);
    }

    public void drawPayout() {
        user.getEarnings(chipsBet);
        resetChipsBet();
    }

    public void regularPayout() {

        int[] winnings = {1, 5, 10, 25};
        int index = 3;

        while (betAmount != 0) {
            chipsBet[index] += betAmount / winnings[index];
            betAmount = betAmount % winnings[index];
            index--;
        }

        user.getEarnings(chipsBet);
        resetChipsBet();

    }

    public void resetChipsBet() {
        for (int i = 0; i < chipsBet.length; i++) {
            chipsBet[i] = 0;
        }
    }

    public Rank[] getTopThree() {
        return topThree;
    }

}
