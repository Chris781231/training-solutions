package isahasa.htmldecorator;

public class Client {

    private final Channel channel;

    public Client(Channel channel) {
        this.channel = channel;
    }

    public int writeToChannel(TextSource source) {
        return channel.writeByte(source.getPlainText().getBytes());
    }
}
