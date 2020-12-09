import java.util.Arrays;

public class test {

  public static void main(String arg[]) {
    int n = 6;
    double a[] = new double[n];


    double m = 0;
    if (n % 2 == 1) {
      m = a[(n + 1) / 2 - 1];
    } else {
      m = (a[n / 2 - 1] + a[n / 2]) / 2;
    }

    System.out.println("Median :" + m);
  }
}
