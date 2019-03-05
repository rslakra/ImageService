package com.rslakra.imageservice.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Author: Rohtash Singh Lakra
 * Created: 2019-02-17 12:01
 */
public class Utils {

    private static MessageDigest messageDigest;

    static {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            //TODO:better log it.
            ex.printStackTrace();
        }
    }

    /**
     * @param fileName
     * @return
     */
    public static String getExtension(String fileName) {
        return (fileName == null ? null : fileName.substring(fileName.lastIndexOf(".") + 1));
    }

    /**
     * @param file
     * @return
     */
    public static String getExtension(MultipartFile file) {
        return (file == null ? null : getExtension(file.getOriginalFilename()));
    }


    /**
     * @param value
     * @return
     */
    public static String toSHA256(String value) {
        return new String(messageDigest.digest(value.getBytes()));
    }


}
