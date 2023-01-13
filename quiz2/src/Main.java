public class Main {
    public Main() {}
    public void printWithPlus(String contents) {
        System.out.println("++++++++++++++++");

        try {
            long sleep = (long) (Math.random() * 100);
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(contents);
        System.out.println("++++++++++++++++");
    }

    public void printWithStar(String contents) {
        System.out.println("****************");

        try {
            long sleep = (long) (Math.random() * 100);
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(contents);
        System.out.println("****************");
    }

    public static void main(String[] args) {
        Main printer = new Main();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                printer.printWithPlus(Thread.currentThread().getName());
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                printer.printWithStar(Thread.currentThread().getName());
            }
        }).start();
    }
}