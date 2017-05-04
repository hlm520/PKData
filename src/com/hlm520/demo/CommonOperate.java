package com.hlm520.demo;

import com.hlm520.data.file.FilePlay;
import com.hlm520.data.file.Index;
import com.hlm520.data.file.StoreGain;

/**
 * 一些文件的普通操作
 */
public class CommonOperate {
  StoreGain sg = 
  new FilePlay ( ).setGoal ( Index.SD )
                  .setPath ( "hlm520/CommonOperate.java" );
  
  //重命名文件
  public void renameto ( ) {
    //在renameto(String newName)中传入文件的新名
    sg.renameto ( "NewFile.Java" );
   }

  //删除文件
  public boolean delete ( ) {
    /**
     * 其他方法不变，直接调用delete()方法
     */
    return
     sg.delete ( );
   }

  /**
   * 复制文件内容于另一个文件
   * 在copy(String newPath)方法中传入新文件的路径。
   */
  public boolean copy ( ) {
    return
     sg.copy ( "hlm520/StringOperate.java" );
   }
 }
