import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day1 {

  public static void main(String[] args) throws FileNotFoundException {
    File f = new File("src/com/aoc/input/day1.txt");
    Scanner sc = new Scanner(f);
    int a;
    int b;
    int c;

    ArrayList<Integer> arr = new ArrayList<>();
    while (sc.hasNext()) {
      arr.add(sc.nextInt());
    }

    for(int i = 0; i < arr.size(); i++){
      a = arr.get(i);
      for(int j = i+1; j < arr.size(); j++){
        b = arr.get(j);
        if (a + b == 2020)
          System.out.println("part 1: " + (a*b));
        for(int k = j+1; k < arr.size(); k++ ) {
          c = arr.get(k);
          if (a + b + c == 2020)
            System.out.println("part 2: " + (a * b * c));
        }
      }
    }



  }
}
