public class HyundaiMotor extends Motor { // Motor를 상속받아서 HyundaiMotor를 구현함
    public HyundaiMotor(Door door) {
        super(door) ;
    }
    protected void moveMotor(Direction direction) {
        System.out.println("Hyundai Motor Initiated");
    }
}