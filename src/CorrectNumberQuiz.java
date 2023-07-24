
public class CorrectNumberQuiz {

	public static void main(String[] args) {
		int[] numbers = { 3, 4, 9 };
		numQuiz(numbers);
	}
	
	public static void numQuiz(int[] numbers) {
		boolean isCorrect = false;
		do {
			System.out.print("1桁の数字を入力してください >");
			int input = new java.util.Scanner(System.in).nextInt();
			for (int value : numbers) {
				if (value == input)isCorrect = true;
			}
			if(isCorrect)break;
			System.out.println("ハズレ！もう一回！");
		} while (true);
		System.out.println("アタリ！！");
	}
}
