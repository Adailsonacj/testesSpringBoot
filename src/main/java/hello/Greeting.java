package hello;

public class Greeting {

    private final long id;
    private final String content;
    private final String banco;

    public Greeting(long id, String content, String banco) {
        this.id = id;
        this.content = content;
        this.banco = banco;
    }

    public String getBanco(){
        return banco;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
