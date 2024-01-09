import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.io.*; 
import java.util.*;

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

public class Problem11
{
    public static void main(String[] args) {
        Random rand = new Random();

        try {
            PrintWriter fileout = new PrintWriter(new FileWriter("C://Users//erika//Desktop//random1.txt"));

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
                String line = Files.readAllLines(Paths.get("C://Users//erika//Desktop//random1.txt")).get(i);
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
        int n = z.length; 
        Radix ob3 = new Radix();
        ob3.radixsort(z, n); 
        System.out.print("Sorted array through Radix Sort\n");
        ob3.printArray(z);
        QuickSort1 ob4 = new QuickSort1();
        ob4.sort(z, 0, n-1); 
        System.out.println("Sorted array through QuickSort"); 
        ob4.printArray(z); 
        
        
    }
}

class Radix{ 
    static void countSort(int arr[], int n, int exp) 
    { 
        int output[] = new int[n]; // output array 
        int i; 
        int count[] = new int[2001]; 
        Arrays.fill(count,0); 
        
        
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++; 
            
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 

        for (i = n - 1; i >= 0; i--) 
        { 
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
            count[ (arr[i]/exp)%10 ]--; 
        } 

       
        for (i = 0; i < n; i++) 
            arr[i] = output[i]; 
    } 

    
    static void radixsort(int arr[], int n) 
    { 
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        
        for (int exp = 1; mx/exp > 0; exp *= 10)
            countSort(arr, n, exp); 
                     
    } 

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println(); 
    }
    
}

class QuickSort1{
    static void random(int arr[],int low,int high) 
    { 
     
        Random rand= new Random(); 
        int pivot = rand.nextInt(high-low)+low; 
         
        int temp1=arr[pivot];  
        arr[pivot]=arr[high]; 
        arr[high]=temp1; 
    } 
     
    static int partition(int arr[], int low, int high) 
    { 
        // pivot is choosen randomly 
        random(arr,low,high);
        int pivot = arr[high]; 
        int i = (low-1); 
        for (int j = low; j < high; j++) 
        { 
            if (arr[j] < pivot) 
            { 
                i++;
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
 
        return i+1; 
    } 
 
    static void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr, low, high); 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 
 
   
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
 
   
} 

