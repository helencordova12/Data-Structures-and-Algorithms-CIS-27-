// Program Created By Margarita Cordova
// Java Etudes Assignment ~ Part 4

public class FibProgram {

    static int first, second;
    static int fibNumber;

    public static long F(int number){

        if (number == 0){
            first = number;
            return 0;
        }

        if (number == 1){
            second = number;
            return 1;
        }

        if (number > 1) {
            fibNumber = first + second;
            first = second;
            second = fibNumber;
        }
        return fibNumber;

    }

    public static void main(String[] args) {

        for (int n = 0; n < 100; n++) {
            System.out.println(n + " " + F(n));
        }
    }

}
