package com.hlm520.demo;
import com.hlm520.data.file.FilePlay;
import com.hlm520.data.file.Index;
import com.hlm520.data.file.StoreGain;

/**
 * 这个文件演示如何正确使用该项目的FilePlay对象
 * 此为标准用法
 * 如果您研究项目源码，会发现还有其它方法来创建此对象
 * 请遵循该规范避免后续数据操作错误
 */
public class Standard {

  FilePlay ff = new FilePlay ( );//创建FileFactory对象
  
  /** 
   * 初始化数据操作对象
   *
   * 1.setGoal(Index i) 
   * 因为我是在开发手机App上使用，所以传入Index.SD
   * 如果您是在开发电脑应用，
   * 则传入Index.C对应C盘 ，Index.D对应D盘... 以此类推
   * 
   * 2.setPath(String path) 这里传入具体的路径及文件名。
   *   因为刚才已经指定了文件位置在SD卡上，所以不需在加"sdcard/"前缀。
   *  本例对应的文件存储路径:/sdcard/hlm520/Standard.java
   *
   */
  public void init ( ) {
    ff.setGoal ( Index.SD ).setPath ( "hlm520/Standard.java" );
    // 如果是要对同一个文件进行多次操作则使用另一种初始化方法，如下 :
    StoreGain sg = new FilePlay ( ).setGoal ( Index.SD ).setPath ( "hlm520/Standard.java" );
    //然后可以用StoreGain对象进行多种文件操作
    //其它操作看同路径下文件的示例代码
   }

 }
