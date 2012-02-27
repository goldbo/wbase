package com.wingo.wbase.model;


/**
 * ViewUserInfoId generated by MyEclipse Persistence Tools
 */

public class ViewUserInfoId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -598487228053885990L;

	private String vid;

	private String uid;

	

	// Constructors

	/** default constructor */
	public ViewUserInfoId() {
	}

	/** full constructor */
	public ViewUserInfoId(String vid, String uid) {
		this.vid = vid;
		this.uid = uid;
	}

	// Property accessors

	public String getVid() {
		return this.vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ViewUserInfoId))
			return false;
		ViewUserInfoId castOther = (ViewUserInfoId) other;

		return ((this.getVid().equals(castOther.getVid())) || (this.getVid() != null
				&& castOther.getVid() != null && this.getVid().equals(
				castOther.getVid())))
				&& ((this.getUid().equals(castOther.getUid())) || (this.getUid() != null
						&& castOther.getUid() != null && this.getUid().equals(
						castOther.getUid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getVid() == null ? 0 : this.getVid().hashCode());
		result = 37 * result
				+ (getUid() == null ? 0 : this.getUid().hashCode());
		return result;
	}

}