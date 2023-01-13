public class SecureExternalEmailContent extends BasicEmailContent{
    public SecureExternalEmailContent(String content) {
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
        String externalContent = addDisclaimer(content);
        String encryptedExternalContent = encrypt(externalContent);
        return encryptedExternalContent;
    };
}
