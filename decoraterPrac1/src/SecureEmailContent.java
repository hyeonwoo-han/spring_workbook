public class SecureEmailContent extends EmailDecorator{
    public SecureEmailContent(EmailDecorator decorated) {
        super(decorated);
    }

    private String encrypt(String content){
        String encryptedContent = content + " : encrypted";
        return encryptedContent;
    };

    public String getContent(){
        String content = super.getContent();
        return encrypt(content);
    };
}
