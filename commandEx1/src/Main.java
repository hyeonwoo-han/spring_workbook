public class Main {
    public static void main(String[] args) {
        // OCP를 지키기 위한 노력...
        TV tv = new TV();
        PowerCommand cmd1 = new PowerCommand(tv);
        MuteCommand cmd2 = new MuteCommand(tv);

        TwoButtonController rc = new TwoButtonController(cmd1, cmd2);
        rc.button1Pressed();
        rc.button2Pressed();

        rc.button1Pressed();
        rc.button2Pressed();
    }
}
