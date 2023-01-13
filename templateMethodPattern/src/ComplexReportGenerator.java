import java.util.ArrayList;
import java.util.List;

public abstract class ComplexReportGenerator extends ReportGenerator{
    @Override
    public String generate(List<Customer> customers) {
        return super.generate(customers);
    }

    @Override
    protected String genFooter(List<Customer> selected) {
        String footer = String.format("********************");
        int totalPoint = 0;
        for(Customer customer : selected){
            totalPoint += customer.getPoints();
        }
        footer += String.format("Total Points : %d \n", totalPoint);
        footer += String.format("*******************");
        return footer;
    }

    @Override
    protected String genBody(List<Customer> selected) {

        int i = 0;
        String body = "";
        for(Customer customer : selected){

        }
    }

    @Override
    protected String genHeader(List<Customer> selected){
        String hchar = getHeaderChar();
        String header = hchar.repeat(20);
        header += "\n";
        header += String.format("Number of customers : %d\n", selected.size());
        return header;
    }

    protected abstract String getHeaderChar();

    @Override
    protected List<Customer> selectCustomers(List<Customer> customers) {
        List<Customer> selected = new ArrayList<>();
        for(Customer customer : customers){
            if(customer.getPoints() >= 100){
                selected.add(customer);
            }
        }
        return selected;
    }
}
