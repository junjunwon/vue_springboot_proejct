package com.timegate.vportal.common.config;

import com.timegate.vportal.common.utils.JasyptAES256;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * JasyptConfig for properties encryption
 *
 * @author time-gate SDTeam
 * @since 2021.08.04
 */
@Configuration
public class JasyptConfig {
    // Data-Encryptor Key - encrypt data
    private static String DEK;
    // Data-Encryptor Key - plan data
    private static String key;

    /**
     * JasyptConfig Constructor
     *
     * @since 2021.08.04
     */
    public JasyptConfig() {
        try {
            FileReader resources = new FileReader("application.properties");
            Properties properties = new Properties();
            properties.load(resources);
            DEK = properties.getProperty("admin.password");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        JasyptAES256 jasyptAES256 = new JasyptAES256(System.getProperty("KEK"));
        //System.out.println("DEK>" + DEK);
        key = jasyptAES256.decrypt(DEK);
        //System.out.println("key>" + key);
    }

    /**
     * Encrypt algorithm properties initialization
     *
     * @since 2021.08.04
     * @return StringEncryptor
     */
    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(key);
        config.setAlgorithm("PBEWITHSHA256AND256BITAES-CBC-BC");
        config.setProvider(new BouncyCastleProvider());
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }

    /**
     * Encryption for plain text
     *
     * @since 2021.08.04
     * @param plainText
     * @return
     */
    public String encrypt(String plainText) {
        StringEncryptor encryptor = stringEncryptor() ;
        return encryptor.encrypt(plainText);
    }

    /**
     * Decryption for encrypt text
     *
     * @since 2021.08.04
     * @param crytText
     * @return
     */
    public String decrypt(String crytText) {
        StringEncryptor encryptor = stringEncryptor() ;
        return encryptor.decrypt(crytText);
    }
}