// Objective of Program: This function should find and print the farthest pair in this array: the two values
// whose difference is greater than or equal to the difference of any other pair (in absolute value).The
// running time of your program should be linear (~n ) in the worst case.

public class FarthestPairFinder {

    static void findFarthestPair(double[] arr){

        int[] minAndMax = findMinAndMax(arr);

        int firstIndex = minAndMax[0]; //this int contains the index of the min value
        int secondIndex = minAndMax[1]; //this int contains the index of the max value

        double greatestDiff = (Math.abs(arr[secondIndex]-arr[firstIndex])); //greatest difference

        if(greatestDiff > 0){
            System.out.println("Farthest Pair: " + arr[firstIndex] + ", " + arr[secondIndex]);
        }

    }

    static int[] findMinAndMax(double[] arr){

        int[] indexes = {0,0}; //array used to store indexes of min/max values in the unsorted array

        int min = 0;
        int max = 0;

        for (int i = 0; i < arr.length-1; i++){

            if(i == 0 && arr[i] < arr[i+1]){ //if i == 0
                min = i;
                max = i+1;
            }else if (i == 0 && arr[i+1] < arr[i]){
                min = i+1;
                max = i;
            }

            if(i > 0 && arr[i] < arr[min]){ //if i > 0
                min = i;
            }else if(i > 0 && arr[i] > arr[max]){
                max = i;
            }
        }
        indexes[0] = min;
        indexes[1] = max;

        return indexes;
    }

    public static void main(String[] args){

        double[] arr = {0.82, -0.57, 51.23, 150.2, -74.12, 63.76, 910.5, 31.73, -0.25};

        findFarthestPair(arr);

    }
}
