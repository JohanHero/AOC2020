import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day4 {

  public static void main(String[] args) {

    String requiredField [] = {"byr","iyr","eyr", "hgt", "hcl", "ecl", "pid"};
    try {
      BufferedReader br = new BufferedReader(new FileReader("input/day4.txt"));

      HashMap<String,String> passport = new HashMap<>();
      String arr [];
      boolean flag = true;

      int validPassport = 0;
      String line;
      while ((line = br.readLine()) != null) {
        String debug = line;

        if (!line.isEmpty()) {
          arr = debug.split(" ");
          for(String s: arr){
            passport.put(s.substring(0,s.indexOf(":")), s.substring(s.indexOf(":")+1));
          }
        }
        else {

          for (int i = 0; i < requiredField.length; i++) {
            if (!(passport.containsKey(requiredField[i]))) {
              flag = false;
              break;
            }

          }
          if(flag){
            validPassport++;

          }
          flag = true;
          passport.clear();

        }

      }
      //Adding this outside the loop since the last passport wont be counted otherwise.

      for (int i = 0; i < requiredField.length; i++) {
        if (!(passport.containsKey(requiredField[i]))) {
          flag = false;
          break;
        }

      }
      if(flag) {
        validPassport++;
      }


      System.out.println(validPassport);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
