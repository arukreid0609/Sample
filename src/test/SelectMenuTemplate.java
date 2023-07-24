package test;

import java.util.Scanner;

public class SelectMenuTemplate {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 必要な準備をする。インスタンス化や必要な変数の宣言など
		
		// ここからメニュー画面
		while (true) {
			System.out.print("どれにする? 1:遊ぶ 2:食う 3:寝る 4:終了 >");
			int select = scan.nextInt();
			switch (select) {
			case 1:
				// 1の時の処理
				break;
			case 2:
				// 2の時の処理
				break;
			case 3:
				// 3の時の処理
				break;
			case 4:
				System.out.println("アプリを終了します。");
				return;
			default:
				System.out.println("選択肢に無い番号です。");
			}
		}
		// ループ終了後に必要な処理
	}
}
