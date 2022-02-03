// Objective of program: find 2 values whose difference is no greater than the difference
// of any other pair (in absolute value). And print out the pair after finding it.

import edu.princeton.cs.algs4.Merge;

public class ClosestPairFinder {

    static void findClosestPair(Double[] arr){

        int first = 0;

        int firstValue = first; //this variable keeps track of which index value 1 is located at
        int secondValue = first+1; //this variable keeps track of which index value 2 is located at

        double smallestDiff = Math.abs(arr[firstValue]-arr[secondValue]);

        for (int i = 1; i < arr.length-1; i++) {
            if (Math.abs(arr[i]-arr[i+1]) < smallestDiff){ //compares current difference with smallestDiff
                smallestDiff = Math.abs(arr[i]-arr[i+1]); //updates smallestDiff
                firstValue = i;
                secondValue = i+1;
            }
        }
        System.out.println("Closest Pair: " + arr[firstValue] + ", " + arr[secondValue]);

    }

    public static void main(String[] args) {
        Double[] arr = {-17.2, -5.21, -0.21, 1.25, 19.3, 91.35};

        if(arr.length == 1){
            System.out.println("List only consists of one decimal.");
        }

        Merge.sort(arr);

        findClosestPair(arr);

    }
}


