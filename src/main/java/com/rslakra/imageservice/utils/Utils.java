/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
