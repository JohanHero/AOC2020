import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Day2b {

  public static void main(String[] args) throws FileNotFoundException {
    File f = new File("input/day2.txt");
    Scanner sc = new Scanner(f);

    int validPasswords = 0;

    while(sc.hasNext()){
      String s = sc.nextLine();
      int first = Integer.parseInt(s.substring(0,s.indexOf("-")));
      int second = Integer.parseInt(s.substring(s.indexOf("-")+1,s.indexOf(" ")));
      char letter = s.substring(s.indexOf(" ")+1,s.indexOf(":")).charAt(0);
      String password = s.substring(s.indexOf(":"));
      if( (password.charAt(first+1) == letter & password.charAt(second+1) != letter)   ||   ( (password.charAt(first+1) != letter) & (password.charAt(second+1) == letter) ) )
        validPasswords++;
    }

    System.out.println(validPasswords);
  }

}
