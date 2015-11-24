import java.util.*;
public  class Storage {
       public int size;//size of Storage
       public int realsize;//have data len
       public ArrayList data = new ArrayList();//data region
       public boolean state;//ÊÇ·ñ±»Çå¿Õ
       private void init()//before create 
       {
    	   for(int i = 0;i<size;i++)
    	   {
    		   data.add("-1");//change the global value 
    	   }
    	   realsize = 0;
    	   state = true;
       }
       public boolean clear()//clear all data
       {
    	   for(int i = 0;i<size;i++)
    	   {
    		   data.add("-1");
    	   }
    	   state = true;
    	   realsize = 0;
    	   return true;
       }
       public Storage(int size)
       {
    	   this.size = size;
    	   init();
    	   
       }
}
