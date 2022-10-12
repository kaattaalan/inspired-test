package com.ingg.test.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileLoader {

  //What's the diff b/w this and the next line ?
  //private static FileLoader fileLoaderInstance = new FileLoader();
  private static FileLoader fileLoaderInstance = null;

  private FileLoader() {}

  public static FileLoader getFileLoaderInstance() {
    if(fileLoaderInstance == null){
      fileLoaderInstance = new FileLoader();
    }
    return fileLoaderInstance;
  }

  public static String[] loadTextArrayFromFile() {
    if(charArray == null || charArray.length < 1){
      charArray = load("english.txt");
    }
    return charArray;
  }

  private static String[] charArray;

  private static String[] load(String fileName) {
    try (BufferedReader br =
        new BufferedReader(
            new InputStreamReader(
                    Objects.requireNonNull(FileLoader.class.getClassLoader().getResourceAsStream(fileName))))) {
      List<String> words = new ArrayList<>();
      String word = "";
      while ((word = br.readLine()) != null) words.add(word.replace("'", ""));
      return words.toArray(new String[0]);
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }
}
