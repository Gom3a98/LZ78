
package Compression ;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {


		Scanner Get= new Scanner (System.in);
		System.out.print("Enter the path : ");
		String path = Get.next();
		Compresser obj = new Compresser();
		obj.MainProccess(path);
		
		/*
		ArrayList<Tag>myTags= new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			int p =Get.nextInt();
			String x =Get.next();
			Tag t = new Tag(p,x);
			myTags.add(t);
		}
		
		DeCompresser obj = new DeCompresser();
		obj.setTags(myTags);
		obj.De_Compress();
		System.out.println(obj.GetText());
		*/

	}


}