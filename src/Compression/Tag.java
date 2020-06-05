
package Compression ;

public class Tag {

	public int index ;
	public String next;
	
	 Tag(int i , String n)
	{
		this.index=i;
		this.next=n;
				
	}
	 Tag()
	{
		this.index=0;
		this.next="";
				
	}
	public void setNext(String v)
	{
		this.next = v;
	}
	public void PrintTag()
	{
		System.out.println("<"+this.index+","+this.next+">");
	}
}