public class Main {
    public static void main(String[] args) {
        EmailContent e1 = new BasicEmailContent("insang mail");
        EmailContent e2 = new ExternalEmailContent(e1);
        EmailContent e3 = new SecureEmailContent(e2);

        System.out.println(e3.getContent());

    }
}
