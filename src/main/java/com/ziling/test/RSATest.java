package com.ziling.test;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class RSATest {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException {

        Cipher.getInstance("RSA");
    }
}
