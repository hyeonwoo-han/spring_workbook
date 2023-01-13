public class PowerCommand implements Command{
    private TV tv;

    public PowerCommand(TV tv){
        this.tv = tv;
    }
    @Override
    public void execute(){  // TV 클래스의 power 기능 수행
        tv.power();
    }
}
