package com.orange.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/2/7
 * @description
 */
public class PropertyUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyUtil.class);

    private PropertyUtil() {
        throw new IllegalArgumentException("not instance for you");
    }

    public static Properties load(ClassPathResource file) {
        Properties prop = new Properties();
        InputStream in = null;
        try {
            in = new FileInputStream(file.getFile());
            prop.load(in);
        } catch (FileNotFoundException e) {
            LOGGER.error("{}", e);
        } catch (IOException e) {
            LOGGER.error("{}", e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    LOGGER.error("{}", e);
                }
            }
        }
        return prop;
    }
}
