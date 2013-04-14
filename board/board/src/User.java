public class User {
	private String name;
	private double attack;
	private double defence;
	private double health;
	
	public User(String name) 
	{
		super();
		this.name = name;
		this.attack = 20;
		this.defence = 20;
		this.health = 100;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAttack() {
		return attack;
	}

	public void setAttack(double attack) {
		this.attack = attack;
	}

	public double getDefence() {
		return defence;
	}

	public void setDefence(double defence) {
		this.defence = defence;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}
}