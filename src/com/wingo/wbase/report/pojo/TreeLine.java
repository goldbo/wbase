package com.wingo.wbase.report.pojo;

/**
 * @Title: StackedLine.java
 * @Package com.wingo.wbase.report.vo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-5-9 下午02:48:11
 * @version V1.0
 */
public class TreeLine {

	private String xaxis;// X轴

	private float line1;// 折线1
	
	private float line2;// 折线2
	
	private float line3;// 折线3

	public float getLine1() {
		return line1;
	}

	public void setLine1(float line1) {
		this.line1 = line1;
	}

	public float getLine2() {
		return line2;
	}

	public void setLine2(float line2) {
		this.line2 = line2;
	}

	public float getLine3() {
		return line3;
	}

	public void setLine3(float line3) {
		this.line3 = line3;
	}

	public String getXaxis() {
		return xaxis;
	}

	public void setXaxis(String xaxis) {
		this.xaxis = xaxis;
	}

}
