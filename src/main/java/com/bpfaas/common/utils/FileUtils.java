/**
* Copyright (c) 2020 Copyright bp All Rights Reserved.
* Author: brian.li
* Date: 2020-07-19 12:52
* Desc: 
*/
package com.bpfaas.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import com.bpfaas.common.exception.FaasException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileUtils {

  /**
   * Assure the directory is existed.
   * 
   * @return
   */
  public static boolean assureDir(String destDirName) {
    if (!destDirName.endsWith(File.separator)) {
      destDirName = destDirName + File.separator;
    }
    File dir = new File(destDirName);
    if (dir.exists() && dir.isDirectory()) {
      return false;
    }
    // 创建目录
    if (dir.mkdirs()) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * copy directory
   * 
   * @param sourcePath
   * @param newPath
   */
  public static void dirCopy(String src, String dest) throws FaasException {
    File start = new File(src);
    File end = new File(dest);
    String[] filePath = start.list();
    if (!end.exists()) {
      end.mkdir();
    }

    for (String temp : filePath) {
      // 查看其数组中每一个是文件还是文件夹
      String dir = PathUtils.join(src, temp);
      if (src.equals(dir)) {
        continue;
      }

      if (new File(PathUtils.join(src, temp)).isDirectory()) {
        // 为文件夹，进行递归
        dirCopy(PathUtils.join(src, temp), PathUtils.join(dest, temp));
      } else {
        // 为文件则进行拷贝
        fileCopy(PathUtils.join(src, temp), PathUtils.join(dest, temp));
      }
    }
  }

  /**
   * remove dir.
   */
  public static boolean dirRemoveRecursive(String path) {
    File file = new File(path);
    if (!file.exists()) {
      return false;
    }
    if (!file.isDirectory()) {
      return false;
    }
    File[] files = file.listFiles();
    for (File f : files) {
      if (f.isFile()) {
        if (!f.delete()) {
          return false;
        }
      } else {
        if (!dirRemoveRecursive(f.getAbsolutePath())) {
          return false;
        }
      }
    }
    return file.delete();
  }

  /**
   * remove file.
   */
  public static boolean fileRemove(String path) {
    File file = new File(path);
    if (!file.exists()) {
      return false;
    }
    if (file.isFile()) {
      return file.delete();
    }
    return false;
  }

  /**
   * copy file.
   * 
   * @param src
   * @param dest
   */
  public static void fileCopy(String src, String dest) throws FaasException {
    File start = new File(src);
    File end = new File(dest);
    try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(start));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(end))) {
      int len = 0;
      byte[] flush = new byte[1024];
      while ((len = bis.read(flush)) != -1) {
        bos.write(flush, 0, len);
      }
      bos.flush();
    } catch (Exception e) {
      throw new FaasException("fileCopy error", e);
    }
  }

  /**
   * 读取inputstream文本.
   * 
   * @param is 输入流; 操作完成后未对流进行 close.
   * @return 文本内容.
   */
  public static String readFile(InputStream is, String charsetName) throws IOException {

    StringBuilder content = new StringBuilder();

    byte[] buf = new byte[1024];
    do {
      int i = is.read(buf, 0, buf.length);
      if (i > 0) {
        content.append(new String(buf, 0, i, charsetName));
      }
      if (i < buf.length) {
        break;
      }
    } while (true);

    return content.toString();
  }

  /**
   * 读取文件文本.
   * 
   * @param file 文件句柄
   * @return 文本内容.
   */
  public static String readFile(File file, String charsetName) throws IOException {

    try (InputStream is = new FileInputStream(file)) {
      StringBuilder content = new StringBuilder();

      byte[] buf = new byte[1024];
      do {
        int i = is.read(buf, 0, buf.length);
        if (i > 0) {
          content.append(new String(buf, 0, i, charsetName));
        }
        if (i < buf.length) {
          break;
        }
      } while (true);

      return content.toString();
    }
  }

  /**
   * 读取文件文本 (utf8).
   * 
   * @param file 文件句柄
   * @return 文本内容.
   */
  public static String readFile(File file) throws IOException {
    return readFile(file, StandardCharsets.UTF_8.name());
  }

  /**
   * 读取文件文本.
   * 
   * @param filepath 文件路径
   * @return 文本内容.
   */
  public static String readFile(String filepath, String charsetName) throws IOException {
    return readFile(new File(filepath), charsetName);
  }

  /**
   * 读取文件文本 (utf8).
   * 
   * @param filepath 文件路径
   * @return 文本内容.
   */
  public static String readFile(String filepath) throws IOException {
    return readFile(new File(filepath), StandardCharsets.UTF_8.name());
  }

  /**
   * 写入文件文本.
   * 
   * @param file    文件句柄
   * @param content 要写入的文本
   * @return 文本内容.
   */
  public static void writeFile(File file, String content, String charsetName) throws IOException {
    try (OutputStream os = new FileOutputStream(file)) {
      os.write(content.getBytes(charsetName));
    }
  }

  /**
   * 写入文件文本 (utf8).
   * 
   * @param file 文件句柄
   * @return 文本内容.
   */
  public static void writeFile(File file, String content) throws IOException {
    writeFile(file, content, StandardCharsets.UTF_8.name());
  }

  /**
   * 写入文件文本.
   * 
   * @param filepath 文件路径
   * @return 文本内容.
   */
  public static void writeFile(String filepath, String content, String charsetName) throws IOException {
    writeFile(new File(filepath), content, charsetName);
  }

  /**
   * 写入文件文本 (utf8).
   * 
   * @param filepath 文件路径
   * @return 文本内容.
   */
  public static void writeFile(String filepath, String content) throws IOException {
    writeFile(new File(filepath), content, StandardCharsets.UTF_8.name());
  }
}