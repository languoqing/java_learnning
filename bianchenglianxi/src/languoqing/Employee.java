package languoqing;

public class Employee extends Person implements InAddMoney{

	//员工工号
	private String employeeId;
	//员工工资
	protected double wage;
	//员工工龄
	private int wokerYear;
	public Employee(String employeeId,double wage,int wokerYear) {
		// TODO Auto-generated constructor stub
		super("languoqing", "xijiang");
		this.employeeId = employeeId;
		this.wage = wage;
		this.wokerYear = wokerYear;
	}
	public double add() {
		// TODO Auto-generated method stub
		return wage*0.1;
	}
	

}
