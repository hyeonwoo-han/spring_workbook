import java.util.Collections;
import java.util.List;

public class MinMaxView implements Observer{
    private ScoreRecord scoreRecord;

    public MinMaxView(ScoreRecord scoreRecord){
        this.scoreRecord = scoreRecord;
    }

    public void update(){
        List<Integer> record = scoreRecord.getScoreRecord();    // refresh
        displayScores(record);                                  // print min max
    }

    public void displayScores(List<Integer> record){
        int min = Collections.min(record);
        int max = Collections.max(record);
        System.out.println("Min " + min + " Max " + max);

    }

}
