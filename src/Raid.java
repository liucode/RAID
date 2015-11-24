import java.util.ArrayList;


public abstract class Raid {
	 protected ArrayList <Disk> disklist = new ArrayList<Disk>();
	 private String description;
	 protected int disknum=0;
	 public boolean addDisk(Disk disk)
	 {
		 disklist.add(disk);
		 disknum++;
		 return true;
	 }
	 
	 public boolean init(int disknum,int[] disksize)//disksize array is every disk'size
	 {
		 int i;
		 for(i =0;i<disknum;i++)
		 {
			 Disk temp = new Disk(disksize[i]);
			 temp.setDescription("I am NO "+i+" disk.");
			 if(!addDisk(temp))
				 return false;
		 }
		 for(i=0;i<disklist.size();i++)
		 {
			 if(!disklist.get(i).clear())//clear disk error
				 return false;
		 }
		 return true;	 
	 }
	 
	public Raid(int disknum,int[] disksize)
	{
		if(disknum != disksize.length)
		{
			System.out.println("raid disk num is error");
		}
		init(disknum,disksize);
	}
	
	public void removeDisk(int targetdisknum)
	{
		if(targetdisknum>disknum)
		{
			System.out.println("remove disk does not exist");
			return ;
		}
		disklist.remove(targetdisknum);
		System.out.println("you remove 1 disk!");
		disknum--;
	}
	
	public void listDisk()
	{
		System.out.println("We have "+disknum+" disks");
		for(int i=0;i<disknum;i++)
		{
			System.out.println(disklist.get(i).getDescription());
		}
	}
	
	public void readAll()//read all disk include -1
	{
		for(int i=0;i<disknum;i++)
		{
			String result ="";
			System.out.println("NO "+i);
			for(int j=0;j<disklist.get(i).size;j++)
			{
				result +=disklist.get(i).data.get(j)+"";
			}
			System.out.println(result);
		}
	}
	abstract void SequenceRaidwrite(String input);
	abstract void SequenceRaidread();//read data
	abstract void RandomRaidread(long seed);
	abstract void RandomRaidwrite(String input,long seed);
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	 
	 
}
