package com.wingo.wbase.report.pojo;
/**   
 * @Title: StackedLine.java 
 * @Package com.wingo.wbase.report.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author  CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.  
 * @date 2011-5-9 下午02:48:11 
 * @version V1.0   
 */
public class ClusteredLine {
	
	private String xaxis;//X轴
	
	private float columnar;//柱子
	
	private float line;//折线

	public String getXaxis() {
		return xaxis;
	}

	public void setXaxis(String xaxis) {
		this.xaxis = xaxis;
	}

	public float getColumnar() {
		return columnar;
	}

	public void setColumnar(float columnar) {
		this.columnar = columnar;
	}

	public float getLine() {
		return line;
	}

	public void setLine(float line) {
		this.line = line;
	}
	
}
