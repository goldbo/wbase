package com.wingo.wbase.report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import com.wingo.wbase.report.pojo.ClusteredLine;
import com.wingo.wbase.report.pojo.StackedLine;
import com.wingo.wbase.report.pojo.TreeLine;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerUtils {
	
	/**
	 * 累加柱状折线组合图
	 * @param list
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void StackedLineChart(List<StackedLine> list) throws IOException {
		if (list == null) {
			return;
		} else {
			Configuration freemarkerCfg = new Configuration();
			freemarkerCfg.setClassForTemplateLoading(this.getClass(), "/");
			freemarkerCfg.setEncoding(Locale.getDefault(), "UTF-8");
			Template template;
			String webroot = System.getProperty("webapp.root");
			FileOutputStream fos = null;
			OutputStreamWriter osw = null;
			Writer out = null;
			try {
				template = freemarkerCfg.getTemplate("com/wingo/wbase/report/ftl/stackedLine.ftl");
				template.setEncoding("UTF-8");
				File htmlFile = new File(webroot + "/platform/report/combination/xml_data/StackedLineData.xml");
				fos = new FileOutputStream(htmlFile);
				osw = new OutputStreamWriter(fos, "UTF-8");
				out = new BufferedWriter(osw);
				HashMap propMap = new HashMap();
				if (list.size() > 0) {
					propMap.put("nodes", list);
				} else {
					propMap.put("nodes", new ArrayList());
				}
				template.process(propMap, out);
				out.flush();
				fos.flush();
				osw.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				out.close();
				fos.close();
				osw.close();
			}
		}
	}
	
	/**
	 * 柱状折线组合图
	 * @param list
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void ClusteredLineChart(List<ClusteredLine> list) throws IOException {
		if (list == null) {
			return;
		} else {
			Configuration freemarkerCfg = new Configuration();
			freemarkerCfg.setClassForTemplateLoading(this.getClass(), "/");
			freemarkerCfg.setEncoding(Locale.getDefault(), "UTF-8");
			Template template;
			String webroot = System.getProperty("webapp.root");
			FileOutputStream fos = null;
			OutputStreamWriter osw = null;
			Writer out = null;
			try {
				template = freemarkerCfg.getTemplate("com/wingo/wbase/report/ftl/clusteredLine.ftl");
				template.setEncoding("UTF-8");
				File htmlFile = new File(webroot + "/platform/report/combination/xml_data/ClusteredLineData.xml");
				fos = new FileOutputStream(htmlFile);
				osw = new OutputStreamWriter(fos, "UTF-8");
				out = new BufferedWriter(osw);
				HashMap propMap = new HashMap();
				if (list.size() > 0) {
					propMap.put("nodes", list);
				} else {
					propMap.put("nodes", new ArrayList());
				}
				template.process(propMap, out);
				out.flush();
				fos.flush();
				osw.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				out.close();
				fos.close();
				osw.close();
			}
		}
	}
	
	/**
	 * 折线组合图
	 * @param list
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void TreeLineChart(List<TreeLine> list) throws IOException {
		if (list == null) {
			return;
		} else {
			Configuration freemarkerCfg = new Configuration();
			freemarkerCfg.setClassForTemplateLoading(this.getClass(), "/");
			freemarkerCfg.setEncoding(Locale.getDefault(), "UTF-8");
			Template template;
			String webroot = System.getProperty("webapp.root");
			FileOutputStream fos = null;
			OutputStreamWriter osw = null;
			Writer out = null;
			try {
				template = freemarkerCfg.getTemplate("com/wingo/wbase/report/ftl/treeLine.ftl");
				template.setEncoding("UTF-8");
				File htmlFile = new File(webroot + "/platform/report/combination/xml_data/TreeLineData.xml");
				fos = new FileOutputStream(htmlFile);
				osw = new OutputStreamWriter(fos, "UTF-8");
				out = new BufferedWriter(osw);
				HashMap propMap = new HashMap();
				if (list.size() > 0) {
					propMap.put("nodes", list);
				} else {
					propMap.put("nodes", new ArrayList());
				}
				template.process(propMap, out);
				out.flush();
				fos.flush();
				osw.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				out.close();
				fos.close();
				osw.close();
			}
		}
	}

	/**
	 * 生成折线图的xml数据文件
	 * @throws IOException 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void amlineShow(List list) throws IOException {
		if (list == null) {
			return;
		} else {
			Configuration freemarkerCfg = new Configuration();
			freemarkerCfg.setClassForTemplateLoading(this.getClass(), "/");
			freemarkerCfg.setEncoding(Locale.getDefault(), "UTF-8");
			Template template;
			String webroot = System.getProperty("webapp.root");
			FileOutputStream fos = null;
			OutputStreamWriter osw = null;
			Writer out = null;
			try {
				template = freemarkerCfg.getTemplate("com/wingo/wbase/report/ftl/amline.ftl");
				template.setEncoding("UTF-8");
				File htmlFile = new File(webroot + "/platform/report/amline/amline_data.xml");
				fos = new FileOutputStream(htmlFile);
				osw = new OutputStreamWriter(fos, "UTF-8");
				out = new BufferedWriter(osw);
				HashMap propMap = new HashMap();
				if (list.size() > 0) {
					List strList = (List) list.get(0);
					String[] xpos = new String[strList.size()];
					for (int t = 0; t < xpos.length; t++) {
						xpos[t] = (String) strList.get(t);
					}
					list.remove(0);
					propMap.put("series", xpos);
					propMap.put("graphs", list);
				} else {
					propMap.put("series", new String[0]);
					propMap.put("graphs", new ArrayList());
				}
				template.process(propMap, out);
				out.flush();
				fos.flush();
				osw.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				out.close();
				fos.close();
				osw.close();
			}
		}
	}

	/**
	 * 生成折线图的xml数据文件
	 * @throws IOException 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void lineType(List list) throws IOException {
		if (list == null) {
			return;
		} else {
			Configuration freemarkerCfg = new Configuration();
			freemarkerCfg.setClassForTemplateLoading(this.getClass(), "/");
			freemarkerCfg.setEncoding(Locale.getDefault(), "UTF-8");
			String webroot = System.getProperty("webapp.root");
			Template template;
			FileOutputStream fos = null;
			OutputStreamWriter osw = null;
			Writer out = null;
			try {
				template = freemarkerCfg.getTemplate("com/wingo/wbase/report/ftl/amline.ftl");
				template.setEncoding("UTF-8");
				File htmlFile = new File(webroot
						+ "/platform/report/amline/amline_data.xml");

				fos = new FileOutputStream(htmlFile);
				osw = new OutputStreamWriter(fos, "UTF-8");

				out = new BufferedWriter(osw);
				HashMap propMap = new HashMap();
				if (list.size() > 0) {
					List strList = (List) list.get(0);
					String[] xpos = new String[strList.size()];
					for (int t = 0; t < xpos.length; t++) {
						xpos[t] = String.valueOf(t+1);
					}
					list.remove(0);
					propMap.put("series", xpos);
					propMap.put("graphs", list);
				} else {
					propMap.put("series", new String[0]);
					propMap.put("graphs", new ArrayList());
				}
				template.process(propMap, out);

				out.flush();
				fos.flush();
				osw.flush();

			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				out.close();
				fos.close();
				osw.close();
			}
		}
	}

}
