import java.util.ArrayList;
import java.util.List;

public class Battery extends Subject{
    private int level = 100;
    private List<Observer> observers = new ArrayList<>();

    // observer setter 역할

    public void consume(int amount){
        level -= amount;
        notifyObservers();
    }

    public int getLevel(){
        return level;
    }


}
