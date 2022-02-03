public class MinimumFinder {

    static void findLocalMinimum(int arr[]){

        int size, first, last, middle, localMin;

        size = arr.length;
        first = 0;
        last = size-1;
        middle = (size/2);

        if(arr.length == 1)
            middle = 0;
        else if (arr.length == 2)
            middle = 1;

        localMin = locateLocalMin(arr, first, last, middle, arr.length);
        System.out.println(localMin);

    }

    static int locateLocalMin(int arr[], int first, int last, int middle, int size){

        int localMin = 0;
        int left = middle-1;
        int right = middle+1;

        if(size == 1){
            return arr[0];
        }else if(size == 2 && arr[first] < arr[middle]){ //if list contains only 2 ints
            return arr[first];
        }else if(size == 2 && arr[middle] < arr[first]){
            return arr[middle];
        }

        boolean checkNeighbors = (arr[middle-1] > arr[middle] && arr[middle] < arr[middle+1]);

        if(size == 3 && checkNeighbors){ //if list only contains 3 ints OR size becomes 3
            return arr[middle];
        }else if (size == 3 && arr[first] < arr[last]){
            return arr[first];
        }else if (size == 3 && arr[first] > arr[last]){
            return arr[last];
        }

        if(checkNeighbors){ //this may be redundant
            return arr[middle];
        }

        if(size > 3 && checkNeighbors){
            return arr[middle];
        }else if (arr[left] < arr[right] && size > 3){

            if((size/2)+1 == 3){ //if size == 3, it will return the first three elements of the list
                middle = 1;
                return locateLocalMin(arr, 0, 2, middle,(size/2)+1);
            }
            return locateLocalMin(arr, first, middle, middle/2 ,(size/2)+1);

        }else if(arr[right] < arr[left] && size > 3){

            if((size/2)+1 == 3){ //if size == 3, it will return the last three elements of the list
                middle = (arr.length-1)-1;
                return locateLocalMin(arr, middle-1, last, middle,(size/2)+1);
            }
            return locateLocalMin(arr, middle, last, middle+(middle/2),(size/2)+1);

        }

        return localMin;
    }

    public static void main(String[] args) {

        int array1[] = {91};
        int array2[] = {119, 56};
        int array3[] = {5, 7, 140, 16, 70};
        int array4[] = {70, 1000, 10, 144, 82, 6, 90, 5, 16, 280, 901, 950, 52, 3, 650, 19};

        System.out.println("Local Min from list 1: ");
        findLocalMinimum(array1);

        System.out.println("Local Min from list 2: ");
        findLocalMinimum(array2);

        System.out.println("Local Min from list 3: ");
        findLocalMinimum(array3);

        System.out.println("Local Min from list 4: ");
        findLocalMinimum(array4);

    }
}