import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3 {

  public static void main(String[] args) throws FileNotFoundException {
    File f = new File("input/day3.txt");
    Scanner sc = new Scanner(f);

    int sum = 0;
    int index = 0;
    String line = sc.nextLine();
    int length = line.length();
    while(sc.hasNextLine()){
      index  +=3;
      index = index % line.length();
      line = sc.nextLine();
      if(line.charAt(index) == '#')
        sum++;
    }
    System.out.println(sum);
  }
}
