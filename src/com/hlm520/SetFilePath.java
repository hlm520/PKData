package com.hlm520;

import java.io.File;

public class SetFilePath 
{

  private File mFile;
  
  private PathPrefix mPathPrefix = new PathPrefix();

  private StoreOrGain mSOG=new StoreOrGain();
   
  private int i;

  private String mNewPath;
  
  private void directoryManager(String path)
   {
        mFile = new File(path);
        if(!mFile.exists())
         {
          int length=path.length();
          for(int i=length-1;i<length;i=this.i)
           {
            if(path.substring(i-1,length-1).equals("."))
             {
              for(int b=i;b<i+1;b--)
               {
                if(path.substring(i,i+1).equals("/"))
                 {
                  mNewPath=path.substring(0,i+1);
                  length--;
                  b=i+1;
                  System.out.println(mNewPath);
                 }
                i--;
                length--;
                this.i=i;
               }
             }
              else {
              length--;
              i=length-1;
              this.i=i;
             }
           }
          (new File(mNewPath)).mkdirs();
         }
      else {
        mNewPath=path;
      }
   }
  
  private Index index;
  
  private String path ="";

  private String pathManager(String path) {
	
	  this.path = mPathPrefix.setPrefix(index) + path;
	  directoryManager(this.path);
	  return this.path;
  }
  
  protected void setIndex(Index index) {
	  this.index = index;
  }
  
  public StoreOrGain setPath(String path) {
	   pathManager(path);
	   mSOG.setFile(mFile);
	   return mSOG;
  }
}
