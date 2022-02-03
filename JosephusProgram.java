import edu.princeton.cs.algs4.Queue;
import java.util.Scanner;

public class Josephus {

    Queue<Integer> sequence = new Queue<>();

    int n = 0; //total number of soldiers
    int m = 0; //number of soldiers skipped

    public Josephus(Queue<Integer> sequence, int m, int n){

        this.sequence = sequence;
        this.m = m;
        this.n = n;

        removalProcess();
    }

    void removalProcess(){

        if (m == 0 || m == 1)
            System.out.println("no survivors");

        int nextVictim = 0;
        int counter = 1;

        if (m > 1) {

            while (!sequence.isEmpty() && sequence.size() > 1) {

                if (counter == 1) {
                    nextVictim = (counter + m) - 1;
                }

                if (counter == nextVictim) {
                    System.out.print(sequence.peek() + " "); //this prints out the person who died
                    sequence.dequeue();
                    nextVictim = (nextVictim + 1) + m - 1; //this determines who the nextVictim is and updates the nextVictim var
                    counter++;
                }

                if (counter != nextVictim) {
                    int temp = sequence.peek();
                    sequence.enqueue(temp);
                    sequence.dequeue();
                    counter++;
                }

            }
            System.out.println(this.sequence); //prints out last person standing
        }
    }

    public static void main(String[] args) {

        Queue<Integer> sequence = new Queue<>(); //temporary sequence

        int n = 0;
        int m = 0;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter n: ");
        n = keyboard.nextInt();

        System.out.println("Enter m: ");
        m = keyboard.nextInt();

        for (int i = 0; i < n; i++){ //this fills queue with numbers
            sequence.enqueue(i+1);
        }

        new Josephus(sequence, m, n);

    }

}
