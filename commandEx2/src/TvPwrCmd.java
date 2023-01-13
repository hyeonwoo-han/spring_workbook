public class TvPwrCmd implements Command{
    private TV tv;
    public TvPwrCmd(TV tv){
        this.tv = tv;
    }
    @Override
    public void execute(){
        tv.power();
    }
}
