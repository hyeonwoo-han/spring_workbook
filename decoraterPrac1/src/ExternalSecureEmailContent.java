public class ExternalSecureEmailContent extends BasicEmailContent{
    public ExternalSecureEmailContent(String content) {
        super(content);
    }

    private String encrypt(String content){
        String encryptedContent = content + " : encrypted";
        return encryptedContent;
    };

    private String addDisclaimer(String content){
        String externalContent = content + " : disclaimer";
        return externalContent;
    };

    public String getContent(){
        String content = super.getContent();
        String encryptedContent = encrypt(content);
        String externalEncryptedContent = addDisclaimer(encryptedContent);
        return externalEncryptedContent;
    };
}
