package ch01.ex01_09;

import java.util.LinkedList;


public class Collection2Sample extends LinkedList<String> implements Collection2<String> {

  public static void main(String[] args) {
    Collection2Sample collection2Sample = new Collection2Sample();
    collection2Sample.add("Panda");
    collection2Sample.add("Dog");
    collection2Sample.add("Lesser Panda");
    collection2Sample.add("Cat");
    collection2Sample.add("Giant Panda");
    collection2Sample.forEachIf(
        string->System.out.println("*" + string + "*"),
        string->{
          if (string.indexOf("Panda") != -1) {
            return true;
          } else {
            return false;
          }
        }
        );
  }
}
