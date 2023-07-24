package tramp;

import java.util.function.Consumer;

public class MeasureTime {
	static long startTime;
	static long endTime;

	public static void start() {
		//		MeasureTime.startTime = System.currentTimeMillis();
		MeasureTime.startTime = System.nanoTime();
	}

	public static long end() {
//		MeasureTime.endTime = System.currentTimeMillis();
		MeasureTime.endTime = System.nanoTime();
//		if(MeasureTime.endTime > MeasureTime.startTime)return 0;
		return MeasureTime.endTime - MeasureTime.startTime;

	}

//	public static void measureProcessingTime(Consumer<Void> func) {
	public static void measureProcessingTime(Consumer<String> func) {
		start();
		for(int i = 0;i<100000;i++) {
			func.accept(null);
		}
		System.out.println("10万回した結果:" + end() / 1000 + "マイクロ秒");
	}
}
