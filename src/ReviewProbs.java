import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solutions for the CS3 Test04 Review (recursion)
 * 
 * @author bunnb
 */
public class ReviewProbs {
	
	public static String reverseString(String s) {
		System.out.println(s);
		if (s.length() <= 0)
			return s;
		
		return reverseString(s.substring(1)) + s.substring(0, 1); //string concatenated in reverse of method call
	}
	
	public static int sum(int[] nums) {
		return sum(nums, 0);	
	}
	
	private static int sum(int[] nums, int i) {
		if (i >= nums.length)
			return 0;
		
		return nums[i] + sum(nums, i + 1);
	}
	
	public static int findMin(int[] nums) {
		return findMin(nums, 0);
	}
	
	//pre-condition: there will be at least one element in the array
	//  (so it doesn't return int min for empty arrays)
	private static int findMin(int[] nums, int i) {
		if (i >= nums.length)
			return Integer.MAX_VALUE;
		
		return Math.min(nums[i], findMin(nums, i + 1)); //return smallest of current value and recursive call moving to next index
		
//		//alternate syntax, saving the 'temp' result into a local variable may increase clarity for some
//		
//		int min = findMin(nums, i + 1); //Int max, (Math.min(nums[length-1], Int max), Math.min(nums[length-2], nums[length-1]), etc.
//		
//		return Math.min(min, nums[i]);
	}
	
	public static int strDist(String str, String sub) {
		if (str.length() < sub.length()) //base case, too short to work
			return 0;
		
		//without the startsWith method it would be str.substring(0, sub.length()).equals(sub)
		//  startWith used for convenience
		else if (str.startsWith(sub) && str.endsWith(sub))       //found solution, return length of string
			return str.length();
		
		else if (!str.startsWith(sub))                           //doesn't start with sub, truncate first char and recur
			return strDist(str.substring(1), sub);
		
		return strDist(str.substring(0, str.length() - 1), sub); //doesn't start OR end with sub, truncate both first/last chars and recur
	}
	
	//one line version
//	public static int strDist(String str, String sub) {
//		  return (str.length() < sub.length())? 0 :                         //too short
//		         (str.startsWith(sub) && str.endsWith(sub))? str.length() : //win condition
//		         (!str.startsWith(sub))? strDist(str.substring(1), sub) :   //doesen't start with, truncate first
//		         strDist(str.substring(0, str.length() - 1), sub);          //doesn't start or end with, truncate first and last
//	}
	
	public static void allAB(int n) {
		allAB(n, "");
	}
	
	private static void allAB(int n, String s) {
		if (s.length() == n) //built up solution to desired length, output result
			System.out.println(s);
		else {
			allAB(n, s + "a");
			allAB(n, s + "b");
		}
	}
	
	public static void permutation(String word) {
		permutation("", word);
	}

	private static void permutation(String perm, String word) {
		if (word.isEmpty()) //could also use word.length() == 0
			System.out.println(perm);
		else {
			for (int i = 0; i < word.length(); i++) {  //try all chars in all positions
				permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
			}
		}
	}
	
	@Deprecated
	public static void diceRolls(int dice) { //not using
		List<Integer> chosen = new ArrayList<>();
		
		diceRolls(dice, chosen);
	}

	@Deprecated
	private static void diceRolls(int dice, List<Integer> chosen) { //not using
		if (dice == 0) 
			System.out.println(chosen);
		else {
			for (int i = 1; i <= 6; i++) {
				chosen.add(i); 
				diceRolls(dice - 1, chosen); 
				chosen.remove(chosen.size() - 1); //remove case for next branch of exploration
			}
		}
	}

	public static void combinations(String s, int length) {
		Set<String> all = new HashSet<String>(); // can also use a List and contains()

		combinations(s, "", all, length);

		for (String comb : all)
			System.out.println(comb);
	}

	private static void combinations(String s, String chosen, Set<String> all, int length) {
		if (length == 0) //base case: no choices left
			all.add(chosen); 
		else {
			for (int i = 0; i < s.length(); i++) {
				String ch = s.substring(i, i + 1);

				if (!chosen.contains(ch)) {
					String rest = s.substring(0, i) + s.substring(i + 1);
					combinations(rest, chosen + ch, all, length - 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(reverseString("summer"));
		System.out.println(sum(new int[] {1, 2, 3, 4}));
		System.out.println(findMin(new int[] {3, -4, 5, 0, 7}));
		//tests on CodingBat
		allAB(3);            System.out.println();
		permutation("what"); System.out.println();
	}
}
