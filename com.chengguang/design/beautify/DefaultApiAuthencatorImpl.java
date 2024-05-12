package design.beautify;

public class DefaultApiAuthencatorImpl implements ApiAuthencator{
    private CredentialStorage credentialStorage;

    public DefaultApiAuthencatorImpl(CredentialStorage credentialStorage) {
        this.credentialStorage = credentialStorage;
    }

    public DefaultApiAuthencatorImpl() {
    }

    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.createFromFullUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();
        String originalUrl = apiRequest.getBaseUrl();

        AuthToken clientAuthToken = new AuthToken(token, timestamp);
        if (clientAuthToken.isExpired()){
            throw new RuntimeException("Token is expired");
        }

        String password = credentialStorage.getPasswordByAppId(appId);
        AuthToken serverAuthToken = AuthToken.generate(originalUrl, appId, password);
        if (!serverAuthToken.match(clientAuthToken)){
            throw new RuntimeException("Token verfication failed");
        }
    }
}
