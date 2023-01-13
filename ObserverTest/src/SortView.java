import java.util.Collections;
import java.util.List;

public class SortView implements Observer{
    private ScoreRecord scoreRecord;

    public SortView(ScoreRecord scoreRecord){
        this.scoreRecord = scoreRecord;
    }

    public void update(){
        List<Integer> record = scoreRecord.getScoreRecord();    // refresh
        displayScores(record);                                  // print min max
    }

    public void displayScores(List<Integer> record){
        System.out.println("-------- Sorted Records --------");
        Collections.sort(record);
        for(Integer score: record){
            System.out.println(score);
        }
    }

}
