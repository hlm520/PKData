package com.hlm.test.com.demo;
import com.hlm520.FileManager;
import com.hlm520.ExceptionFile.FilePathError;
import android.util.Log;

/**
 * 这个文件演示如何正确使用
 * 均为标准用法
 * 请遵循规范避免错误
 */
public class UseStandard
{
  //先获得实例
  private FileManager FM = new FileManager();
  //提供文件路径，也可以在参数列表中直接输入
  String mFilePath = "sacard/hlm520/demo/test.java";
  
  public void test(){
    try {
      //注意:这里不需要你去判断是否需要创建目录或自己创建目录了
      //只要路径像上面那样写，自然就会自动创建test.java文件对应的目录
      //只需要setPath("String")即可
      //目前这个项目只提供操作SD卡的文件所以路径的前缀必须是sdcard/
      //否则将抛出路径错误异常
      
      //将"我是程序员"写入路径下的文件store(String data)
      FM.setPath ( mFilePath ).store ( "我是程序员" );
      //gain()方法是提取文件内容后不进行分行，而是一长窜的字符串
      String con1 = FM.setPath(mFilePath).gain();
      //gainWithNative()方法将内容按原本的行列进行排列，也就是原始状态Native
      String con2 = FM.setPath(mFilePath).gainWithNative();
      //这里就路径下对应的文件进行删除delete()
      if(FM.setPath(mFilePath).delete())
       Log.d("UseStandard",con1+"\n"+con2);
     }
    catch (FilePathError e) {}
   }
}
