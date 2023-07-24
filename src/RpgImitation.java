import java.util.Scanner;

public class RpgImitation {

	public static void main(String[] args) {
		// ステータス用意
		String playerName = "佐々木";
		int playerHp = 50;
		int playerAttack = 5;
		int skillCount = 1;

		String enemyName = "スライム";
		int enemyHp = 50;
		int enemyAttack = 5;
		
		boolean isEnd = false;
		int turnCount = 1;

		Scanner sc = new Scanner(System.in);
		System.out.println("RPGもどき開始！！\n");
		System.out.println(enemyName + "が現れた！！\n");
		do {
			System.out.println(turnCount + "ターン目");
			// プレイヤーのターン
			System.out.println("どう攻撃する？");
			System.out.print("0:素手、1:武器、2:必殺技(" + skillCount + ") →");

			int damage = 0;
			String attackName = "";
			switch(sc.nextInt()) {
				case 0:
					damage = playerAttack;
					attackName = "素手";
					break;
				case 1:
					damage = playerAttack + 5;
					attackName = "武器";
					break;
				case 2:
					if(skillCount <= 0)break;
					damage = playerAttack * 3;
					attackName = "必殺技";
					skillCount--;
					break;
			}
			enemyHp -= damage;
			if (damage != 0) {
				System.out.println(playerName + "の" + attackName + "攻撃");
				System.out.println(enemyName + "に" + (damage) + "ダメージ与えた\n");
			}else System.out.println(attackName + "を使おうとしたけど不発に終わった。"+enemyName+"に0ダメージ…");

			// 敵のターン
			damage = enemyAttack;
			playerHp -= damage;
			System.out.println(enemyName + "の攻撃");
			System.out.println(playerName + "に" + (damage) + "ダメージ与えた\n\n");
			
			if(enemyHp <= 0)isEnd = true;
			turnCount++;
		} while (!isEnd);
		sc.close();
		System.out.println(playerName + "は" + enemyName + "に勝った！バトル終了");
	}
}
