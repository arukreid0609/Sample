package tramp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*改良版ババ抜き
 * ルール：
 * 参加者は2人以上(3人や4人など)
 * 順番に次の手番の人のトランプを引いて手札の数字と揃ったら捨てる
 * 一番最初に手札が無くなった人が勝ち
 * */

public class BabanukiMk2 {
	public static void main(String[] args) {
		// 必要なモノ用意
		int shuffle = 100;
		int turnCount = 0;
		Player winPlayer = null;
		List<Player> players = new ArrayList<Player>();
		players.add(new Player("自分"));
		players.add(new Player("相手"));
		players.add(new Player("相手2"));

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
			int r = new Random().nextInt(tramps.size());
			Tramp tramp = tramps.remove(r);
			tramps.add(tramp);
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
						i--;
						break;
					}
				}
			}
		}

		// ゲーム開始！
		do {
			// 現在の手番はプレイヤーかどうか
			boolean isPlayer = (turnCount % players.size() == 0);
			// それぞれの手札をコンソールに表示(CPU側は全部 ? で表示される)
			if (isPlayer) {
				showAllHand(players);
			}
			System.out.println();

			// 現在の手番のプレイヤーが引く
			winPlayer = drawPlayerTurn(players, turnCount, isPlayer);
			System.out.println("------------------------------------");

			// あがりの人が居たら終了
			if (winPlayer != null) {
				break;
			}
			System.out.println();
			turnCount++;
		} while (true);

		// 結果発表
		System.out.println();
		showAllHand(players);
		System.out.println(winPlayer.name + "の勝ち！！");

	}

	/* ここから下はメソッド */

	// 手番の人が引く 戻り値はあがりの人
	public static Player drawPlayerTurn(List<Player> players, int turnCount, boolean isPlayer) {
		int currentOrder = turnCount % players.size();
		int nextOrder = (turnCount + 1) % players.size();
		int selectNum;
		System.out.println("【" + players.get(currentOrder).name + "の番】");
		// 引くトランプを決める
		if (isPlayer) {// プレイヤーの時は自分で決める
			while (true) {
				System.out.print("左から何番目を引く? > ");
				selectNum = new Scanner(System.in).nextInt();
				if (selectNum <= players.get(1).hand.size()) {
					break;
				}
				System.out.println("もう一度選び直してください。");
			}
		} else {// CPUの時はランダムに決める
			selectNum = new Random().nextInt(players.get(nextOrder).hand.size()) + 1;
		}

		// 選んだトランプを引く
		players.get(currentOrder).drawTramp(players.get(nextOrder), selectNum);
		// 相手の手札が無くなれば相手のあがり
		if (players.get(nextOrder).isLostHand()) {
			return players.get(nextOrder);
		}

		// 数字が揃っていれば捨てる
		players.get(currentOrder).disposeTramp();
		// 自分の手札が無くなれば自分のあがり
		if (players.get(currentOrder).isLostHand()) {
			return players.get(currentOrder);
		}
		// まだ誰もあがってない時はnull
		return null;
	}

	// 全員の手札を表示
	public static void showAllHand(List<Player> players) {
		showHand(players.get(0));
		for (int i = 1; i < players.size(); i++) {
			showHand(players.get(i), true);
		}
	}

	// 手札を表示（第2引数でコンソール上で？と出るか選択）
	public static void showHand(Player player, boolean ishide) {
		System.out.print(player.name + "の手札:");
		for (Tramp tramp : player.hand) {
			if (ishide)
				System.out.print("? ,");
			else
				System.out.print(tramp.text + ",");
		}
		System.out.println();
	}

	// 手札を表示
	public static void showHand(Player player) {
		showHand(player, false);
	}

}
