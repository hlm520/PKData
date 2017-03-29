package com.hlm520;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class Operater        
{
 
  private String path;
  
  private File file;

  public void setFile ( File file ) {
    this.file = file;
   }

  public File getFile ( ) {
    return file;
   }

  public String getPath ( ) {
    return path;
   }
 
 public void store(String content)
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
 
 public String gain()
 {
  String content = "";
  try {
    InputStream instream = new FileInputStream(file); 
    if (instream != null) {
     
      InputStreamReader inputreader = new InputStreamReader(instream);
      BufferedReader buffreader = new BufferedReader(inputreader);
      
      String line;
      
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

       String line;

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
  
  public boolean delete()
  {
   if( file.delete())
   return true;
   else 
    return false;
  }
  
}
