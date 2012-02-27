package com.wingo.wbase.report;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.wingo.wbase.common.module.excel.ExcelDownload;
import com.wingo.wbase.vo.Goods;

/**
 * @Title: ImageServlet.java
 * @Package com.wingo.wbase.report
 * @Description: TODO(用一句话描述该文件做什么)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-5-9 下午05:31:26
 * @version V1.0
 */
public class ImageServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8296490827479809254L;

	protected Logger logger = Logger.getLogger(getClass());
	
	public ImageServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		doService(arg0, arg1);
	}

	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		doService(arg0, arg1);
	}

	public void init() throws ServletException {
		// Put your code here
	}

	private void doService(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String chartName = request.getParameter("chartName");
		// 写入到Excel格式输出流供下载
		try {

			// 调用自编的下载类，实现Excel文件的下载
			ExcelDownload downLoad = new ExcelDownload();
			BufferedImage bufferedImage = ImageIO.read(request.getInputStream());
			HSSFWorkbook workbook = this.getInitWorkbook(bufferedImage);
			// 不生成文件，直接生成文件输出流供下载
			downLoad.downLoad(chartName+".xls",workbook, response);
			//生成文件
//			downLoad.downLoad(filePath,"BidCost.xls", response);
			
//			String webroot = System.getProperty("webapp.root");
//			String templateFilePath = webroot+"platform/report/templateFile.xls";
//			List goodsList = new ArrayList();
//			for(int i = 0; i < 500; i ++){
//				goodsList.add(new Goods("商品"+i, i));
//			}
//	     
//	        Map beans = new HashMap();
//	        beans.put("goods", goodsList);
//			downLoad.downLoad(templateFilePath, "testExcelTransformer.xls", beans, response);

		} catch (Exception e) {
			// 文件下载失败!
			e.printStackTrace();
			logger.info(" create Excel outputStream  failed! ");
			logger.info(e.getMessage());
			// e.printStackTrace();
		}

	}

	// private void printImage(HttpServletRequest request,
	// HttpServletResponse response) throws IOException {
	// response.setContentType("image/jpeg");
	// response.setHeader("Content-Length:", String.valueOf(request
	// .getInputStream().available()));
	//
	// ServletOutputStream sos = response.getOutputStream();
	// IOUtils.copy(request.getInputStream(), sos);
	// sos.flush();
	// sos.close();
	// }
	/**
	 * 取得填充了数据的工作簿
	 * 
	 * @param excel
	 *            ExcelModel Excel表的模型对象
	 * @return HSSFWorkbook 工作簿对象
	 */
	private HSSFWorkbook getInitWorkbook(BufferedImage bufferedImage) {

		// 创建新的Excel 工作簿
		HSSFWorkbook wb = new HSSFWorkbook();

        //设置表头字体
        HSSFFont font_h = wb.createFont();
        font_h.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        //设置格式
        HSSFCellStyle cellStyle= wb.createCellStyle();
        cellStyle.setFont(font_h);        
		try {
			// 先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray
			// 读入图片1
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "jpg", byteArrayOut);

			// 创建一个工作薄
			
			HSSFSheet sheet1 = wb.createSheet("报表");
			HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();
			HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 255, 255,
					(short) 1, 1, (short) 5, 5);
			anchor.setAnchorType(3);
			// 插入图片1
			patriarch.createPicture(
					anchor,
					wb.addPicture(byteArrayOut.toByteArray(),
							HSSFWorkbook.PICTURE_TYPE_JPEG)).resize();
		} catch (IOException io) {
			io.printStackTrace();
			System.out.println("erorr : " + io.getMessage());
		}
		return wb;

	}

}
