package com.hlm520;

import com.hlm520.ExceptionFile.FilePathError ;
class PathPrefix  {

	
	@SuppressWarnings("unused")
	private final int DEFAULT_PATH_INDEX = 10;
	
	private String mPathPrefix;
	
	private Index index;
	
	private String pathDefinite(Index index2) {
		
		this.index = index2;
		
		try {
		
		if (index == Index.SD) {
			mPathPrefix = "sdcard/";
		}else if (index == Index.COM_C) {
			mPathPrefix = "C://";
		}else if (index == Index.COM_D) {
			mPathPrefix = "D://";
		}else if (index == Index.COM_E) {
			mPathPrefix = "E://";
		}else if (index == Index.COM_F) {
			mPathPrefix = "F://";
		}else if (index == Index.COM_G) {
			mPathPrefix = "G://";
		}else if (index == Index.COM_H) {
			mPathPrefix = "H://";
		}else if (index == Index.COM_K) {
			mPathPrefix = "K://";
		}else {
				throw new FilePathError(getClass().getName());
		}
			} catch (FilePathError e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				}
		
		return mPathPrefix;
		
	}
	
	protected String setPrefix(Index index2) {
		pathDefinite(index2);
		return mPathPrefix;
	}

}
