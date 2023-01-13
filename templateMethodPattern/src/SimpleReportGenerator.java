import java.util.List;

public class SimpleReportGenerator extends ReportGenerator{
    @Override
    public String generate(List<Customer> customers) {
        return super.generate(customers);
    }

    @Override
    protected String genFooter(List<Customer> selected) {
        String footer = String.format("*******************************\n");
        return footer;
    }

    @Override
    protected String genBody(List<Customer> selected) {
        String body = "";
        for(Customer customer : selected){
            body += String.format("%s : %d\n", customer.getName(), customer.getPoints());
        }
        return body;
    }

    @Override
    protected String genHeader(List<Customer> selected) {
//        String aster = "*";
//        String header = aster.repeat(20);   // 에스터리스크 20번 반복
        String header = String.format("*******************************\n");
        header += String.format("Number of Customers : %d \n", selected.size());
        header += String.format("*******************************\n");

        return header;
    }

    @Override
    protected List<Customer> selectCustomers(List<Customer> customers) {
        return customers;
    }
}
