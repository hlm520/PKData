package com.hlm520.demo;
import com.hlm520.data.file.StoreGain;
import com.hlm520.data.file.FilePlay;
import com.hlm520.data.file.Index;

/**
 * 对字符串数据的操作
 */
public class StringOperate {
  StoreGain sg = 
  new FilePlay ( ).setGoal ( Index.SD )
                  .setPath ( "hlm520/StringOperate.java" );

  //写入文件
  public void store ( ) {
    /**
     * storeString(String con) 这里传入想要写入文件的内容。
     *   当然可以使用storeNextString(String con) ，
     *   两者区别:storeString() 如果文件已存在，会默认删除后写入重新传入的内容，相当于覆盖的效果
     *          storeNextString() 表明在已有文件的基础上追加传入的内容，相当于添加内容的效果
     */
    sg.storeString ( "hlm520" );
    sg.storeNextString ( "first" );
   }

  public void gain ( ) {
    /**
     * 在这里获得文件内容，setGoal()和setPath()同上
     * 
     * gainString() 文件存在则提取对应文件内容
     * 这里还可以使用gainStringNative() 
     * 两者区别:
     * 1.gain() 默认将提取到的内容生成一个没有分行符的字符串，也就是原文件中是分行则会去除分行符
     * 2.gainNative() 将文件内容按原来的行数分行提取，也就是保持文件内容的原格式
     * 两者使用场景:
     * 1.gain() 如果是要对提取的内容进行一些复杂操作，而且不希望存在换行符"/n"，则使用此方法
     * 2.gainNative() 如果是要将源内容原原本本的展示，则用此方法
     */
    String con=sg.gainString ( );
    System.out.println ( con );

    sg.storeNextString ( "second" );
    con = sg.gainStringNative ( );
    System.out.println ( con );

    /**
     * gainStringArray();
     *
     * 获取文件中的数据
     * 将所有数据转化为字符串数组
     */
    sg.storeNextString ( "third" );
    String[] data1 = sg.gainStringArray ( );
    for ( String data2:data1 ) {
      System.out.println ( data2 );
     }

   }

     /**
      * getStringCount();
      * 可以获取文件中数据的数量
      */
     public void count(){
      int count = sg.getStringCount();
      System.out.println( count );
     }
   
 }
