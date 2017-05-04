package com.hlm520.data.file;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StoreGain {

  private File file;

  /**
   * to set a current file 
   * it will be used to operate following method
   */
  public void setFile ( File file ) {
    this.file = file;
   }
  
  /**
   * This is used to get current file 
   * Maybe not use following.
   */
  public File getFile ( ) {
    return file;
   }

  /**
   * This can get current file's path 
   */
  public String getPath ( ) {
    return file.getPath ( );
   }

  /**
   * 获取文件中数据的行数
   * It can get the datas' county in this current file.
   * @return stringCount the countes ,one row is a county.
   */
  public int getStringCount ( ) {

      gain(true); 
    
  	return stringCount;
   }

  /**
   * 这里用于获取当前文件中的数据，转化为字符串数组
   * Here is to get the current file's all strings' 
   * then let the strings transforme to array.
   */
  public String[] gainStringArray ( ) {
	  getStringArray ( );
    return dataArray;
   }

  public void storeString ( String con ) {
    store ( con );
   }

  public void storeNextString ( String con ) {
		storeNext ( con );
   }

  public void storeNumber ( Object obj ) {
    number ( obj );
   }

  public void storeNextNumber ( Object object ) {
    nextNumber ( object );
   }

  public void storeByte ( byte b ) {
    store ( String.valueOf ( b ) );
   }

  public void storeNextByte ( byte b ) {
    storeNext ( String.valueOf ( b ) );
   }

  public String gainString ( ) {
    return (String)gain ( false );
   }

  public String gainStringNative ( ) {
    return (String)gainNative ( );
   }

  public int gainInt ( ) {

    return Integer.parseInt ( (String) getNumber ( ) );

   }

  public float gainFloat ( ) {

    return Float.parseFloat ( (String) getNumber ( ) );

   }

  public double gainDouble ( ) {

    return Double.parseDouble ( (String)getNumber ( ) );

   }

  public long gainLong ( ) {

    return Long.parseLong ( (String)getNumber ( ) );

   }

  private int isAgain = 0;

  private int[] endInt;
  public int[] gainNativeInt ( ) {
	  int[] newNum = endInt;
	  if ( isAgain == 0 ) {
      getNativeNumber ( );
      int len = numbers.length;
      int [] num = new int[len];
      int count =0;
      for ( int i = 0; i < len; i++ ) {
        if ( i <= len && numbers [ i ] != null && numbers [ i ] != "" )
         num [ count ] = Integer.parseInt ( numbers [ i ] );
        count++;
       }
      newNum = new int[count];
      for ( int i = 0; i < newNum.length; i++ ) {
        newNum [ i ] = num [ i ];
       }
      endInt = newNum;
      isAgain++;
     }
    return newNum;
   }

  private long[] endLong;
  public long[] gainNativeLong ( ) {

	  long[] newNum = endLong;
    if ( isAgain == 0 ) {
	    getNativeNumber ( );
	    int len = numbers.length;
	    long [] num = new long[len];
	    int count =0;
	    isAgain++;
	    for ( int i = 0; i < len; i++ ) {

	      if ( i <= len && numbers [ i ] != null && numbers [ i ] != "" ) {
          num [ count ] = Long.parseLong ( numbers [ i ] );
          count++;
         }
	     }
	    newNum = new long[count];
	    for ( int i = 0; i < newNum.length; i++ ) {
        newNum [ i ] = num [ i ];
       }
	    endLong = newNum;
     }
    return newNum;
   }

  private double[] endDouble;
  public double[] gainNativeDouble ( ) {
    double[] newNum = endDouble;
	  if ( isAgain == 0 ) {
      getNativeNumber ( );
      int len = numbers.length;
      double [] num = new double[len];
      int count =0;
      isAgain++;
      for ( int i = 0; i < len; i++ ) {
        if ( i <= len && numbers [ i ] != null && numbers [ i ] != "" ) {
          num [ count ] = Double.parseDouble ( numbers [ i ] );
          count++;
         }
       }
      newNum = new double[count];
      for ( int i = 0; i < newNum.length; i++ ) {
				newNum [ i ] = num [ i ];
       }
      endDouble = newNum;
     }
    return newNum;
   }

  private float[] endFloat;
  public float[] gainNativeFloat ( ) {
    float[] newNum = endFloat;
	  if ( isAgain == 0 ) {
      getNativeNumber ( );
      int len = numbers.length;
      float [] num = new float[len];
      int count =0;
      isAgain++;
      for ( int i = 0; i < len; i++ ) {
        if ( i <= len && numbers [ i ] != null && numbers [ i ] != "" ) {
          num [ count ] = Float.parseFloat ( numbers [ i ] );
          count++;
         }
       }
      newNum = new float[count];
      for ( int i = 0; i < newNum.length; i++ ) {
        newNum [ i ] = num [ i ];
       }
      endFloat = newNum;
     }
    return newNum;
   }

  public boolean copy ( String newpath ) {

    FilePlay ff = new FilePlay ( );
    ff.setGoal ( getGoal ( ) ).setPath ( newpath ).store ( (String)gainNative ( ) );
    return true;
   }

  public boolean renameto ( String newname ) {
    return rename ( newname );
   }

  public boolean delete ( ) {
    if ( file.exists ( ) ) {
      file.delete ( );
      return true;
     }
    return false;
   }
  private String[] dataArray;

  private void getStringArray ( ) {

    gain ( false );
    try {
      InputStream instream = new FileInputStream ( file ); 
      if ( instream != null ) {

        dataArray = new String[getStringCount ( )/3];
        int i = 0;
        InputStreamReader inputreader = new InputStreamReader ( instream );
        BufferedReader buffreader = new BufferedReader ( inputreader );

        String line="";

        while ( ( line = buffreader.readLine ( ) ) != null ) {
          dataArray [ i ] = line;
          i ++;
         }
        instream.close ( );
        buffreader.close ( );
       }
     }
    catch (java.io.FileNotFoundException e)   {    } 
    catch (IOException e)   {    }
   }

  private Object[] getNativeNumber ( ) {
    Object [] num = null ;
    gain ( true );

    int len = numbers.length;
    num = new Object[len];

    if ( len != 0 )
     for ( int l =0;l < len; l++ ) {
       if ( l < len )
        num [ l ] = numbers [ l ];
      }
    return num;
   }

  private Object getNumber ( ) {
		return gain ( false );
   }

  private void store ( String content ) {
    storeFile ( content );
   }
  private void storeNext ( String content ) {
    String oldcon = (String)gainNative ( );
    storeFile ( ( oldcon ) + content );
   }

  private FileWriter fw = null;
  private BufferedWriter bw = null;
  private void storeFile ( String content ) {
    try {
      if ( !file.exists ( ) ) {  
        file.createNewFile ( );
       }
     }
    catch (IOException e) {}

    try {

      fw = new FileWriter ( file );
      bw = new BufferedWriter ( fw );

      bw.write ( content ); 
      bw.flush ( ); 
      bw.close ( );
      fw.close ( );

     }
    catch (IOException e) {
      e.printStackTrace ( );
      try {
        bw.close ( );
        fw.close ( );
       }
      catch (IOException e1) {    }
     }
   }

  private String[] numbers = null;
  private int numberCount = 0;
  private int stringCount = 0;
  private InputStream instream = null;;
  private InputStreamReader inputreader = null;
  private BufferedReader buffreader = null;
  private Object gain ( boolean isNumber ) {
    String content = "";
    try {
      instream = new FileInputStream ( file ); 
      if ( instream != null ) {
        inputreader = new InputStreamReader ( instream );
        buffreader = new BufferedReader ( inputreader );

        String line="";
        if ( !isNumber ) {
          while ( ( line = buffreader.readLine ( ) ) != null ) {
            content += line;
            stringCount ++;
           }
         }
        else {
          while ( ( line = buffreader.readLine ( ) ) != null ) {
            numberCount ++;
            stringCount++;
           }

          numbers = new String[numberCount];
          numberCount = 0;

          instream = new FileInputStream ( file );
          inputreader = new InputStreamReader ( instream );
          buffreader = new BufferedReader ( inputreader );

          while ( ( line = buffreader.readLine ( ) ) != null ) {
            numbers [ numberCount ] = line;
            numberCount++;
            
           }
         }              

        instream.close ( );
        buffreader.close ( );

        inputreader = null;
//        instream=null;
        buffreader = null;
       }
     }
    catch (java.io.FileNotFoundException e)   {    } 
    catch (IOException e)   {    }

    return content;
   }

  private Object gainNative ( ) {
    String content = "";
    try {
      InputStream instream = new FileInputStream ( file ); 
      if ( instream != null ) {
        InputStreamReader inputreader = new InputStreamReader ( instream );
        BufferedReader buffreader = new BufferedReader ( inputreader );

        String line="";
        while ( ( line = buffreader.readLine ( ) ) != null ) {
          content += line + "\n";
          
         }               
        instream.close ( );
        inputreader.close ( );
        buffreader.close ( );
       }
     }
    catch (java.io.FileNotFoundException e)   {    } 
    catch (IOException e)   {    }

    return ( content );
   }

  private void number ( Object obj ) {
    if ( obj instanceof Integer ) {
			store ( String.valueOf ( (int)obj ) );
     }
    else if ( obj instanceof Float ) {
			store ( String.valueOf ( (float)obj ) );
     }
    else if ( obj instanceof Double ) {
			store ( String.valueOf ( (double)obj ) );
     }
    else if ( obj instanceof Long ) {
			store ( String.valueOf ( (long)obj ) );
     }
   }

  private void nextNumber ( Object obj ) {
    if ( obj instanceof Integer ) {
      storeNext ( String.valueOf ( (int)obj ) );
     }
    else if ( obj instanceof Float ) {
      storeNext ( String.valueOf ( (float)obj ) );
     }
    else if ( obj instanceof Double ) {
      storeNext ( String.valueOf ( (double)obj ) );
     }
    else if ( obj instanceof Long ) {
      storeNext ( String.valueOf ( (long)obj ) );
     }
   }

  private boolean rename ( String newname ) {
    boolean isRename=false;
    String oldpath = file.getPath ( );
    String mNewPath = null;
    int length = oldpath.length ( );
    int i = length ;

    for ( int i1=length - 1;i1 < length;i1 = i ) {
      if ( oldpath.substring ( i1, length ).equals ( "." ) ) {
        for ( int b=i1;b < i1 + 1;b-- ) {
          if ( oldpath.substring ( i1, i1 + 1 ).equals ( "/" ) ) {
            mNewPath = oldpath.substring ( 0, i1 + 1 );
            length--;
            b = i1 + 1;//锟斤拷循锟斤拷停止
            file.renameTo ( new File ( mNewPath + "/" + newname ) );
            isRename = true;
           }
          i1--;
          length--;
          i = i1;
         }//for 
       }
      else {
        length--;
        i1 = length - 1;//锟斤拷锟斤拷指锟斤拷i1锟斤拷值锟斤拷只要锟斤拷锟斤拷锟斤拷"."锟斤拷锟斤拷么锟斤拷锟斤拷锟街ぱ拷锟斤拷锟斤拷约锟斤拷锟�
        i = i1;//锟斤拷i=i1锟斤拷使锟斤拷锟斤拷循锟斤拷锟斤拷锟绞憋拷锟絠1锟斤拷锟皆憋拷乇锟絣ength小1锟斤拷值
       }
     }
    return isRename;
   }

  private Index getGoal ( ) {
    String path = file.getPath ( );
    for ( int i = 0; i < path.length ( ); i++ ) {
      if ( path.substring ( i, i + 1 ).equals ( "/" ) ) {
        String goal = path.substring ( 0, i );
        if ( goal.equals ( "sdcard" ) ) {
          return Index.SD;
         }
        else if ( goal.equals ( "C://" ) ) {
          return Index.COM_C;
         }
        else if ( goal.equals ( "D://" ) ) {
          return Index.COM_D;
         }
        else if ( goal.equals ( "E://" ) ) {
          return Index.COM_E;
         }
        else if ( goal.equals ( "F://" ) ) {
          return Index.COM_F;
         }
        else if ( goal.equals ( "G://" ) ) {
          return Index.COM_G;
         }
        else if ( goal.equals ( "H://" ) ) {
          return Index.COM_H;
         }
        else if ( goal.equals ( "I://" ) ) {
          return Index.COM_I;
         }
        else if ( goal.equals ( "J://" ) ) {
          return Index.COM_J;
         }
        else if ( goal.equals ( "K://" ) ) {
          return Index.COM_K;
         }
        else if ( goal.equals ( "L://" ) ) {
          return Index.COM_L;
         }
        else if ( goal.equals ( "M://" ) ) {
          return Index.COM_M;
         }
        else if ( goal.equals ( "N://" ) ) {
          return Index.COM_N;
         }
        else if ( goal.equals ( "O://" ) ) {
          return Index.COM_O;
         }
       }

     }
    return null;
   }

 }
