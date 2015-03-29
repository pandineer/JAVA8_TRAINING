package ch09.ex09_02;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReplaceTryWithResource {

  public static void replaceTryWithResources(String inputPath, String outputPath) {
    Scanner in = null;
    PrintWriter out = null;
    try {
      in = new Scanner(Paths.get(inputPath));
      out = new PrintWriter(outputPath);
      while (in.hasNext()) {
        out.println(in.next().toLowerCase());
      }
    } catch (Exception e) {
      e.printStackTrace();
      try {
        if (in != null) {
          System.out.println("in is closed.");
          in.close();
        }
        if (out != null) {
          System.out.println("out is closed.");
          out.close();
        }
      } catch (Exception se) {
        e.addSuppressed(se);
      }
    } finally {
      if (in != null) {
        System.out.println("in is closed.");
        in.close();
      }
      if (out != null) {
        System.out.println("out is closed.");
        out.close();
      }
    }
  }

  public static void main(String[] args) {
    /*
    // From text
    try (Scanner in = new Scanner(Paths.get("/usr/share/dict/words"));
        PrintWriter out = new PrintWriter("/tmp/out.txt")) {
      while(in.hasNext())
        out.println(in.next().toLowerCase());
    }
    */
  }

}
