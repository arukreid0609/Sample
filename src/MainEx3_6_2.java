import java.util.Random;
import java.util.Scanner;

public class MainEx3_6_2 {

	public static void main(String[] args) {
		System.out.println("【数当てゲーム】");
		Random r = new Random();
		Scanner scan = new Scanner(System.in);
		int ans = r.nextInt(10);
		
		for(int i = 0; i< 5;i++) {
			System.out.print("0～9の数字を入力してください > ");
			int num = scan.nextInt();
			String result = num == ans ? "当たり!" : "ハズレ!";
			System.out.println(result);
			if(result.equals("当たり!"))break;
		}
		System.out.println("ゲームを終了します。");
	}
}