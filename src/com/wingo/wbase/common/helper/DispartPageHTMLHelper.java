package com.wingo.wbase.common.helper;

import com.wingo.wbase.common.vo.page.Pager;

public class DispartPageHTMLHelper {

	// 修改前 这个很好，不过要统一只好改了 aly
	/*
	 * public static StringBuffer getDispartPageHTML(Pager pager,String formId ) {
	 * StringBuffer buf=new StringBuffer(); buf.append("<table border='0'
	 * >\n"); buf.append("<tr  class='ListTableRow' >\n"); buf.append("<td colspan='1' >\n");
	 * //第一页按钮 String disabled="";
	 * if(pager.getTotalPages()==1||pager.getCurrentPage()==1) disabled="
	 * disabled='true'"; buf.append("<input type='button' name='Submit'
	 * value='第一页'"+disabled+" class='Button3'
	 * onClick=\"goDispartPage('first',"+pager.getCurrentPage()+",'"+formId+"')\">\n");
	 * 
	 * //上一页按钮 disabled=" disabled='true' ";
	 * if(pager.getTotalPages()>1&&pager.getCurrentPage()!=1) disabled="";
	 * buf.append("<input type='button' name='Submit' value='上一页'"+disabled+"
	 * class='Button3'
	 * onClick=\"goDispartPage('previous',"+pager.getCurrentPage()+",'"+formId+"')\">\n");
	 * 
	 * //下一页按钮 disabled=" disabled='true'"; if(pager.getCurrentPage()<pager.getTotalPages())
	 * disabled=""; buf.append("<input type='button' name='Submit' value='下一页'"
	 * +disabled+" class='Button3'
	 * onClick=\"goDispartPage('next',"+pager.getCurrentPage()+",'"+formId+"')\">\n");
	 * 
	 * //最后一页按钮 disabled=" disabled='true'";
	 * if(pager.getCurrentPage()!=pager.getTotalPages()&&pager.getTotalPages()>1)
	 * disabled=""; buf.append("<input type='button' name='Submit'
	 * value='最后一页'" +disabled+ " class='Button3'
	 * onClick=\"goDispartPage('last',"+pager.getCurrentPage()+",'"+formId+"')\">\n");
	 * 
	 * //显示页码 buf.append("共<font color='#0000FF'>"+pager.getTotalRows()+"</font>条记录，每页<font
	 * color='#0000FF'> <select name='pageSize' id='pageSize'
	 * onchange=\"onDispartPageChange('"+formId+"')\"><option>"+pager.getPageSize()+"</option>");
	 * String pageSizes = ConfigInfoVO.getProperty("PAGE_SIZES"); String []
	 * pageSizeSel = pageSizes.split("\\,"); for(int i=0;i<pageSizeSel.length;i++){
	 * if(pager.getPageSize()!=Integer.parseInt(pageSizeSel[i])) { buf.append("<option
	 * value='"+pageSizeSel[i]+"'>"+pageSizeSel[i]+"</option>"); }
	 *  }
	 * 
	 * buf.append("</select></font>条，分为<font
	 * color='#0000FF'>"+pager.getTotalPages()+"</font>页，到");
	 * 
	 * //显示本页的小文本框 disabled=" disabled='true'";
	 * if(pager.getTotalPages()!=1&&pager.getTotalPages()!=0) disabled="";
	 * buf.append("<input type='text' name='currentPage' "+disabled+" size='4'
	 * id='currentPage' value='"+pager.getCurrentPage()+"'
	 * class='formStyleall'>页\n");
	 * 
	 * //显示跳转按钮 disabled=" disabled='true'";
	 * if(pager.getTotalPages()!=1&&pager.getTotalPages()!=0) disabled="";
	 * buf.append("<input type='button' name='Submit' value='跳转' "+disabled+"
	 * class='Button3'
	 * onClick=\"goDispartPage('go',"+pager.getCurrentPage()+",'"+formId+"')\">\n");
	 * buf.append("</td>\n"); buf.append("</tr>\n"); buf.append("</table>\n");
	 * 
	 * return buf; }
	 */

	public static StringBuffer getDispartPageHTML(Pager pager, String formId) {
		StringBuffer buf = new StringBuffer();
		buf.append("<table width='100%' border='0' >\n");
		buf.append("<tr>\n");
		buf.append("<td width='100%' colspan='1' >\n");
		buf.append("<div align='right'>");

		if (pager.getTotalRows() > pager.getPageSize()) {
			if (pager.getCurrentPage() > 1
					&& pager.getCurrentPage() < pager.getTotalPages()) {
				buf
						.append("共有<font color='#0000FF'>"
								+ pager.getTotalRows()
								+ "</font>条记录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
				buf.append("<a href='javascript:void(0)' onClick=\"goDispartPage('first',"
						+ pager.getCurrentPage() + ",'" + formId
						+ "');return false; \">首页</a>\n");

				// 上一页按钮
				buf.append("<a href='javascript:void(0)' onClick=\"goDispartPage('previous',"
						+ pager.getCurrentPage() + ",'" + formId
						+ "');return false; \">上页</a>\n");

				// 下一页按钮
				buf.append("<a href='javascript:void(0)' onClick=\"goDispartPage('next',"
						+ pager.getCurrentPage() + ",'" + formId
						+ "');return false; \">下页</a>\n");

				// 最后一页按钮
				buf.append("<a href='javascript:void(0)' onClick=\"goDispartPage('last',"
						+ pager.getCurrentPage() + ",'" + formId
						+ "');return false; \">尾页</a>\n");

				// 显示本页的小文本框
				buf
						.append("输入页码：<input type='text' name='currentPage' value='"
								+ pager.getCurrentPage()
								+ "' size='4' id='currentPage' >\n");

				// 显示跳转按钮
				buf.append("<a href='javascript:void(0)' onClick=\"goDispartPage('go',"
						+ pager.getCurrentPage() + ",'" + formId
						+ "');return false; \">跳转</a>\n");
				buf.append("&nbsp;第" + pager.getCurrentPage() + "页/共"
						+ pager.getTotalPages() + "页</p>");
			} else {
				if (pager.getCurrentPage() == 1) {
					buf
							.append("共有<font color='#0000FF'>"
									+ pager.getTotalRows()
									+ "</font>条记录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					// 下一页按钮
					buf.append("<a href='javascript:void(0)' onClick=\"goDispartPage('next',"
							+ pager.getCurrentPage() + ",'" + formId
							+ "');return false; \">下页</a>\n");

					// 最后一页按钮
					buf.append("<a href='javascript:void(0)' onClick=\"goDispartPage('last',"
							+ pager.getCurrentPage() + ",'" + formId
							+ "');return false; \">尾页</a>\n");

					// 显示本页的小文本框
					buf
							.append("输入页码：<input type='text' name='currentPage' value='"
									+ pager.getCurrentPage()
									+ "' size='4' id='currentPage' >\n");

					// 显示跳转按钮
					buf.append("<a href='javascript:void(0)' onClick=\"goDispartPage('go',"
							+ pager.getCurrentPage() + ",'" + formId
							+ "');return false; \">跳转</a>\n");
					buf.append("&nbsp;第" + pager.getCurrentPage() + "页/共"
							+ pager.getTotalPages() + "页</p>");
				}
				if (pager.getCurrentPage() == pager.getTotalPages()) {
					buf
							.append("共有<font color='#0000FF'>"
									+ pager.getTotalRows()
									+ "</font>条记录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					buf.append("<a href='javascript:void(0)' onClick=\"goDispartPage('first',"
							+ pager.getCurrentPage() + ",'" + formId
							+ "');return false; \">首页</a>\n");

					// 上一页按钮
					buf
							.append("<a href='javascript:void(0)' onClick=\"goDispartPage('previous',"
									+ pager.getCurrentPage()
									+ ",'"
									+ formId
									+ "');return false; \">上页</a>\n");

					// 显示本页的小文本框
					buf
							.append("输入页码：<input type='text' name='currentPage' value='"
									+ pager.getCurrentPage()
									+ "' size='4' id='currentPage' >\n");

					// 显示跳转按钮
					buf.append("<a href='javascript:void(0)' onClick=\"goDispartPage('go',"
							+ pager.getCurrentPage() + ",'" + formId
							+ "');return false; \">跳转</a>\n");
					buf.append("&nbsp;第" + pager.getCurrentPage() + "页/共"
							+ pager.getTotalPages() + "页</p>");

				}
			}
		} else {
			// pager.setCurrentPage(1);
		}
		buf.append("</div>\n");
		buf.append("</td>\n");
		buf.append("</tr>\n");
		buf.append("</table>\n");
		// System.out.println(buf.toString());
		return buf;
	}
}
