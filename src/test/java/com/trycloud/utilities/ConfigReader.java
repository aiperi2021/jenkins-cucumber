package com.trycloud.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * A Utility class that load the keyvalue pair inside config.properties file
 * into Properties object and provide single method called
 * read to get the value out of the properties file we created.
 */
public class ConfigReader {
    // declare Properties object at class level so it can be accessible in static method
    //In this class we will implement the repeated steps of reading
    // from configuration.properties file
    //#1- Create the object of Properties
    private static Properties properties = new Properties();

    //#2 using static block to only load it one time.
    // we want to only load the file once , so we can use static block
    static {
        //#3- Get the path and open the file
        try {
            FileInputStream in = new FileInputStream("config.properties");

            //#4- Load the opened file into properties object
            properties.load(in);

            //closing the file in JVM Memory
            in.close();

        } catch (IOException e) {
            System.out.println("Error occurred while reading config.properties " + e.getMessage()) ;
        }
    }


    /**
     * Get the value of key according to the key provided
     * @param key the key you want to get the value from
     * @return the value of the key
     */
    //#5- Use the object to read from the configuration.properties file
    public static String read(String key) {
        return properties.getProperty(key);
    }
}
