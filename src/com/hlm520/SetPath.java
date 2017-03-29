package com.hlm520;
import com.hlm520.ExceptionFile.FilePathError;
import java.io.File;

public class SetPath 
{

  private String mNewPath;

  private File mFile;

  StoreOrGain mSOG=new StoreOrGain();
   
  public StoreOrGain setPath(String path)throws FilePathError
  {
   if(pathMake(path))
   {
   mSOG.setFile(mFile);
   }
   else
    throw new FilePathError(getClass().getName());
   return mSOG;
  }
  
  private int l;
  private boolean pathMake(String path) 
   {
    String sureSdcard=path.substring(0,6);

    if(sureSdcard.equals("sdcard")||sureSdcard.equals("/sdcar"))
     {
      
        mFile = new File(path);
        if(!mFile.exists())
         {
          int length=path.length();
          l=length-1;
          for(int i=length-1;i<length;i=l)
           {
            System.out.println(i);
            if(path.substring(i,length).equals("."))
             {
              for(int b=i;b<i+1;b--)
               {
                if(path.substring(i,i+1).equals("/"))
                 {
                  mNewPath=path.substring(0,i+1);
                  length--;
                  b=i+1;//结束检索
                 }
                i--;
                length--;
                l=i;
               }//for 
             }//循环判断出后缀，产生没有后缀的目录路径
            else {
              length--;
              i=length-1;
              l=i;
             }//else
           }//for 检索出文件父目录路径
          (new File(mNewPath)).mkdirs();

         }//判断目录是否存在
       //判断是否为保存操作
      else {
        mNewPath=path;

       }
       return true;
     }//判断是否为SD卡存储
   
    return false;
   }//pathMake()
}
