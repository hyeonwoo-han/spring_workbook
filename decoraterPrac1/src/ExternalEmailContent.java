public class ExternalEmailContent extends EmailDecorator{
    public ExternalEmailContent(EmailDecorator decorated) {
        super(decorated);
    }

    private String addDisclaimer(String content){
        String externalContent = content + " : disclaimer";
        return externalContent;
    };

    public String getContent(){
        String content = super.getContent();
        return addDisclaimer(content);
    };
}
