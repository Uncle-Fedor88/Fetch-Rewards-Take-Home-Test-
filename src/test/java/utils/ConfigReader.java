package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;
    public static void readFile(String fileName){

        String pathFile = "src\\test\\resources\\"+fileName+".properties";

        FileInputStream input  = null;
        try {
            input = new FileInputStream(pathFile);
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                input.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }

    public static String getProperty(String fileName, String key){
        readFile(fileName);
        return properties.getProperty(key);
    }





}
