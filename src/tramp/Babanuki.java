package tramp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*ババ抜き
 * ルール：
 * 参加者は2人
 * 順番にお互いのトランプを引いて手札の数字と揃ったら捨てる
 * 先に手札が無くなった方が勝ち
 * */
public class Babanuki {

	public static void main(String[] args) {
		// 必要なモノ用意
		int shuffle = 100;// 山札のシャッフル回数
		int turnCount = 0;// ターン数
		Scanner sc = new Scanner(System.in);// Scanner使うのでインスタンス用意
		Player winPlayer = null;// 勝った人
		Player p1 = new Player("自分");
		Player p2 = new Player("相手");
		List<Player> players = new ArrayList<Player>();
		players.add(p1);
		players.add(p2);

		// トランプのインスタンスを生成し、リストに格納(山札にする)
		List<Tramp> tramps = new ArrayList<Tramp>();
		String[] simbols = {"♡","♤","♧","♢","Joker"};
		for (String simbol : simbols) {
			// ジョーカー１枚用意
			if (simbol.equals("Joker")) {
				Tramp tramp = new Tramp(simbol, 0);
				tramps.add(tramp);
				break;
			}
			// ジョーカー以外の１～１３のトランプ用意
			for (int i = 1; i <= 13; i++) {
				Tramp tramp = new Tramp(simbol, i);
				tramps.add(tramp);
			}
		}

		// 山札をシャッフル
		for (int i = 0; i < shuffle; i++) {
			int r = new Random().nextInt(tramps.size());// 山札から取るトランプを決める(上から何枚目か)
			Tramp tramp = tramps.remove(r);// 山札から1枚取る
			tramps.add(tramp);// 山札の1番下に追加し直す
		}
		// 一発でシャッフル出来るメソッド
		//		Collections.shuffle(tramps);

		// プレイヤー二人にトランプを配る
		while (tramps.size() > 0) {
			for (Player player : players) {
				player.hand.add(tramps.remove(0));
				if (tramps.size() <= 0)
					break;
			}
		}

		// 揃った数字を捨てる
		for (Player player : players) {
			// 手札の一番後ろから揃ってる数字が無いか見ていく
			for (int i = player.hand.size() - 1; i >= 0; i--) {
				for (int j = i - 1; j >= 0; j--) {
					if (player.hand.get(i).number == player.hand.get(j).number) {
						player.hand.remove(i);
						player.hand.remove(j);
						//removeしたらListの要素数が減るのでそれに合わせてiも減らす
						//減らさないとIndexOfOutBoundsエラーが発生する
						i--;
						break;
					}
				}
			}
		}

		// ゲーム開始！
		do {
			// それぞれの手札をコンソールに表示(CPU側は全部 ? で表示される)
			int selectNum;
			showHand(players.get(0));
			showHand(players.get(1), true);

			// 先攻の手番
			// どれを引くか選ぶ（プレイヤー側なので自分で指定する）
			while (true) {
				System.out.print("左から何番目を引く? > ");
				selectNum = sc.nextInt();
				if (selectNum <= players.get(1).hand.size()) {
					break;
				}
				System.out.println("もう一度選び直してください。");
			}
			// 選んだトランプを引く
			players.get(0).drawTramp(players.get(1), selectNum);
			// 数字が揃っていれば捨てる
			players.get(0).disposeTramp();
			// 手札が無くなればループを抜ける
			if (players.get(0).isLostHand()) {
				winPlayer = players.get(0);
				break;
			}

			// 後攻の手番
			// どれを引くか選ぶ（CPU側なので乱数で指定する）
			selectNum = new Random().nextInt(players.get(0).hand.size()) + 1;
			// 選んだトランプを引く
			players.get(1).drawTramp(players.get(0), selectNum);
			// 数字が揃っていれば捨てる
			players.get(1).disposeTramp();
			// 手札が無くなればループを抜ける
			if (players.get(1).isLostHand()) {
				winPlayer = players.get(1);
				break;
			}
			System.out.println();
		} while (true);

		// 結果発表
		System.out.println();
		showHand(players.get(0));
		showHand(players.get(1));
		System.out.println(winPlayer.name + "の勝ち！！");
	}

	/* ここから下はメソッド */

	// 手札を表示（第2引数でコンソール上で？と出るか選択）
	public static void showHand(Player player, boolean hide) {
		System.out.print(player.name + "の手札:");
		for (Tramp tramp : player.hand) {
			if (hide) {
				System.out.print("? ,");
			}
			else {
				System.out.print(tramp.text + ",");
			}
		}
		System.out.println();
	}

	// 手札を表示(表示を？にしない)
	public static void showHand(Player player) {
		showHand(player, false);
	}

}
