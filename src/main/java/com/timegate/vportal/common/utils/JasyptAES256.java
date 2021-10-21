package com.timegate.vportal.common.utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

public class JasyptAES256 {
    public StringEncryptor encryptor = new PooledPBEStringEncryptor();

    /**
     * Encrypt algorithm properties initialization
     *
     * @since 2021.08.04
     * @return StringEncryptor
     */
    public JasyptAES256(String privateKey) {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(privateKey);
        config.setAlgorithm("PBEWITHSHA256AND256BITAES-CBC-BC");
        config.setProvider(new BouncyCastleProvider());
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);

        this.encryptor = encryptor;
    }

    /**
     * Encryption for plain text
     *
     * @since 2021.08.04
     * @param plainText
     * @return
     */
    public String encrypt(String plainText) {
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
        return encryptor.decrypt(crytText);
    }
}
