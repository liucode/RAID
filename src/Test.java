
public class Test {
	public static void main(String[ ] arg)
	{
		
		Disk disk = new Disk(60);
		
		/*
		SequenceStorage sq= new SequenceStorage(disk);
		sq.sequencewrite("1we");//the same seed ,the same value
		String temp = sq.sequenceread();
		*/
		/*
		RandomStorage sq= new RandomStorage(disk);
		disk.addDisksize(10);
		sq.randomwrite("123",100);//the same seed ,the same value
		//sq.randomwrite("2w34",100);
		
		sq.randomwrite("2op34",100);
		sq.randomread(100);
		*/
		//test Raid0
		/*
		int[] sizes ={100,500};
		Raid0 raid0 =new Raid0(2,sizes);
		//raid0.listDisk();
		
		
		raid0.RandomRaidwrite("ad",100);
		raid0.readAll();
		//raid0.RandomRaidread(100);
		
		//raid0.listDisk();
		raid0.RandomRaidread(100);
		*/
		
		/*test raid1 
		int[] sizes ={20,20};
		Raid1 raid1 =new Raid1(2,sizes);
		
		
		raid1.SequenceRaidwrite("ab");//when disk is too small ,data will not wirte to disk 
		raid1.readAll();
		raid1.removeDisk(1);
		raid1.readAll();
		raid1.fixRaid();
		raid1.readAll();
		raid1.SequenceRaidread();
		*/
		
		/*
		String output=Tools.StrToBinstr("2asdoio?.1");
		System.out.println(output);
		output = Tools.BinstrToStr(output);
		System.out.println(output);
	   */
		
		
		//raid5
		
		int[] sizes ={20,20,20};
		Raid5 raid5 =new Raid5(3,sizes);
		
		

		raid5.SequenceRaidwrite("3");
		raid5.readAll();
		raid5.removeDisk(2);
		raid5.readAll();
		raid5.fixRaid(2);
		raid5.readAll();
		raid5.SequenceRaidread();	
	} 
}
