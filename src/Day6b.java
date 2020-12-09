import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class Day6b {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new FileReader("input/day6.txt"));

    String line;
    int sum = 0;

    int arr [] = new int[26];

    HashSet<Character> yesAnswers = new HashSet<>();
    int lineCounter = 0;

    while((line = br.readLine()) != null){

      if(line.isEmpty()){
        for(int i = 0; i < 26;i++){
          if(lineCounter == arr[i])
            sum++;
        }
        lineCounter = 0;
//        arr = null;
        arr = new int[26];

      }else{
        lineCounter++;
        for(int i = 0; i < line.length(); i++)
          arr[(int)line.charAt(i)-97]++;
      }

    }
    for(int i = 0; i < 26;i++){
      if(lineCounter == arr[i])
        sum++;
    }

    System.out.println(sum);

  }
}
