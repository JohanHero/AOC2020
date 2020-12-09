import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Day5 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input/day5.txt"));


    int mid;
    int lowerRow = 0;
    int upperRow = 127;
    int seat = 0;
    int row = 0;
    int right = 7;
    int left = 0;
    String line;
    int highestSeatID = 0;


  while(( line = br.readLine()) != null) {

    for (int i = 0; i < 10; i++){


      if(line.charAt(i) == 'F'){
        mid = (lowerRow + upperRow)/2;
        upperRow =  mid;
        row = upperRow;               
      }
      else if(line.charAt(i) == 'B'){
        mid = (lowerRow + upperRow)/2;
        lowerRow = mid+1;
        row = lowerRow;;
      }
      else if(line.charAt(i) == 'R'){
        mid = (left + right)/2;
        left = mid+1;
        seat = left;
      }
      else if(line.charAt(i) == 'L'){
        mid = (left + right)/2;
        right =  mid;
        seat = right;
      }
    }
    if((row * 8 + seat) > highestSeatID)
      highestSeatID = row * 8 + seat;

    lowerRow = 0;
    upperRow = 127;
    seat = 0;
    row = 0;
    right = 7;
    left = 0;

    }
    System.out.println(highestSeatID);

  }

}
