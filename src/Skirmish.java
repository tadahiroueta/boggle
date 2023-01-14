import java.util.HashSet;

public class Skirmish {
    public static int sum(int[] arr, int index) {
        if (index == arr.length) return 0;
        
        return arr[index] + sum(arr, index + 1);
    }
    
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    public static int findMin(int[] arr, int i, int min) {
        if (i == arr.length) return min;

        return findMin(arr, i + 1, arr[i] > min ? min : arr[i]);
    }

    public static int findMin(int[] arr) {
        return findMin(arr, 0, Integer.MAX_VALUE);
    }

    public static HashSet<String> allAB(int n, HashSet<String> previous) {
        if (n <= 0) return previous;

        HashSet<String> output = new HashSet<String>();
        for (String combination : previous) {
            output.add("a" + combination);
            output.add("b" + combination);
        }
        return allAB(n - 1, output);
    }

    public static void allAB(int n) {
        HashSet<String> empty = new HashSet<String>();
        empty.add("");
        for (String combination : allAB(n, empty)) System.out.print(combination + " ");
    }

    private static void permutation(String word, String previous) {
        if (word.length() == 0) System.out.print(previous + " ");

        else for (char character : word.toCharArray()) permutation(word.substring(0, word.indexOf(character)) + word.substring(word.indexOf(character) + 1), previous + character);
    }

    public static void permutation(String word) {
        permutation(word, "");
    }

    public static void main(String[] args) {
        permutation("what");
    }
}
