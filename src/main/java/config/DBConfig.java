package config;

public enum DBConfig {

    INSTANCE;

    private String url = "";
    private String user = "";
    private String pass = "";

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}
