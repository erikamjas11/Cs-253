public class problem2 {
    public static int operations = 0;
    public static int comparisons = 0;
    public static int[] numbers = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static int fact(int i) {
        comparisons++;
        if (i <= 1) {
            return 1;
        } else {
            operations++;
            return i * fact(i - 1);
        }
    }
    
    
    public static boolean binary(int[] list, int goal, int low, int high) {
        operations++;
        int middle = (low + high) / 2;

        if (list[middle] == goal) {
            return true;
        } else {

            if (low > high) {
                return false;
            } else {
                comparisons++;
                if (list[middle] < goal) {
                    return binary(list, goal, middle + 1, high);
                } else {
                    return binary(list, goal, low, middle + 1);
                }
            }
        }
    }

   
    public static int fib(int i) {
        comparisons++;
        if (i == 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        } else {
            operations++;
            return fib(i - 1) + fib (i - 2);
        }
    }
    
    
    
    public static void main(String[] args) {
        System.out.println("fact of 5: " + fact(5));
        System.out.println("Number of operations are: " + operations);
        System.out.println("Number of comparisons are: " + comparisons);
        operations = 0;
        comparisons = 0;
        System.out.println();
        System.out.println("Recursive binary");
        binary(numbers, 8, 0, numbers.length);
        System.out.println("The Number of operations are : " + operations);
        System.out.println("The Number of comparisons are : " + comparisons);
        operations = 0;
        comparisons = 0;
        System.out.println();
        System.out.println("5th fib number: " + fib(5));
        System.out.println("The Number of operations are : " + operations);
        System.out.println("The Number of comparisons are : " + comparisons);
        operations = 0;
        comparisons = 0;
        
    }
}
