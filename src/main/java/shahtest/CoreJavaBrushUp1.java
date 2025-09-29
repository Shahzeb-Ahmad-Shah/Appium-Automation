package shahtest;

public class CoreJavaBrushUp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 10;
		String test = "Learning Appium";
		char letter = 'r';
		double dec = 5.88;
		boolean con = true;
		
		System.out.println(num + " is integer variable");
		System.out.println(test);
		
		//Arrays -
		
		int[] arr = new int[5];
		
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 6;
		arr[3] = 9;
		arr[4] = 12;
		for(int i = 0; i<arr.length; i++)
		{
			System.out.println(arr[i]);
		}
		
		String[] name = {"Shahzeb", "Ahmad", "Shah"};
		for(String s : name)
		{
			System.out.println(s);
		}
		

	}

}
