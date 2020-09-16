/**
* Copyright (c) 2020 Copyright bp All Rights Reserved.
* Author: brian.li
* Date: 2020-07-19 12:52
* Desc: 
*/
package com.bpfaas.common.utils;

import java.io.File;

public class PathUtils {

  private static final char SEPARATOR_CHAR1;
  private static final char SEPARATOR_CHAR2;

  static {
    SEPARATOR_CHAR1 = File.separatorChar;
    SEPARATOR_CHAR2 = File.separatorChar == '/' ? '\\' : '/';
  }

  /**
   * join path use File.separator
   * 
   * @return
   */
  public static String join(String... paths) {
    StringBuilder buf = new StringBuilder("");
    for (int i = 0; i < paths.length; i++) {
      String p = paths[i];
      if (p == null || p.length() == 0) {
        continue;
      }
      if ("/".equals(p) || "\\".equals(p) || ".".equals(p)) {
        continue;
      }

      if (buf.length() > 0 && buf.charAt(buf.length() - 1) != SEPARATOR_CHAR1
          && buf.charAt(buf.length() - 1) != SEPARATOR_CHAR2 && p.charAt(0) != SEPARATOR_CHAR1
          && p.charAt(0) != SEPARATOR_CHAR2) {
        buf.append(File.separator);
      }
      buf.append(p);
    }

    return buf.toString().replace(SEPARATOR_CHAR2, SEPARATOR_CHAR1);
  }
}