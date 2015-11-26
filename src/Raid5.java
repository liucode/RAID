import java.util.ArrayList;


public class Raid5 extends Raid {	
	public ArrayList <Integer> offset = new ArrayList();//record point to read
	public Raid5(int disknum, int[] disksize) {
		super(disknum, disksize);
	}

	void SequenceRaidwrite(String input) {
		input = Tools.StrToBinstr(input);
		int key = 0;//input point
		int flog = 0;//it is flog that  xor insert point
		String result = "";
		int point = 0;
		
		while(new SequenceStorage(disklist.get(0)).sequenceByteread(0,point)!="-1")
		{
			point++;
		}
		offset.add(point);
		while(true)
		{
			int xor = 1;//test value
			int value = 1;
			for(int i=0;i<disknum-1;i++)//group
			{
				value = Integer.parseInt(input.charAt(key+i)+"",10);
				xor = xor^value;
			}
			flog = flog%disknum;
			//insert data
			int distance;
			if(key+disknum>=input.length())
			{
				distance = input.length();
			}
			else
			{
				distance = key+disknum-1;
			}
			StringBuilder sbtemp=new StringBuilder(input.subSequence(key,distance));
			sbtemp.insert(flog,xor+"");
			result += sbtemp;
			key +=disknum-1;
			if(key>=input.length()-1)
				break;
			flog++;
		}
		int k = 0;
		for(int i=0;i<result.length();i++)
		{
			k = k%disknum;
			new SequenceStorage(disklist.get(k)).sequencewrite(result.charAt(i)+"");
			k++;
		}
		while(k<disknum)
		{
			disklist.get(k).realsize++;
			k++;
		}
		
	}
	void SequenceRaidread()
	{
		for(int i=0;i<offset.size();i++)
		{
			SequenceoffsetRaidread(offset.get(i));
		}
	}

	void SequenceoffsetRaidread(int offsetpoint) {
		int k = 0;//same raid0
		String result ="";
		for(int i=0;;)
		{
			if(k>=disknum)
				i++;
			k = k%disknum;
			String tempstring = new SequenceStorage(disklist.get(k)).sequenceByteread(offsetpoint,i);
			if(tempstring=="-1")//last point
				break;
			result += tempstring;
			k++;
		}
		
		int flog = 0;
		int key = 0;
		String output = "";
		while(true)
		{
			flog%=disknum;
			for(int i=0;i<disknum;i++)
			{
				if(key+i>=result.length())
					break;
				if(flog !=i)
				{
					output +=result.charAt(key+i);
				}
			}
			key+=disknum;
			flog++;
			if(key>=result.length())
				break;
		}
		output = Tools.BinstrToStr(output);
		System.out.println(output);
	}

	void fixRaid(int fixdisknum)
	{
		int xor = 1;
		Disk newdisk = new Disk(disklist.get(0).size);
		String result = "";
		for(int i=0;i<disklist.get(0).realsize;i++)
		{
			xor = 1;
			for(int j=0;j<disknum;j++)
			{
				int value = Integer.parseInt(new SequenceStorage(disklist.get(j)).sequenceByteread(0,i));
				if (value == -1)
				{
					value = 1;
				}
				xor = xor^value;
			}
			result += xor+"";
		}
		new SequenceStorage(newdisk).sequencewrite(result);
		disklist.add(fixdisknum,newdisk);
		disknum++;
	}
	
	void RandomRaidread(long seed) {
		
		
	}

	void RandomRaidwrite(String input, long seed) {
		
	}
	

}
