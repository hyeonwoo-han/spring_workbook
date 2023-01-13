import java.util.List;

public class DataSheetView implements Observer{
    private int viewCount;              // 보여줄 score 개수
    private ScoreRecord scoreRecord;    // ScoreRecord.java

    public DataSheetView(ScoreRecord scoreRecord, int viewCount) {
        this.scoreRecord = scoreRecord;
        this.viewCount = viewCount;
    }

    public void update() {
        List<Integer> record = scoreRecord.getScoreRecord();    // update
        displayScores(record, viewCount);                       // print
    }

    public void displayScores(List<Integer> record, int viewCount) {
        System.out.println("List of " + viewCount + " entries");
        for(int i = 0; i < viewCount && i < record.size(); i++){
            System.out.println(record.get(i));
        }
    }
}
