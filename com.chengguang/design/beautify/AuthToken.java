package design.beautify;

import java.util.Map;

public class AuthToken {
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1*60*1000;
    private String token;
    private long createTime;
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long createTime, long expiredTimeInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public static AuthToken create(String baseUrl, long createTime, Map<String,String> params){
        return null;
    }

    public static AuthToken generate(String originalUrl, String appId, String password) {
        return null;
    }

    public String getToken(){
        return null;
    }

    public boolean isExpired(){
        return false;
    }

    public boolean match(AuthToken authToken){
        return false;
    }
}
