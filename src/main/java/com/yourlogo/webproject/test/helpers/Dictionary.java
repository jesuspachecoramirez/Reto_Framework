package com.yourlogo.webproject.test.helpers;

public class Dictionary {
    public static final String STATE_BY_DEFAULT_FLORIDA = "Florida";

    public static final String EMPTY_STRING = "";
    public static final String SPACE_STRING = " ";

    public static final String SPANISH_CODE_LANGUAGE = "es";
    public static final String COUNTRY_CODE = "CO";

    public static final String EMAIL_DOMAIN = "@sofmail.com";

    public static final String FILE_EVIDENCE_PROPERTY = "files.evidence";
    public static final String APP_URL_PROPERTY = "app.url";
    public static final String APP_URL_PROPERTY2="app.url2";

    private static final String PROPERTIES_FILE_BASE_PATH = "src/main/resources/properties/";


    public static final String CONFIGURATION_PROPERTIES_FILE = System.getProperty("user.dir") +
            "/" +
            PROPERTIES_FILE_BASE_PATH + "configuration.properties";

    public static final String MAIL_PROPERTIES_FILE = System.getProperty("user.dir") +
            "/" +
            PROPERTIES_FILE_BASE_PATH +"mail.properties";
}
