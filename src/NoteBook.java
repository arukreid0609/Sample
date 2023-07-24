
public class NoteBook extends Book {
	String content = "";

	NoteBook(int page, int price) {
		super(page, price);
	}

	public void addContent(String text) {
		this.content += text;
	}

	public void displayInfo() {
		super.displayInfo();
		System.out.println("内容:" + this.content);
	}
}
