public class BirdSingCmd implements Command{
    private Bird b;
    public BirdSingCmd(Bird b){
        this.b = b;
    }
    @Override
    public void execute(){
        b.sing();
    }
}
