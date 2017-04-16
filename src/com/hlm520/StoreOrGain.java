package com.hlm520;


import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class StoreOrGain        
{
 
  private File file;

  public void setFile ( File file ) {
    this.file = file;
   }

  public File getFile ( ) {
    return file;
   }

  public String getPath ( ) {
    return file.getPath();
   }
 
 private void storeFile(String content)
 {
  try
   {
    if(!file.exists())
     {  
      file.createNewFile( );
     }
   }
  catch (IOException e)
   {}

  FileWriter fw = null;
  BufferedWriter bw = null;
  
  try{
   
    fw = new FileWriter(file);
    bw = new BufferedWriter(fw);
    
    bw.write(content); 
    bw.flush(); 
    
    bw.close();
    fw.close();
    
   } catch (IOException e){
    e.printStackTrace();
    try {
      bw.close();
      fw.close();
     } catch (IOException e1) {    }
   }
 }
 
 public void store(String content) {
	storeFile(content);
}
 public void storeNext(String content) {
	String oldcon = gainWithNative();
	storeFile((oldcon+"\n")+content);
}
 
 public String gain()
 {
  String content = "";
  try {
    InputStream instream = new FileInputStream(file); 
    if (instream != null) {
     
      InputStreamReader inputreader = new InputStreamReader(instream);
      BufferedReader buffreader = new BufferedReader(inputreader);
      
      String line="";
      
      while (( line = buffreader.readLine()) != null) {
       
        content+=line;
        
       }               
      
      instream.close();
      
     }
   }
  catch (java.io.FileNotFoundException e)   {    } 
  
  catch (IOException e)   {    }
  
  return content;
  
 }
 
 public String gainWithNative()
  {
   String content = "";
   try {
     InputStream instream = new FileInputStream(file); 
     if (instream != null) {

       InputStreamReader inputreader = new InputStreamReader(instream);
       BufferedReader buffreader = new BufferedReader(inputreader);

       String line="";

       while (( line = buffreader.readLine()) != null) {

         content+=line+"\n";

        }               

       instream.close();

      }
    }
   catch (java.io.FileNotFoundException e)   {    } 

   catch (IOException e)   {    }

   return (content);

  }
 
 public boolean delete(){
	 if (file.exists())
	 {
		 file.delete();
		 return true;
	 }
	return false;
 }
 
 public boolean renameto(String newname){
	 boolean isRename=false;
	 
	 String oldpath = file.getPath();
	 
	 String mNewPath = null;
	 
	 int length = oldpath.length();
	 
	 int i = length ;
	 
	 for(int i1=length-1;i1<length;i1=i)
     {
      if(oldpath.substring(i1,length).equals("."))
       {
        for(int b=i1;b<i1+1;b--)
         {
          if(oldpath.substring(i1,i1+1).equals("/"))
           {
            mNewPath = oldpath.substring(0,i1+1);
            length--;
            b=i1+1;//让循环停止
            file.renameTo(new File(mNewPath+"/"+newname));
            isRename=true;
           }
          i1--;
          length--;
          i=i1;
         }//for 
       }
        else {
        length--;
        i1=length-1;//这里指定i1的值，只要不出现"."就这么操作，保证循环可以继续
        i=i1;//让i=i1，使得在循环条件时让i1可以变回比length小1的值
       }
     }
	return isRename;
  }
  
// 	public boolean name() {
//		
//	}
// 
}
