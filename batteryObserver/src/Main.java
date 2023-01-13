public class Main {
    public static void main(String[] args) {
        Battery battery = new Battery();
        BatteryLevelDisplay display = new BatteryLevelDisplay(battery); // 알림 받을 battery 객체 set
        LowBatteryWarning warning = new LowBatteryWarning(battery);
        battery.attach(display);    // Battery의 Observer List에 display add
        battery.attach(warning);    // Battery의 Observer List에 warning add

        battery.consume(30);
        battery.consume(50);
        battery.consume(10);
    }
}
