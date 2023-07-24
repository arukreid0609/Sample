package tramp;

public class Tramp {

	String simbol;// マーク
	int number;// 数字
	String text;// マークと数字を合わせた文字列
	
	//Stringを使ったコンストラクタ
	Tramp(String simbol, int number){
		String[] numberTexts = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		this.simbol = simbol;
		this.number = number;
		if(simbol.equals("Joker"))text = "Joker";
		else text = simbol + numberTexts[number-1];
	}
}
