
public  class Disk extends Storage{
    private String description;
	public Disk(int size) {
		super(size);
		
	}
	public boolean addDisksize(int addsize)//add disk size
	{
		this.size+=addsize;
		for(int i=this.size-addsize;i<this.size;i++)
		{
			this.data.add("-1");
		}
		return true;	
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    public String StrToBinstr(String input)
    { //can not ºº×Ö
        char[] strChar=input.toCharArray();
        String result="";
        for(int i=0;i<strChar.length;i++)
        {
     
            String temp = Integer.toBinaryString(strChar[i]);
            int k = 0;
            while(8-k>=temp.length())//enough 8
            {
            	k++;
            	temp = "0"+temp;
            }
            result += temp+" ";
        }
        return result;
    }
    
    public String BinstrToStr(String input)
    {
    	String output="";
        String[] inputs = input.split(" ");
        for(int i=0;i<inputs.length;i++)
        {
        	int temp = Integer.parseInt(inputs[i],2);
        	output = output+(char)temp;
        }
        return output;
    }
	

}
