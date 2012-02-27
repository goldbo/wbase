package com.wingo.wbase.report.pojo;

/**
 * @Title: StackedLine.java
 * @Package com.wingo.wbase.report.vo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-5-9 下午02:48:11
 * @version V1.0
 */
public class StackedLine {

	private String xaxis;// X轴

	private float columnar1;// 柱子1
	
	private float columnar2;// 柱子2
	
	private float columnar3;// 柱子3
	
	private float columnar4;// 柱子4.....

	private float line;// 折线

	public float getColumnar1() {
		return columnar1;
	}

	public void setColumnar1(float columnar1) {
		this.columnar1 = columnar1;
	}

	public float getColumnar2() {
		return columnar2;
	}

	public void setColumnar2(float columnar2) {
		this.columnar2 = columnar2;
	}

	public float getColumnar3() {
		return columnar3;
	}

	public void setColumnar3(float columnar3) {
		this.columnar3 = columnar3;
	}

	public float getColumnar4() {
		return columnar4;
	}

	public void setColumnar4(float columnar4) {
		this.columnar4 = columnar4;
	}

	public float getLine() {
		return line;
	}

	public void setLine(float line) {
		this.line = line;
	}

	public String getXaxis() {
		return xaxis;
	}

	public void setXaxis(String xaxis) {
		this.xaxis = xaxis;
	}

}
