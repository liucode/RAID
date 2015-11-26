// can better in different ways read or write
//Raid0 parallel storage
//Raid0 have a problem about RandomRaidwrite func.
public class Raid0 extends Raid{
	public Raid0(int disknum,int[] disksize)
	{
		super(disknum, disksize);
		System.out.println("this is raid1 create!");
	}
	public void SequenceRaidwrite(String input)
	{
		input = Tools.StrToBinstr(input);
		int k = lastdisk;
		for(int i=0;i<input.length();i++)
		{
			k = k%disknum;
			new SequenceStorage(disklist.get(k)).sequencewrite(input.charAt(i)+"");
			lastdisk = k+1;
			k++;
		}
	}
	public void SequenceRaidread()
	{
		int k = 0;
		String result ="";
		for(int i=0;;)
		{
			if(k>=disknum)
				i++;
			k = k%disknum;
			String tempstring = new SequenceStorage(disklist.get(k)).sequenceByteread(0,i);
			if(tempstring=="-1")//last point
				break;
			result += tempstring;
			k++;
		}
		result = Tools.BinstrToStr(result);
		System.out.println(result);
        
	}
	
	void RandomRaidread(long seed)
	{
		int k = 0;
		String result = "";
		for(int i=0;;)
		{
			if(k>=disknum)
				i++;
			k = k%disknum;
			String tempstring = new RandomStorage(disklist.get(k)).randomByteread(i,seed);
			if(tempstring=="-1")//last point
				break;
			result+=tempstring;
			k++;
		}
		System.out.println(Tools.BinstrToStr(result));
		
	}

	void RandomRaidwrite(String input, long seed)
	{
		input = Tools.StrToBinstr(input);
		String[] inputs;
		inputs = new String[disknum];
		for(int i=0;i<disknum;i++)//if not exist,null+"a" = "nulla"
		{
			inputs[i] ="";
		}
		int k = lastdisk;
		for(int i=0;i<input.length();i++)
		{
			k = i%disknum;
			inputs[k]=inputs[k]+input.charAt(i)+"";
			k++;
		}
		for(int i=0;i<disknum;i++)
		{
			new RandomStorage(disklist.get(i)).randomwrite(inputs[i],seed);
			lastdisk = k+1;
		}
		
	}
}
