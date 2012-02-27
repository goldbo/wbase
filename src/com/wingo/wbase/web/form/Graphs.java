package com.wingo.wbase.web.form;

import java.util.List;

public class Graphs {
	private String title;//折线标题
	private List graphValues;//折点的值集合
	public List getGraphValues() {
		return graphValues;
	}
	public void setGraphValues(List graphValues) {
		this.graphValues = graphValues;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
