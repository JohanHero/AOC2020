import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Day2 {

  public static void main(String[] args) throws FileNotFoundException {
    File f = new File("input/day2.txt");
    Scanner sc = new Scanner(f);


    int validPasswords = 0;


    while(sc.hasNext()){
      String s = sc.nextLine();
      int min = Integer.parseInt(s.substring(0,s.indexOf("-")));
      int max = Integer.parseInt(s.substring(s.indexOf("-")+1,s.indexOf(" ")));
      String letter = s.substring(s.indexOf(" ")+1,s.indexOf(":"));
      String password = s.substring(s.indexOf(":"));
      int count = letterCounter(letter,password);
      if(count >= min && count <= max)
        validPasswords++;
    }

    System.out.println(validPasswords);
  }

  private static int letterCounter(String letter, String password) {
    int sum = 0;
    for(int i = 0; i < password.length(); i++)
      if(letter.charAt(0) == password.charAt(i))
        sum++;

      return sum;
  }

}
