package design.beautify;

public interface ApiAuthencator {
    void auth(String url);
    void auth(ApiRequest apiRequest);
}
