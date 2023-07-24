package memo;

public class Hero extends Character implements Person{

	@Override
	public String toString() {
		return "Hero [name=" + name + ", hp=" + hp + "]";
	}
	
}
