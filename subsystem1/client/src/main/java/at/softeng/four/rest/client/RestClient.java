package at.softeng.four.rest.client;

import feign.Feign;
import feign.gson.GsonDecoder;

public class RestClient<T> {

    private T client;

    public RestClient(String baseUrl, Class target) {
        this.client = (T) Feign.builder()
                .decoder(new GsonDecoder())
                .target(target, baseUrl);
    }

    protected T getClient() {
        return client;
    }
}
