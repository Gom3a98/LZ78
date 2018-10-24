package Compression;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DeCompresser {
	public  ArrayList<Tag> tags = new ArrayList<>(); 
	
	public String text;
	public DeCompresser()
	{
		text = "";
	}
	public void setTags(ArrayList<Tag> ordered)
	{
		
		for (int i=0;i< ordered.size();i++)
		{
			tags.add(ordered.get(i));
		}
		
	}
	
	
	public void ReadTagsFromFile(String Path) throws IOException
	{

		   File file =  new File(Path); 
		    Scanner sc = new Scanner(file); 
		  String buffer ="";
		    while (sc.hasNextLine()) 
		    	buffer+=sc.nextLine();
		for (int i =0 ;i<buffer.length();)
		{
			String ind = "";
			String NextChar="";
			while (true)
			{
				if ((int)buffer.charAt(i)>=48&&(int)buffer.charAt(i)<=57)
				{
					ind+=buffer.charAt(i);
					i++;
				}
				else
				{
					NextChar+=buffer.charAt(i);
					i++;
					break;
				}
			}
			Tag t = new Tag(Integer.parseInt(ind),NextChar);
			tags.add(t);
		}

	 
	    sc.close();
	}

	
	public void DeCompressProcess(String path)
	{
		 try
		 {
		 this.ReadTagsFromFile(path);
		 }
		 catch(Exception e)
		 {
			 System.out.println("File not Found in this path");
		 }
		 
		 try
		 {
			 this.De_Compress();

		 }
		 catch(Exception e)
		 {
			 System.out.println("Error in DeCompression");
		 }
		 try
		 {

		 this.WriteTextToFile();
		 }
		 
		 catch(Exception e)
		 {
			 System.out.println("Error in writng to File");
		 }
		
	}
	public String GetText()
	{
		return text;
	}
	public void WriteTextToFile() throws IOException{
		
	    BufferedWriter writer = new BufferedWriter(new FileWriter("Original.txt"));
	    writer.write(this.text);
	    writer.close();

	}
	public  void  De_Compress()
	{
		int pointer =0 ;
		ArrayList<String> Dictionary = new ArrayList<>();
		Dictionary.add(null);

		while (pointer < tags.size())
		{
			String bufferSearch =tags.get(pointer).next;
			if (pointer ==0 && tags.get(0).index!=0)
			{
				System.out.println("Dictionary Still Empty");
				break;
			}
			else if (tags.get(pointer).index==0)
			{
				text+=bufferSearch;
				Dictionary.add(bufferSearch);

			}
			else
			{
				text+=(Dictionary.get(tags.get(pointer).index));
				text+=(tags.get(pointer).next);
			}
			pointer++;
		}
	}


}
