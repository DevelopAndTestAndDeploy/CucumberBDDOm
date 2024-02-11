package awsomecucumber.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

    public static Properties propertyLoader(String filePath){
        Properties properties = new Properties();
        BufferedReader reader;

        try{
            reader = new BufferedReader(new FileReader(filePath));
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e){
                e.printStackTrace();
                throw new RuntimeException("FAILED TO LOAD PROPERTIES FILE " + filePath);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("PROPERTIES FILE NOT FOUND " + filePath);
        }

        return properties;
    }
}
