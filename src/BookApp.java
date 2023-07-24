import java.util.Scanner;

public class BookApp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int page = 0;
		int price = 0;
		int select = 0;

		System.out.print("本のページ数を入力してください >");
		page = scan.nextInt();
		System.out.print("本の価格を入力してください >");
		price = scan.nextInt();
		Book book = new Book(page, price);

		System.out.print("ノートのページ数を入力してください >");
		page = scan.nextInt();
		System.out.print("ノートの価格を入力してください >");
		price = scan.nextInt();
		NoteBook note = new NoteBook(page, price);

		while (true) {
			System.out.print("1. 本の情報表示 / 2. ノートの情報表示 / 3. ノートに追加書込 / 4.   終了>");
			select = scan.nextInt();

			switch (select) {
			case 1:
				book.displayInfo();
				break;
			case 2:
				note.displayInfo();
				break;
			case 3:
				System.out.print("書き込む内容を入力してください >");
				String text = new Scanner(System.in).nextLine();
				note.addContent(text);
				break;
			case 4:
				System.out.println("アプリケーションを終了します。");
				return;
			default:
				System.out.println("メニューにその選択肢はありません。");
			}
		}
	}
}
