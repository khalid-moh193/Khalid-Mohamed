package Web.Util;

public enum URLs {


    FACEBOOK_REGISTRATION("https://web.facebook.com/r.php"),
    FACEBOOK_LOGIN("https://web.facebook.com/login/");

    private String value;

    URLs(String value) {
        this.setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
