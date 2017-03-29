package com.hlm520.ExceptionFile;
import android.util.Log;
import java.io.IOException;

public class FilePathError extends IOException
{
 
 public FilePathError(){}
 public FilePathError(String TAG)
 {
  super();
  
  Log.e("NotSdcard","The file is not found !"+"\n"
               +"at "+TAG+"\n"
        +"at Because the file is not a sdcard's file");
  
 }
}
