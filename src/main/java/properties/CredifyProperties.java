package properties;

public class CredifyProperties {

    private static final PropertiesReader credifyPropertiesReader = new PropertiesReader();

    private static final String CREDIFY_HOST = credifyPropertiesReader.getCredifyHost();
    private static final String CREDIFY_API_HOST = credifyPropertiesReader.getCredifyAPIHost();

    public static final String LOG_IN_URL = String.format("%s/portal/login", CREDIFY_HOST);
    public static final String CHECK_RATE_URL = String.format("%s/phone/nonDMFunnel", CREDIFY_HOST);
    public static final String GET_STATUS_API = String.format("%s/api/loanapp/v1/states", CREDIFY_API_HOST);


}
