package com.hlm520.demo;

import com.hlm520.data.file.FilePlay;
import com.hlm520.data.file.Index;
import com.hlm520.data.file.StoreGain;

/**
 * 对数据类型的数据操作
 */
public class NumberOperate {
  StoreGain sg = 
  new FilePlay ( ).setGoal ( Index.SD )
                  .setPath ( "hlm520/NumberOperate.java" );

  public void store ( ) {
    //写入数字对象的内容
    //写入整型数据1024
    sg.storeNumber ( 1024 );

    /**
     * storeNextNumber(object number)
     * 功能 : 向已存在的文件写入下一个数据
     * 这里的下一个数据应该遵循以下规则 : 
     *  1. 按照数据类型的顺序，继续存入的数据类型必须小于等于目前文件所有数据中最大类型的数据。
     *  2. 顺序参照表 : 
     *    double>float>long>int
     *  3. 也就是说如果文件中已经存在最大类型为double数据，则可以继续存入任意类型数据;
     *     如果存在最大类型为float数据，则不可以存入double类型，其余的都可以存入;
     *     如果存在最大类型为long数据，则可以继续存入long或int类型数据;
     *     如果存在最大类型为int数据，则只可以继续存入int数据。
     *  4. 这样要求的目的是确保需要提取文件中的数据时不会发生类型转化的错误。
     *  5. 当一个文件中使用了storeNextNumber时，说明此文件中已经存在多个数据，因此需要使用
     *     相应的方法来提取数据，方法如下 : 
     *      1.先确定需要提取数据的文件中数据的类型
     *      2.再按照文件中数据类型排序最大的来确定方法: 
     *        1.存在double : gainNativeDouble();
     *        2.存在float  : gainNativeFloat();
     *        3.存在long   : gainNativeLong();
     *        4.存在int    : gainNativeInt();
     *  
     *  6. 如果未使用storeNextNumber()方法则直接使用对应类型的方法提取数据 :
     *      gainInt(); gainLong(); gainDouble(); gainFloat();
     */
    //继续存入浮点型数据1.024f
    sg.storeNextNumber ( 1.024f );

    /** 通过以下数据的转化来看JVM对数据类型的排序 */
    long lon=1;
    float flo=1.0f;
    int in = 1;
    double dou=1.00;
    dou = in;
    dou = flo;
    dou = lon;//double第一
    flo = in;
    flo = lon;//float第二
    lon = in;//long第三 / int第四

   }

  public void gain ( ) {

    /**
     * 因为在上文中我们存入了一个int数据1024和float数据1.024f
     * 所以我们必须按照float的提取方法来获得数据，如下面的代码
     *
     * 如果这时候使用gainNativeInt()方法将出错，因为float数据无法转化为int数据，
     *  而int数据可以转化为float数据。
     */
    float[] data = sg.gainNativeFloat ( );//是一个float   
    for ( float data2:data ) {
      System.out.println ( data2 );
     }

   }
 }
