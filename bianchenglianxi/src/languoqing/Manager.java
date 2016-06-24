package languoqing;

public class Manager extends Employee implements InAddMoney {

	private String managerLever;
	public Manager(){
		super("321", 23, 2);
	}
	public double add() {
		// TODO Auto-generated method stub
		return wage*0.2;
	}
}
