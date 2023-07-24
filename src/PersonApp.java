import java.util.Random;

public class PersonApp {
	public static void main(String[] args) {
		Random r = new Random();
		final int MAX_SCORE = 999;
		String[] names = { "A", "B", "C", "D", "E", "F" };
		Person[] people = new Person[100];
		// インスタンスを１００個作成
		for (int i = 0; i < people.length; i++) {
			String name = names[r.nextInt(names.length)];
			int score = r.nextInt(MAX_SCORE + 1);
			people[i] = new Person(name, score);
		}

		// scoreの値で降順ソート
		for (int i = 0; i < people.length - 1; i++) {
			for (int j = i + 1; j < people.length; j++) {
				if (people[i].score < people[j].score) {
					Person temp = people[i];
					people[i] = people[j];
					people[j] = temp;
				}
			}
		}

		// 上位１０件を表示
		for (int i = 0; i < 10; i++) {
			System.out.printf("%2d・・・%s[%d]\n", i + 1, people[i].name, people[i].score);

		}
	}
}
