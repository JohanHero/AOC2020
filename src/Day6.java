import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Day6 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input/day6.txt"));

    String line;
    int sum = 0;
    HashSet<Character> yesAnswers = new HashSet<>();


    while((line = br.readLine()) != null){

      if(line.isEmpty()){
        sum += yesAnswers.size();
        yesAnswers.clear();

      }
      else{
        for(int i = 0; i < line.length(); i++)
          yesAnswers.add(line.charAt(i));
      }

    }
    sum += yesAnswers.size();
    System.out.println(sum);

  }

}
