public class OrdinaryOfficeWorker extends OfficeWorker {

	OrdinaryOfficeWorker(String name) {
		super(name);
	}

	@Override
	public void work() {
		System.out.printf("%sは９時から５時まで働いている。遅刻や欠勤はない\n", this.name);
	}

}
