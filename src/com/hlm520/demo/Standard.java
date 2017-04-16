package com.demo.hlm520;
import android.util.Log;
import com.hlm520.FileFactory;
import com.hlm520.StoreOrGain;
/**
 * 这个文件演示如何正确使用
 * 均为标准用法
 * 请遵循规范避免错误
 */
public class Standard {
 
  //先说FileFactory的具体使用，
  //再看如何进行代码优化 @see this.quite()
 
  FileFactory ff = new FileFactory ( );

  //写入文件
  public void store ( ) {
    /**
     * 1.setGoal(Index i) 这里传入文件目标，因为这是手机APP，所以我传入Index.SD 。
     *   如果是要存放在电脑系统上的话可以传入Index.C/Index.D/.....分别对应C盘/D盘/等等。
     * 
     * 2.setPath(String path) 这里传入具体的路径及文件名。
     *   因为刚才已经指定了文件位置在SD卡上，所以不需在加"sdcard/"前缀。
     *  本例的完整路径:/sdcard/hlm520/Standard.java
     *
     * 3.store(String con) 这里传入想要写入文件的内容。
     *   当然可以使用storeNext(String con) ，
     *   两者区别:store() 如果文件已存在，会默认删除后写入重新传入的内容，相当于更新的效果
     *          storeNext() 表明在已有文件的基础上追加传入的内容，相当于添加内容的效果
     */
    ff.setGoal ( Index.SD ).setPath ( "hlm520/Standard.java" ).store ( "hlm520" );
   }

  //提取内容
  public void gain ( ) {
    /**
     * 在这里获得文件内容，setGoal()和setPath()同上
     * 
     * gain() 文件存在则提取对应文件内容
     * 这里还可以使用gainNative() 
     * 两者区别:
     * 1.gain() 默认将提取到的内容生成一个没有分行符的字符串，也就是原文件中是分行则会去除分行符
     * 2.gainNative() 将文件内容按原来的行数分行提取，也就是保持文件内容的原格式
     * 两者使用场景:
     * 1.gain() 如果是要对提取的内容进行一些复杂操作，而且不希望存在换行符"/n"，则使用此方法
     * 2.gainNative() 如果是要将源内容原原本本的展示，则用此方法
     */
    String con=ff.setGoal ( Index.SD ).setPath ( "hlm520/Standard.java" ).gain ( );
    Log.d ( "Tag", con );
   }
   
   //重命名文件
   public void renameto(){
     //在renameto(String newName)中传入文件的新名
     ff.setGoal ( Index.SD ).setPath ( "hlm520/Standard.java" ).renameto("Standard.class");
   }
   
   //删除文件
   public boolean delete()
   {
    /**
     * 其他方法不变，直接调用delete()方法
     */
    return
      ff.setGoal ( Index.SD ).setPath ( "hlm520/Standard.java" ).delete();
   }
   
   /** 
    * 如果像上面一样想要对同一个文件多种操作
    * 则使用下面这种方式更快捷
    */
   public void quite(){
    
     StoreOrGain sog;
     sog=new FileFactory().setGoal(Index.SD).setPath("hlm520/Standard.java");
     
     //写入内容
     sog.storeNext("I am a boy");
     
     //提取内容
     sog.gainWithNative();
     
     //重命名文件
     sog.renameto("Standard.class");
     
     //删除文件
     sog.delete();
     
   }
 }
