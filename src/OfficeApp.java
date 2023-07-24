import java.util.Random;
import java.util.Scanner;

public class OfficeApp {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		OfficeWorker[] workers = new OfficeWorker[3];

		for (int i = 0; i < workers.length; i++) {
			System.out.print((i + 1) + "人目の名前を入力してください>");
			String name = scan.nextLine();
			switch (random.nextInt(3)) {
			case 0:
				workers[i] = new EliteOfficeWorker(name);
				break;
			case 1:
				workers[i] = new OrdinaryOfficeWorker(name);
				break;
			case 2:
				workers[i] = new LazyOfficeWorker(name);
				break;
			}
			workers[i].introduce();
		}

		while (true) {
			System.out.println("誰の働きぶりを見に行きますか?");
			for (int i = 0; i <= workers.length; i++) {
				System.out.printf("%d・・・%s\n", i, i < workers.length ? workers[i].name : "終了");
			}
			System.out.print("番号を入力してください>");
			int num = scan.nextInt();
			if(num < workers.length) {
				workers[num].work();
			}else if(num == workers.length) {
				System.out.println("アプリケーションを終了します。");
				break;
			}else {
				System.out.println("その番号は存在しません。");
			}
		}
	}
}
