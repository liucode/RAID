//mirroring
public  class Raid1 extends Raid{
	public Raid1(int disknum,int[] disksize)
	{
		super(disknum, disksize);
		System.out.println("this is raid0 create!");
	}
	public void SequenceRaidwrite(String input)
	{
		input = Tools.StrToBinstr(input);
		for(int i=0;i<disknum;i++)
		{
			new SequenceStorage(disklist.get(i)).sequencewrite(input);
		}
	}
	public void SequenceRaidread()//read data
	{
		String result = new SequenceStorage(disklist.get(0)).sequenceread();
		result = Tools.BinstrToStr(result);
		System.out.println(result);
	}
	
	public void RandomRaidread(long seed)
	{	
		String result = new RandomStorage(disklist.get(0)).randomread(seed);
		result = Tools.BinstrToStr(result);
		System.out.println(result);
	}
	
	public void RandomRaidwrite(String input,long seed)
	{
		input = Tools.StrToBinstr(input);
		for(int i=0;i<disknum;i++)
		{
			new RandomStorage(disklist.get(i)).randomwrite(input,seed);
		}
	}
	
	public void fixRaid()
	{
		Disk predisk = disklist.get(0);
		Disk newdisk = new Disk(predisk.size);
		newdisk.setDescription("I am fixed disk!");
		newdisk.data = predisk.data;
		addDisk(newdisk);
		System.out.println("Raid0 fix success!");
	}
}
