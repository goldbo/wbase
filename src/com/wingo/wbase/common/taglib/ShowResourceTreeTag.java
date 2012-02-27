package com.wingo.wbase.common.taglib;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.wingo.wbase.common.SystemCache;
import com.wingo.wbase.model.WbaseResource;

/**
 * @Title: ShowResourceTreeTag.java
 * @Package com.wingo.wbase.common.taglib
 * @Description: TODO(资源树)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午03:16:49
 * @version V1.0
 */
public class ShowResourceTreeTag extends BodyTagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8338402559760438525L;

	private boolean edit;// 是否为可编辑树

	private String type;//  

	private String target;// Target for URL

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public int doStartTag() {

		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		StringBuffer buffer = new StringBuffer();
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		Map orgCache = SystemCache.resCache;
		buffer = showSystemTree(request, orgCache);

		try {
//			System.out.print(buffer.toString());
			out.println(buffer.toString());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return EVAL_PAGE;
	}

	/**
	 * 显示后台资源树
	 * 
	 * @param resList
	 * @return
	 */
	private StringBuffer showSystemTree(HttpServletRequest request, Map map) {
		StringBuffer contents = new StringBuffer();
		String path = request.getContextPath();
		contents.append("<div class=\"dtree\">\n");
		contents.append("<script type=\"text/javascript\">\n");
		contents.append("<!--\n");

		contents.append("var resourceTree = new dTree('resourceTree');\n");// create
		// a
		if (this.edit) {
			contents.append("resourceTree.config.check=true;\n");// 添加复选框
		}
		// array in
		// javascript

		for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {
			Map.Entry entry = (Map.Entry) iter.next();
			// Object key = entry.getKey();
			Object val = entry.getValue();
			WbaseResource info = (WbaseResource) val;
			// resourceTree.add(1, 0, 'My node', 'node.html', 'node title',
			// 'mainframe', 'img/musicfolder.gif');
			// resourceTree.add(0,-1,'My example tree');
			// define elements of array
			contents.append("resourceTree.add(");
			contents.append(info.getNodeNo());// 节点ID
			contents.append(",");
			contents.append(info.getSubNodeNo());// 节点父ID
			contents.append(",'");
			contents.append(info.getResName());// 节点名称
			contents.append("','");
			// Url for the node
			// if("system".equals(this.type)){
			contents
					.append(path
							+ "/ResourceAction.do?action=editResource&todo=update&nodeNo="
							+ info.getNodeNo());
			// }else if("menu".equals(this.type)){
			// contents.append(path+"/ResourceAction.do?action=editResource&todo=create");
			// }else{
			// contents.append(path);
			// }
			contents.append("','");
			contents.append(info.getResName());// Title for the node
			contents.append("','");
			contents.append(this.target);// Target for the node
			contents.append("');\n");
			// contents.append("img/musicfolder.gif");//Image file to use as the
			// icon. Uses default if not specified
			// contents.append("','");
			// contents.append("img/musicfolder.gif");//Image file to use as the
			// open icon. Uses default if not specified
			// contents.append("',");
			// contents.append("false");//Boolean Is the node open
			// contents.append(");\n");
		}
		contents.append("document.write(resourceTree);\n");

		contents.append("//-->\n");
		contents.append("</script>\n");
		contents.append("</div>\n");

		return contents;
	}

}
