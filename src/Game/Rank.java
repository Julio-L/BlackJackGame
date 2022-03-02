package Game;

/**
 *
 * @author JulioL
 */
public class Rank {
    
    private String name;
    private int totalMoney;
    
    public Rank(String name, int totalMoney){
        this.name = name;
        this.totalMoney = totalMoney;
    }

    public String getName() {
        return name;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }
    
    public String toString(){
        return name + "($" + totalMoney + ")";
    }
    
    public String writeFormat(){
        return name + " " + totalMoney;
    }
    
}
