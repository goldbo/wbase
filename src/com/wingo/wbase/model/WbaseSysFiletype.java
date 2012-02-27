package com.wingo.wbase.model;

/**
 * WbaseSysFiletype generated by MyEclipse Persistence Tools
 */

public class WbaseSysFiletype implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8142136518896101304L;

	private String id;

	private String fileSuffix;

	private String filePic;

	private String fileRemark;

	// Constructors

	/** default constructor */
	public WbaseSysFiletype() {
	}

	/** full constructor */
	public WbaseSysFiletype(String fileSuffix, String filePic, String fileRemark) {
		this.fileSuffix = fileSuffix;
		this.filePic = filePic;
		this.fileRemark = fileRemark;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileSuffix() {
		return this.fileSuffix;
	}

	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}

	public String getFilePic() {
		return this.filePic;
	}

	public void setFilePic(String filePic) {
		this.filePic = filePic;
	}

	public String getFileRemark() {
		return this.fileRemark;
	}

	public void setFileRemark(String fileRemark) {
		this.fileRemark = fileRemark;
	}

}