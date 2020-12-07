import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3b {
  public static void main(String[] args) throws FileNotFoundException {


    int rightArr [] = {1,3,5,7,1};
    int downArr  [] = {1,1,1,1,2};
    ArrayList<Integer> sums = new ArrayList<>();
    int right;
    for(int i = 0; i < 5; i++){
      right = rightArr[i];

      File f = new File("input/day3.txt");
      Scanner sc = new Scanner(f);
      int sum = 0;
      int index = 0;
      String line = sc.nextLine();
      int length = line.length();
      while(sc.hasNextLine()){
        index  +=right;
        index = index % line.length();
        if(downArr[i] == 2)
          line = sc.nextLine();
        line = sc.nextLine();
        if(line.charAt(index) == '#')
          sum++;
      }
      sums.add(sum);
      System.out.println(sums);
      
    }
    System.out.println(sums.get(0) * sums.get(1) * sums.get(2) * sums.get(3) * sums.get(4));
  }
}
