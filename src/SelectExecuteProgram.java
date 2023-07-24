import java.util.ArrayList;
import java.util.List;

public class SelectExecuteProgram {

	public static void main(String[] args) {
		System.out.println();
		Main.main(args);
//		new Main().excute();
		Main2.main(args);
		int[][] a = new int[2][2];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println("\n");

		}

		List<Integer> list = new ArrayList<Integer>();
		System.out.println(list.add(null));
		//		RpgImitation.main(args);
	}

}
