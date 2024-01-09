import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
// Java program for implementation of Selection Sort
class SelectionSort {
    void sort(int arr[]) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // Prints the array
    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
// Java program for implementation of Bubble Sort
class BubbleSort {
    void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    /* Prints the array */
    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
// Java program for implementation of Insertion Sort
class InsertionSort {
    /*Function to sort array using insertion sort*/
    void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /* A utility function to print array of size n*/
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}
public class Problem1
 {
    public static void main(String[] args) {
        // create instance of Random class
        Random rand = new Random();

        try {
            PrintWriter fileout = new PrintWriter(new FileWriter("C://Users//erika//Desktop//Homework1Java-copy//random1.txt"));

            for (int i = 1; i < 2001; i++) {
                int ran = rand.nextInt(2001);
                fileout.println(ran);
            }
            fileout.close();            
        }
        catch (Exception e) {
            System.out.println(e);
         }
        int[] z=new int[2000];
        for(int i=0;i<2000;i++) {
            try {
                String line = Files.readAllLines(Paths.get("C://Users//erika//Desktop//Homework1Java-copy//random1.txt")).get(i);
                z[i]=Integer.parseInt(line);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        SelectionSort ob = new SelectionSort();
        ob.sort(z);
        System.out.println("Sorted array through selection sort");
        ob.printArray(z);
        BubbleSort ob1 = new BubbleSort();
        ob1.bubbleSort(z);
        System.out.println("Sorted array through bubble sort");
        ob1.printArray(z);
        InsertionSort ob2 = new InsertionSort();
        ob2.sort(z);
        System.out.println("Sorted array through insertion sort");
        ob2.printArray(z);
    }
}
