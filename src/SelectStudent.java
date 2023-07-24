import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
/*使用した知識
 * */
public class SelectStudent {
	//フィールド
	static Random rd = new Random();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		//変数用意
		String[] students = {"岩鶴","児島","陣内","田村","テイレイ","成田","野田"};
		HashMap<String,Integer> resultMap = new HashMap<String,Integer>();

		String dirPass = "csv/SelectStudents/";
		String fileName = "result.csv";
		String pass = dirPass + fileName;

		//マップに生徒の名前をキーとしてセット,Valueは0
		System.out.println("***運命の生徒をキメる！！***\n");
		System.out.print("前回のデータを使いますか？使う：Enter,新規で：1 →");
		
		//前回データを使うかどうか
		if(sc.nextLine().equals("1")) {
			//新規ファイル作成
			for(String name : students) resultMap.put(name, 0);//生徒名準備
			System.out.println("\n新規で始めます！！\n");
			writeData(resultMap,dirPass + fileName);
		}else {
			// 前回データを引継ぎ
			BufferedReader br = readFile(pass);
			String line;
			while((line = br.readLine()) != null) {
				String[] params = line.split(",");
				resultMap.put(params[0], Integer.parseInt(params[1]));
			}
			br.close();
		}
		
		//抽選開始
		System.out.print("\n抽選を開始します。Enterを押して：\n");
		sc.nextLine();
		while(true) {
			String[] arr = new String[resultMap.keySet().size()];
			String name = selectStudent(resultMap.keySet().toArray(arr));
			int totalNum = resultMap.get(name) + 1;

			resultMap.put(name, totalNum);
			System.out.print("抽選を続けるなら:Enter,終わるなら:0を入力:");
			if(sc.nextLine().equals("0"))break;
			System.out.println();
		}

		//集計結果を表示
		for(String name : resultMap.keySet()) {
			System.out.println(name + ":"+ resultMap.get(name));
		}
		writeData(resultMap,dirPass + fileName);

		//終了のお知らせ
		System.out.print("Enter押すと終了:");
		sc.nextLine();
		System.out.println("お疲れさまでした");
		sc.close();
	}
	
	/*ここから下はメソッド*/

	//生徒を一人選ぶ
	static String selectStudent(String[] students) {
		String name = students[rd.nextInt(students.length)];
		System.out.println(name + "\n");
		return name;
	}
	
	// 読み込み用にファイルを開く
	static BufferedReader readFile(String pass) {
		BufferedReader br;
		try {
			FileInputStream fis = new FileInputStream(pass);
			InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
			br = new BufferedReader(isr);
		} catch (IOException e) {
			System.out.println("ファイルが見つかりませんでした。");
			return null;
		}
		return br;
	}

	// 書き込み用にファイルを開く
	static BufferedWriter writeFile(String pass) {
		BufferedWriter bw;
		try {
			FileOutputStream fos = new FileOutputStream(pass);
			OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
			bw = new BufferedWriter(osw);
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.out.println("ファイルが見つかりませんでした。");
			return null;
		}
		return bw;
	}
	
	// 新規ディレクトリ作成
	static void makeNewDir(String dirName) {
		File dir = new File(dirName);
		if(dir.mkdir()) System.out.println("フォルダ作成成功");
		else System.out.println("フォルダ作成失敗");
	}

	// 新規ファイル作成
	static void createNewFile(String filePass) throws IOException {
		File file = new File(filePass);
		System.out.println(file.exists());
		if(file.createNewFile()) System.out.println("ファイル作成成功");
		else System.out.println("ファイル作成失敗");
	}
	
	// データ書き込み
	static void writeData(HashMap<String,Integer> map,String pass) throws IOException {
		BufferedWriter bw = writeFile(pass);
		for(String key : map.keySet()) {
			String line = key + "," + map.get(key);
			bw.write(line);
			bw.newLine();
		}
		bw.close();
	}
}
