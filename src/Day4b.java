
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class Day4b {

  public static void main(String[] args) {
    String debug = "";
    String requiredField [] = {"byr","iyr","eyr", "hgt", "hcl", "ecl", "pid"};
    boolean flag = true;

    try {
      BufferedReader br = new BufferedReader(new FileReader("input/day4.txt"));

      HashMap<String,String> passport = new HashMap<>();
      String arr [];

      int validPassport = 0;
      String line;
      while ((line = br.readLine()) != null) {
        debug = line;

        if (!line.isEmpty()) {
          arr = debug.split(" ");
          for(String s: arr){
            passport.put(s.substring(0,s.indexOf(":")), s.substring(s.indexOf(":")+1));
          }
        }

        else{

          for (int i = 0; i < requiredField.length;i++){
            if(!(passport.containsKey(requiredField[i]))){
              flag = false;
              break;
            }

          }

          if(flag){
            if(validatePass(passport))
              validPassport++;
          }
          passport.clear();
          flag= true;
        }

      }

      if(validatePass(passport))
        validPassport++;
      System.out.println(validPassport);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static boolean validatePass(HashMap<String, String> passport) {

    boolean retVal = true;
    HashSet<String> eyeColors = new HashSet<>();
    eyeColors.add("amb");
    eyeColors.add("blu");
    eyeColors.add("brn");
    eyeColors.add("gry");
    eyeColors.add("grn");
    eyeColors.add("hzl");
    eyeColors.add("oth");


    int byr = Integer.parseInt(passport.get("byr"));
    if(byr < 1920 || byr > 2002 )
      return false;

    int iyr = Integer.parseInt(passport.get("iyr"));
    if(iyr < 2010 || iyr > 2020)
      return false;

    int eyr = Integer.parseInt(passport.get("eyr"));
    if(eyr < 2020 || eyr > 2030)
      return false;

    String hgt = passport.get("hgt");
    if(!validHgt(hgt))
      return false;

    String hcl = passport.get("hcl");
    if(!validateHcl(hcl))
      return false;

    String ecl = passport.get("ecl");
    if(!eyeColors.contains(ecl))
      return false;

    String pid = passport.get("pid");
    if(pid.length() != 9)
      return false;
    else {
      for(int i = 0; i < pid.length();i++){
        if(!Character.isDigit(pid.charAt(i)))
          return false;
      }
    }

    return retVal;
  }

  private static boolean validateHcl(String hcl) {

    if(hcl.length() == 7 && hcl.contains("#")){
      hcl = hcl.substring(1);
      for(int i = 0; i < hcl.length(); i++){
        String subString = hcl.substring(i,i+1);
        if(!(subString.matches(("[1234567890abcdef]")))){
          return false;
        }
      }

    }
    else{
      return false;
    }
    return true;
  }

  private static boolean validHgt(String hgt) {

    if(hgt.contains("cm")){
      hgt = hgt.substring(0,hgt.indexOf("cm"));
      int h = Integer.parseInt(hgt);
      if(h < 150 || h > 193)
        return false;
    }
    else if(hgt.contains("in")){
      hgt = hgt.substring(0,hgt.indexOf("in"));
      int h = Integer.parseInt(hgt);
      if(h < 59 || h > 76)
        return false;
    }
    else{
      return false;
    }
    return true;

  }


}