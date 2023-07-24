public class EliteOfficeWorker extends OfficeWorker {

	EliteOfficeWorker(String name) {
		super(name);
	}

	@Override
	public void work() {
		System.out.printf("%sは仕事がはやい！しかも正確だ。\n", this.name);
	}
}
