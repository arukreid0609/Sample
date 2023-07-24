package tramp;

import java.util.ArrayList;
import java.util.List;

public class Player {
	String name;// 名前
	List<Tramp> hand = new ArrayList<Tramp>();// 手札

	// コンストラクタ
	Player(String name) {
		this.name = name;
	}

	
	// 相手のトランプ引く
	public Tramp drawTramp(Player person, int selectNum) {
		// 不正値チェックするか否か・・・
		Tramp tramp = person.hand.remove(selectNum - 1);
		this.hand.add(tramp);
		System.out.println(this.name + "は" + person.name + "から" + tramp.text + "を引いた");
		return tramp;
	}

	// 数字がペアになったトランプを1組捨てる(最後に引いたトランプと比べてる)
	// ※drawTrampを呼び出した後に呼び出す前提
	public void disposeTramp() {
		int addTramp = this.hand.size() - 1;
		for(int i=0;i<addTramp;i++) {
			if(this.hand.get(addTramp).number == this.hand.get(i).number) {
				this.hand.remove(addTramp);
				this.hand.remove(i);
				System.out.println("トランプが揃った！捨てた。");
				return;
			}
		}
	}
	
	// 手札が無くなってるか判定
	public boolean isLostHand() {
		boolean result = this.hand.isEmpty();
		return result; 
	}
}
