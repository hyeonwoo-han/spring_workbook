public class BasicEmailContent implements EmailContent {
    private String content;

    public BasicEmailContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }



}
