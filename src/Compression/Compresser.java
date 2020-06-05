package Compression;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Compresser {
	private String text ;
	private ArrayList<Tag>tags ;

	
 Compresser()
	{
		text = "";
		tags =  new ArrayList<>();
	}
 Compresser(String x)
 {
	 text =x ;
	tags =  new ArrayList<>();

 }
 public void Compress() 
 {
	ArrayList<String> Dictionary = new ArrayList<>();

        
      		int pointer=0;
		
		String sympol="";
		boolean status =false; 
		Dictionary.add(null);
		while (pointer<text.length())
		{
			int endPoint =1;
			sympol="";
			
			while(true)
			{
				sympol = text.substring(pointer,pointer+endPoint);
			
				if (Dictionary.contains(sympol)&&endPoint<text.length())
					{
						endPoint++;
						continue;
					}
				else
					{
					
					if (sympol.length()<=1)
						{

					
                                        	Tag temp = new Tag(0,sympol);
                                		tags.add(temp);
                        			Dictionary.add(sympol);
							

						}
						
						else
						{
							String n="";
							n += sympol.charAt(sympol.length()-1);   // to get last char
							String t = sympol.substring(0,sympol.length()-1); // to get new string
							
							int x = Dictionary.indexOf(t);
							
							Tag temp = new Tag(x,n);
							
							tags.add(temp);
							Dictionary.add(sympol);

							
						}
						
						pointer += endPoint;
						break;

					}
				
			}
        
		}

 }
 
 public String GetTags()
 {
     String result = "";
  
	for (Tag i : tags)
        {
            
            result+="<"+String.valueOf(i.index)+","+String.valueOf(i.next)+">";
        }
        return result;
 }
 
 public void read_text_File(String path) throws IOException
 {
	    File file =  new File(path); 
	    Scanner sc = new Scanner(file); 
	  
	    while (sc.hasNextLine()) 
	    	text+=sc.nextLine();
	 
            
            text =  text.toUpperCase();
            text = text.trim();
	   
	    sc.close();
	  
 }

 public void MainProccess(String path)
 {
	 try
	 {
	 this.read_text_File(path);
	 }
	 catch(Exception e)
	 {
		 System.out.println("File not Found in this path");
	 }
	 
	 try
	 {
		 this.Compress();
	 }
	 catch(Exception e)
	 {
		 System.out.println("All of things is handled... :D");
	 }
	 try
	 {
	 this.WriteOnCompressedFile();
	 }
	 
	 catch(Exception e)
	 {
		 System.out.println("Error in writng to File");
	 }
	 
 }
 
 public void WriteOnCompressedFile()  throws IOException 
 {
		    
   BufferedWriter writer = new BufferedWriter(new FileWriter("compressed_File.txt"));
		    
		    for (Tag i : tags)
		    {
		    	writer.write(i.index+i.next);
		    }
		     
		    writer.close();
}

 public void PrintTags()
{
	for (Tag obj : tags)
	{
		obj.PrintTag();
	}
}

}