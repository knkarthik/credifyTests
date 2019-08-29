package properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private Properties prop;

    public PropertiesReader() {

        prop = new Properties();

        try {
            String env = System.getProperty("env");

            if (null == env) env = "integration";

            System.out.println("ENV: " + env);

            String propertiesFilePath = env + ".properties";
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propertiesFilePath);

            prop.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return prop;
    }


    public String getCredifyHost(){ return prop.getProperty("credifyHost");}
    public String getCredifyAPIHost(){ return prop.getProperty("credifyAPIHost");}


}
