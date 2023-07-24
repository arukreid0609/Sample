public class LazyOfficeWorker extends OfficeWorker {
	LazyOfficeWorker(String name) {
		super(name);
	}

	@Override
	public void work() {
		System.out.printf("%sはPCの画面を即座に切り替えた。何をしていたのだろう。\n", this.name);
	}
}
