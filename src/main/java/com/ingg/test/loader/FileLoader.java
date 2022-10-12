package com.ingg.test.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileLoader {

  private FileLoader() {}

  public static String[] loadTextArrayFromFile() {
    return load("english.txt");
  }

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
