
public class MathEx {

	public static void main(String[] args) {
		int x1 = 5;
		int y1 = 4;
		
		int x2 = 1;
		int y2 = 1;
		
		double length = Math.pow((x1-x2), 2) + Math.pow((y1 - y2),2);
		length = Math.sqrt(length);
		System.out.println(length);
		int x = 10;
		int y = 10;
		for(int i = 0;i < y;i++) {
			for(int j =0;j < x;j++) {
				boolean isXY1 = i == y1 && j== x1;
				boolean isXY2 = i == y2 && j== x2;
				if(isXY1) {
					System.out.print("〇 ");
				}else if(isXY2) {
					System.out.print("× ");
				}else {
					System.out.print("■ ");
				}
			}
			System.out.println();
		}

	}

}
