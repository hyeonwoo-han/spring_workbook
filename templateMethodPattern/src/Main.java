import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer("insang");
        Customer c2 = new Customer("insang");
        Customer c3 = new Customer("insang");
        Customer c4 = new Customer("insang");
        Customer c5 = new Customer("insang");

        c1.setPoints(250);
        c2.setPoints(50);
        c3.setPoints(150);
        c4.setPoints(90);
        c5.setPoints(125);

        List<Customer> customers = new ArrayList<>();
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        customers.add(c5);

        ReportGenerator rg = new SimpleReportGenerator();
        System.out.println(rg.generate(customers));
    }
}
