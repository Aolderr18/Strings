/*
 * Originally work is by Richard Dawkins
 */

public class MethinksItIsLikeAWeasle {
	private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz";
	private static int score = 0;

	public static void main(String[] args) {
		/**
		 * This program generates a random String and then changes one character
		 * at a time until the random String is equal to the Shakespeare quote
		 * "Methinks it is like a weasle".
		 */
		String goal = "METHINKS IT IS LIKE A WEASLE";
		String randomAlpha = getRandomString(goal.length());
		String randomBeta = getRandomString(goal.length());
		System.out.println(randomAlpha + "\tscore = " + score);
		while (score < 28) {
			randomAlpha = closerString(goal, randomAlpha, randomBeta);
			/*
			 * If the next String is closer to the quote, the next String
			 * replaces the current String.
			 */
			randomBeta = oneCharacterDifferent(randomAlpha);
			System.out.println(randomAlpha + "\tscore = " + score);
		}
	}

	private static String getRandomString(int length) {
		StringBuilder randomStringBuilder = new StringBuilder();
		int index = 0;
		while (index++ < length)
			randomStringBuilder.append(alphabet.charAt((int) (Math.random() * 53)));
		return randomStringBuilder.toString();
	}

	private static String oneCharacterDifferent(String s) {
		int index = (int) (Math.random() * s.length());
		StringBuilder differentCharacter = new StringBuilder();
		for (int t = 0; t < s.length(); ++t)
			if (!(t == index))
				differentCharacter.append(s.charAt(t));
			else
				differentCharacter.append(alphabet.charAt((int) (Math.random() * 52)));
		return differentCharacter.toString();
	}

	private static String closerString(String goal, String s0, String s1) {
		int s0_matches = 0, s1_matches = 0;
		/**
		 * Whichever String contains the most characters in common with the goal
		 * should be the return String.
		 */
		for (int u = 0; u < goal.length(); ++u) {
			if (s0.charAt(u) == goal.charAt(u))
				++s0_matches;
			if (s1.charAt(u) == goal.charAt(u))
				++s1_matches;
		}
		if (s0_matches > s1_matches) {
			score = s0_matches;
			return s0;
		}
		score = s1_matches;
		return s1;
	}
}
