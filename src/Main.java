
public class Main {
	public static void main(String[] args) {
		int num1 = 15;
		int num2 = 20;
		// メソッドを呼び出して足し算結果を受け取る
		int sum = add(num1, num2);
		// 画面に足し算の結果を表示する
		System.out.println(sum);
	}

	// 定義しておいたメソッド
	public static int add(int num1, int num2) {
		int sum = num1 + num2;
		return sum;
	}
}
