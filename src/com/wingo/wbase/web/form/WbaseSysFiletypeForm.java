package com.wingo.wbase.web.form;

import com.wingo.wbase.common.base.BaseForm;

/**
 * @Title: SysFiletypeForm.java
 * @Package com.wingo.wbase.web.form
 * @Description: TODO(用一句话描述该文件做什么)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-4-28 上午10:31:20
 * @version V1.0
 */
public class WbaseSysFiletypeForm extends BaseForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4919333718116247658L;

	private String id;

	private String fileSuffix = "";

	private String filePic;

	private String fileRemark;
	
	private String savePath = "/uploadfile/filetype/";

	private String[] selectedRow;

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String[] getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(String[] selectedRow) {
		this.selectedRow = selectedRow;
	}

	public String getFilePic() {
		return filePic;
	}

	public void setFilePic(String filePic) {
		this.filePic = filePic;
	}

	public String getFileRemark() {
		return fileRemark;
	}

	public void setFileRemark(String fileRemark) {
		this.fileRemark = fileRemark;
	}

	public String getFileSuffix() {
		return fileSuffix;
	}

	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
