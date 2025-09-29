package shahtest;

public class ChildClassDemo extends ParentClassDemo {
	
	public void engine()
	{
		System.out.println("Engine code is implemented");
	}
	
	public void color()
	{
		System.out.println(color);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChildClassDemo cd = new ChildClassDemo();
		cd.color();
		cd .brakes();

	}

}
