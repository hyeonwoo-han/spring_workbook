public class Main {
    public static void main(String[] args) {
        Employee hw = new Employee("1234", "hyeonwoo");

        hw.setWorkHours(40);
        hw.setOverTimeHours(10);
        hw.setPayManager(new ClassicalPayment());

        System.out.println(hw.pay());

    }
}
