package Compression;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
	public String GetText()
	{
		return text;
	}
	public void WriteTextToFile() throws IOException{
		
	    BufferedWriter writer = new BufferedWriter(new FileWriter("Original.txt"));
	    writer.write(GetText());

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
