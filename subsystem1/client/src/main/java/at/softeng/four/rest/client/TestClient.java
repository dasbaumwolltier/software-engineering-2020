package at.softeng.four.rest.client;

public class TestClient {

    public static void main(String[] args) {
        TrafficDataAccessClient client = new TrafficDataAccessClient("http://localhost:8080");
        System.out.println("Found " + client.getTrafficLinks().size() +" traffic links");
    }
}
