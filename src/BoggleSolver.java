import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class BoggleSolver
{
	private final int[][] SCORE_MATRIX = {
		{ 0, 3, 5, 6, 7, 8 },
		{ 0, 1, 2, 3, 5, 11 }
	};

	public HashSet<String> dictionary;
	private HashSet<String> validWords;
	
	private class Die {
		int row, col;
		char letter;
		int hashCode;

		public Die(int row, int col, BoggleBoard board) {
			this.row = row;
			this.col = col;
			letter = board.getLetter(row, col);
			hashCode = board.rows() * row + col;
		}

		@Override
		public boolean equals(Object other) {
			Die otherDie = (Die) other;
			return this.row == otherDie.row && this.col == otherDie.col;
		}

		@Override
		public int hashCode() {
			return hashCode;
		}
	}

	// Initializes the data structure using the given array of strings as the dictionary.
	// (You can assume each word in the dictionary contains only the uppercase letters A - Z.)
	public BoggleSolver(String dictionaryName)
	{
		validWords = new HashSet<String>();
		dictionary = new HashSet<String>();
		try {
			Scanner scanner = new Scanner(new File(dictionaryName));
			while (scanner.hasNext()) dictionary.add(scanner.next());
		}
		catch (FileNotFoundException e) {
			System.out.println("Error: File not found.");
		}
	}

	private HashSet<Die> getNeighbours(Die die, BoggleBoard board) {
		HashSet<Die> neighbours = new HashSet<Die>();
		for (int row = die.row - 1; row <= die.row + 1; row++) for (int col = die.col - 1; col <= die.col + 1; col++) if (row >= 0 && row < board.rows() && col >= 0 && col < board.cols()) neighbours.add(new Die(row, col, board));
		return neighbours;
	}

	private void findValidWords(BoggleBoard board, Die die, String potentialWord, HashSet<Die> usedDie) {
		HashSet<Die> newUsedDie = new HashSet<Die>(usedDie);
		newUsedDie.add(die);
		char letter = die.letter;
		potentialWord = potentialWord + (letter == 'Q' ? "QU" : letter);
		if (dictionary.contains(potentialWord)) validWords.add(potentialWord);
		for (Die neighbour : getNeighbours(die, board)) 
			if (!newUsedDie.contains(neighbour)) 
				findValidWords(board, neighbour, potentialWord, newUsedDie);
	}

	// Returns the set of all valid words in the given Boggle board, as an Iterable object
	public Iterable<String> getAllValidWords(BoggleBoard board)
	{
		for (int row = 0; row < board.rows(); row++) for (int col = 0; col < board.cols(); col++) findValidWords(board, new Die(row, col, board), "", new HashSet<Die>());
		return validWords;

	}

	// Returns the score of the given word if it is in the dictionary, zero otherwise.
	// (You can assume the word contains only the uppercase letters A - Z.)
	public int scoreOf(String word)
	{
		for (int i = SCORE_MATRIX[0].length - 1; i >= 0; i--) if (word.length() >= SCORE_MATRIX[0][i]) return SCORE_MATRIX[1][i];
		System.out.println("Error: Cannot score word.");
		return -1;
	}

	public static void main(String[] args) {
		System.out.println("WORKING");

		final String PATH   = "./data/";
		BoggleBoard  board  = new BoggleBoard(PATH + "board-points4540.txt");
		BoggleSolver solver = new BoggleSolver(PATH + "dictionary-yawl.txt");

		int totalPoints = 0;

		for (String s : solver.getAllValidWords(board)) {
			System.out.println(s + ", points = " + solver.scoreOf(s));
			totalPoints += solver.scoreOf(s);
		}

		System.out.println("Score = " + totalPoints); //should print 84

		//new BoggleGame(4, 4);
	}

}
