package com.test.helper;


import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;

public class PropertyLoader {
    private static CompositeConfiguration config;

    public PropertyLoader() {
        try {
            config = new CompositeConfiguration();
            config.addConfiguration(new SystemConfiguration());
            config.addConfiguration(new PropertiesConfiguration("src/config.properties"));
//            config.addConfiguration(new PropertiesConfiguration(PropertyLoader.class.getResource("/language/" + config.getString("language") + ".properties")));
        } catch (ConfigurationException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public static String getProperty(String Key) {
        return config.getString(Key);
    }

}