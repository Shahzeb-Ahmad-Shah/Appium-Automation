
package shahtest;
import java.util.ArrayList;

public class CoreJavaBrushUp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList
		ArrayList<String> a = new ArrayList<String>();
		a.add("Shah");
		a.add("TEO");
		System.out.println(a.get(1));
		
		String s = "Shahzeb Ahmad Shah";
		String[] splitedString = s.split("Ahmad");
		for (String st : splitedString)
		{
			System.out.println(st);
		}
		System.out.println(splitedString[1].trim());
		
		for (int i = s.length()-1; i>=0; i--)
		{
			System.out.println(s.charAt(i));
		}

	}

}
