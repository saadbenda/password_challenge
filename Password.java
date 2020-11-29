
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Password {

	public static int facto(int i) {
		if (i == 0)
			return 1;
		return i * facto(i - 1);
	}

	public static int numberCombination(int k, int n) {
		return (facto(n) / (facto(k) * facto(n - k)));
	}

	public static Set<Integer> commonValues(List<Integer> a, List<Integer> b) {
		Set<Integer> commonValues = new HashSet<Integer>();
		for (int i : a) {
			for (int j : b) {
				if (i == j) {
					commonValues.add(i);
				}
			}
		}
		return commonValues;
	}

	public static List<Integer> displayQuestion(String question) {

		List<Integer> p = new ArrayList<Integer>();
		while (true) {
			Scanner in = new Scanner(System.in);
			System.out.println(question);
			if (in.hasNextInt()) {
				String temp = in.nextLine().trim();
				String[] tempA = temp.split(" ");
				for (String s : tempA) {
					p.add(Integer.parseInt(s));
				}
				break;
			} else {
				in.next();
				in = new Scanner(System.in);
				System.out.println(question.split(" ")[1] + " cannot be accepted, please retry");
			}

		}
		return p;
	}

	public static int displayQuestionParam(String question) {
		int i;

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println(question);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				break;
			} else {
				sc.next();
				sc = new Scanner(System.in);
				System.out.println(question.split(" ")[1] + " cannot be accepted, please retry");
			}
			// sc.close();
		}

		return i;
	}

	public static void main(String... strings) {

		int m = displayQuestionParam("enter m");
		int n = displayQuestionParam("enter n");
		int q = displayQuestionParam("enter q");

		List<Integer> p1 = displayQuestion("enter p1[m]");
		List<Integer> p2 = displayQuestion("enter p2[n]");
		List<Integer> p3 = displayQuestion("enter p3[q]");

		Set<Integer> commonValues = commonValues(p1, p2);
		for (int i : p3) {
			commonValues.remove(i);
		}
		n = commonValues.size();
		int result = 0;
		for (int k = 0; k <= n; k++) {
			result += numberCombination(k, n);
		}
		System.out.println("number of possible combination " + result);

	}
}
