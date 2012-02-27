package com.wingo.wbase.vo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;


public class JxlsTest {

	
	@SuppressWarnings("unchecked")
	public static void main(String args[]){
		List goodsList = new ArrayList();
		for(int i = 0; i < 500; i ++){
			goodsList.add(new Goods("商品"+i, i));
		}
     
        Map beans = new HashMap();
        beans.put("goods", goodsList);

        XLSTransformer transformer = new XLSTransformer();
        String templateFileName="D:\\templateFile.xls";
        String destFileName="d:\\goods.xls";
        try {
			transformer.transformXLS(templateFileName, beans, destFileName);
		} catch (ParsePropertyException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
