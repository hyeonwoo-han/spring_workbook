// 새로운 기능을 원하면 새로운 클래스와 command를 만들면 된다. OCP 만족
public class Main {
    public static void main(String[] args) {
        TV tv = new TV();   Bird b = new Bird(); FileNew fn = new FileNew();
        Command cmd1 = new TvPwrCmd(tv); Command cmd2 = new BirdSingCmd(b);
        Command cmd3 = new FileNewCmd(fn);
        MenuItem item = new MenuItem();

        // tv power
        item.setCmd(cmd1);
        item.buttonPressed();

        // bird sing
        item.setCmd(cmd2);
        item.buttonPressed();

        // make new file
        item.setCmd(cmd3);
        item.buttonPressed();

    }
}
