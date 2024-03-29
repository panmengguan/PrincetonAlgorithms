public class Merge
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        sort(a, aux, 0, N-1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
    {
        if (lo >= hi) return;

        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
    {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)
        {
            if (i > mid)                   a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
    }

    private static boolean less(Comparable a, Comparable b)
    {  return a.compareTo(b) < 0;  }

    private static void show(Object[] a)
    {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    private static boolean isSorted(Comparable[] a)
    {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    public static void main(String[] args)
    {
        In in = new In(StdIn.readString());
        String[] a = in.readAllStrings();
        show(a);
        sort(a);
        show(a);

        /**
         * Random input test
         */
        StdOut.println("Random input test: ");
        int N = 1000;
        Double[] randomInput = new Double[N];
        for (int i = 0; i < N; i++)
            randomInput[i] = StdRandom.uniform();
        StdOut.println("First 10 samples of input: ");
        for (int i = 0; i < 10; i++)
            StdOut.print(randomInput[i] + " ");
        StdOut.println();
        sort(randomInput);
        StdOut.println("First 10 samples of sort output: ");
        for (int i = 0; i < 10; i++)
            StdOut.print(randomInput[i] + " ");
        StdOut.println();

        if (isSorted(randomInput)) StdOut.println("Random input test passed!\n");
        else             StdOut.println("Random input test NOT passed!\n");

        /**
         * Corner cases test
         */
        /* When the array is already sorted */
        StdOut.println("Corner cases test, 1: when the array is already sorted: ");
        StdOut.println("First 10 samples of input: ");
        for (int i = 0; i < 10; i++)
            StdOut.print(randomInput[i] + " ");
        StdOut.println();
        sort(randomInput);
        StdOut.println("First 10 samples of sort output: ");
        for (int i = 0; i < 10; i++)
            StdOut.print(randomInput[i] + " ");
        StdOut.println();

        if (isSorted(randomInput)) StdOut.println("When the array is already sorted, test passed!\n");
        else             StdOut.println("When the array is already sorted, test NOT passed!\n");

        /* When the array is in reverse order */
        StdOut.println("Corner cases test, 2: when the array is in reversed order: ");
        Integer[] reversedArr = new Integer[N];
        for (int i = 0; i < N; i++)
            reversedArr[i] = N - i;
        StdOut.println("First 10 samples of input: ");
        for (int i = 0; i < 10; i++)
            StdOut.print(reversedArr[i] + " ");
        StdOut.println();
        sort(reversedArr);
        StdOut.println("First 10 samples of sort output: ");
        for (int i = 0; i < 10; i++)
            StdOut.print(reversedArr[i] + " ");
        StdOut.println();
        if (isSorted(reversedArr)) StdOut.println("When the array is in reversed order, test passed!\n");
        else             StdOut.println("When the array is in reversed order, test NOT passed!\n");

        StdOut.println("Corner cases test, 3: when all the entries in array are the same: ");
        Integer[] sameKeyArr = new Integer[N];
        for (int i = 0; i < N; i++)
            sameKeyArr[i] = 1;
        StdOut.println("First 10 samples of input: ");
        for (int i = 0; i < 10; i++)
            StdOut.print(sameKeyArr[i] + " ");
        StdOut.println();
        sort(sameKeyArr);
        StdOut.println("First 10 samples of sort output: ");
        for (int i = 0; i < 10; i++)
            StdOut.print(sameKeyArr[i] + " ");
        StdOut.println();
        if (isSorted(sameKeyArr)) StdOut.println("when all the entries in array are the same, test passed!\n");
        else             StdOut.println("when all the entries in array are the same, test NOT passed!\n");

        StdOut.println("Corner cases test, 4: array consisting of only two distinct keys: ");
        Integer[] twoDistinctKeysArr = new Integer[N];
        for (int i = 0; i < N; i++)
            twoDistinctKeysArr[i] = i % 2;
        StdOut.println("First 10 samples of input: ");
        for (int i = 0; i < 10; i++)
            StdOut.print(twoDistinctKeysArr[i] + " ");
        StdOut.println();
        sort(twoDistinctKeysArr);
        StdOut.println("First 10 samples of sort output: ");
        for (int i = 0; i < 10; i++)
            StdOut.print(twoDistinctKeysArr[i] + " ");
        StdOut.println();
        if (isSorted(twoDistinctKeysArr)) StdOut.println("array consisting of only two distinct keys, test passed!\n");
        else             StdOut.println("array consisting of only two distinct keys, test NOT passed!\n");

        StdOut.println("Corner cases test, 5: array of size 0: ");
        String[] emptyArr = new String[0];
        sort(emptyArr);
        if (isSorted(emptyArr)) StdOut.println("array of size 0, test passed!\n");
        else             StdOut.println("array of size 0, test NOT passed!\n");

        StdOut.println("Corner cases test, 6: array of size 1: ");
        String[] arrOfSingleElem = new String[1];
        arrOfSingleElem[0] = "one";
        sort(arrOfSingleElem);
        if (isSorted(arrOfSingleElem)) StdOut.println("array of size 1, test passed!\n");
        else             StdOut.println("array of size 1, test NOT passed!\n");
    }
}