package awsomecucumber.utils;

import awsomecucumber.constants.EnvType;
import awsomecucumber.domainobjects.Product;

import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;
    private static ConfigLoader configLoader;


    private ConfigLoader() {
       String env =  System.getProperty("env", String.valueOf(EnvType.STAGE));
       switch (EnvType.valueOf(env)){
           case PROD ->
                   properties = PropertyUtils.propertyLoader("src/test/resources/prod_config.properties");
           case STAGE ->
                   properties = PropertyUtils.propertyLoader("src/test/resources/stg_config.properties");
           default -> throw new IllegalStateException("INVALID ENV " + env);

       }

    }

    public static ConfigLoader getInstance(){
        if (configLoader == null){
            configLoader = new ConfigLoader();
        }

        return configLoader;
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if (prop != null) return prop;
        else throw new RuntimeException("PROPERTY BASE URL IS NOT SPECIFIED IN THE STG_CONFIG.PROPERTIES FILE");

    }
}
