import java.util.Scanner;

public class foreach1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

for (String car : cars) {
  System.out.println(car);
}
    }
}