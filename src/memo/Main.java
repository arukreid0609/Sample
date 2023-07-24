package memo;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		//リストを宣言
		ArrayList<String> names = new ArrayList<>();

		//リストに追加
		names.add("佐々木");
		names.add("野田");
		names.add("モンキー・D・ルフィ");

		//リストの中身を表示（for文）
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		//リストの中身を表示（拡張for文）
		for (String s : names) {
			System.out.println(s);
		}
	}
}
