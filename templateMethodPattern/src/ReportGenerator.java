import java.util.List;

public abstract class ReportGenerator {
    public String generate(List<Customer> customers){
        List<Customer> selected = selectCustomers(customers);
        String report = genHeader(selected);
        report += genBody(selected);
        report += genFooter(selected);
        return report;
    }
    protected abstract String genFooter(List<Customer> selected);

    protected abstract String genBody(List<Customer> selected);

    protected abstract String genHeader(List<Customer> selected);

    protected abstract List<Customer> selectCustomers(List<Customer> customers);
}
