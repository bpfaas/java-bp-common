package com.bpfaas.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptUtils {

  public static String sha1(String input) throws NoSuchAlgorithmException {
    if (input == null) {
      throw new IllegalArgumentException("params: input");
    }
    return sha1(input.getBytes());
  }

  public static String sha1(byte[] input) throws NoSuchAlgorithmException {
    if (input == null) {
      throw new IllegalArgumentException("params: input");
    }
    
    MessageDigest mDigest = MessageDigest.getInstance("SHA1");
    byte[] result = mDigest.digest(input);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < result.length; i++) {
      sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
    }
    return sb.toString();
  }
}