package com.timegate.vportal;

import com.timegate.vportal.common.utils.MessageLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

@SpringBootApplication
public class VportalApplication {

    private static MessageLogger logger = new MessageLogger();

    public static void main(String[] args) {
        /**
         * Key-Encryptor Key read a application.properties.
         */
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        String kek = "";
        try {
            fileReader = new FileReader("administrator.ini",  Charset.forName("UTF-8"));
            bufferedReader = new BufferedReader(fileReader);
            if( (kek = bufferedReader.readLine()) !=null) {
                logger.infoLog(new Object() {}, "KEK - READ SUCCESS!!");
                logger.debugLog(new Object() {}, kek);
            } else {
                logger.errorLog(new Object(){}, new NullPointerException());
            }
        } catch (FileNotFoundException e) {
            logger.errorLog(new Object(){}, e);
        } catch (IOException e) {
            logger.errorLog(new Object(){}, e);
        } finally {
            try {
                if(fileReader != null) fileReader.close();
                if(bufferedReader != null) bufferedReader.close();
            } catch (IOException e) {
                logger.errorLog(new Object(){}, e);
            }
        }

        /**
         * Key-Encryptor Key validate checked null & empty
         */
        if( kek == null || (kek != null && kek.isEmpty()) ) {
            logger.errorLog(new Object(){}, "KEK NullPointerException");
            System.exit(1);
        } else {
            System.setProperty("KEK", kek);
        }

        /**
         * Key-Encryptor Key set of system.properties.
         */
        System.setProperty("KEK", kek);


        SpringApplication.run(VportalApplication.class, args);

        String version = System.getProperty("java.version");
    }

}
