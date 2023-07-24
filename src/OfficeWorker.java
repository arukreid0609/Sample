public abstract class OfficeWorker {
	String name;

	OfficeWorker(String name) {
		this.name = name;
	}

	public void introduce() {
		System.out.printf("はじめまして。私は%sです。\n", this.name);
	}

	public abstract void work();
}
