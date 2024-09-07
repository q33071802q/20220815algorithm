package design.adapter;

public class ClientTest{
    public static void main(String[] args) {
        Client client = new WeChatClient();
        client.specificRequest();

        ClientTargetAdapter targetAdapter = new ClientTargetAdapter(client);
        targetAdapter.request();
    }

}

interface Client {
    void specificRequest();
}

class WeChatClient implements Client{
    @Override
    public void specificRequest() {
        System.out.println("wechat request");
    }
}

interface Target{
    void request();
}

class ClientTargetAdapter implements Target{
    Client client;

    public ClientTargetAdapter(Client client) {
        this.client = client;
    }

    @Override
    public void request() {
        client.specificRequest();
    }
}
