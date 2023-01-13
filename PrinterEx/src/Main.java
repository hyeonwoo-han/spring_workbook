public class Main {
    public static void main(String[] args) {
        Printer p1 = Printer.getInstance();
        p1.print("Design Pattern 1");

        Printer p2 = Printer.getInstance();
        p2.print("Design Pattern 2");

        System.out.println(p1.toString());
        System.out.println(p2.toString());  //  같은 인스턴스다
    }
}
