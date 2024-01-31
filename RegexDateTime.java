import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexDateTime {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    String[] regexes = new String[3];
    regexes[0] = "([0]?[1-9]|[1][0-2])[-/]([0]?[1-9]|[1-3]\\d)[-/](\\d{2}|\\d{4})";
    regexes[1] = "(([2][0-3]|[01]?[0-9])[:][0-5][0-9]|([1][0-2]|[0]?[0-9])[:][0-5][0-9]\\s[AP][M])";
    regexes[2] = "("+regexes[0]+"\\s"+regexes[1]+")|("+regexes[1]+"\\s"+regexes[0]+")";
    for(int i = 0; i < regexes.length; i++) {
      regexes[i] = "^"+regexes[i]+"$";
    }
    String[] types = {"date","time","datetime"};
    ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
    for(int i = 0; i < 3; i++) {
      Scanner fin = new Scanner(new File(in.nextLine()));
      arr.add(new ArrayList<String>());
      while(fin.hasNextLine()) {
        arr.get(i).add(fin.nextLine());
      }
    }
    for(int i = 0; i < arr.size(); i++) {
      for(int j = 0; j < arr.get(i).size(); j++) {
        System.out.println(
          arr.get(i).get(j)+" is"+
          (arr.get(i).get(j).matches(regexes[i]) ? " " : " not ")+
          "a valid "+types[i]
        );
      }
      System.out.print("\n");
    }
  }
}