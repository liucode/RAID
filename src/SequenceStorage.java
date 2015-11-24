import java.util.*;
public class SequenceStorage {
	Storage storage;
	public SequenceStorage(Storage storage)
	{
		if(storage.state == true)
		{
			System.out.println("No data,want to write!");
		}
		this.storage = storage;
	}
	
	
	public String sequenceread()//read all
	{
		System.out.println("start sequence read!");
		String result="";
		for(int i=0;i<storage.size;i++)
		{
			if(storage.data.get(i)=="-1")
				break;
			result +=storage.data.get(i)+"";
		}
		System.out.println("sequence read stop!");
		return result;
	}
	
	
	public void sequencewrite(String input)//input is the string
	{
		int len = input.length();//real write
		if(input.length()+storage.realsize>storage.size)//not enough
		{
			System.out.println("disk not enough!");
			len = storage.size-storage.realsize;
		}
		System.out.println("start sequence wirte!");
		for(int i=0;i<len;i++)
		{
			storage.data.set(i+storage.realsize,(String)(input.charAt(i)+""));//char can not add Arraylist,so char to string
		}
		storage.realsize += len;
		storage.state = false;
		System.out.println("sequence wirte stop!");
	}
	
	public String sequenceByteread(int point)// read one word in point
	{
		return (String) storage.data.get(point);
	}
	
	
}
