package com.wingo.wbase.web.form;

import com.wingo.wbase.common.base.BaseForm;

/**   
 * @Title: WbasePowerForm.java 
 * @Package com.wingo.wbase.web.form 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author  CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.  
 * @date 2011-2-12 下午02:57:58 
 * @version V1.0   
 */
public class WbasePowerForm extends BaseForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7873969614455793086L;

	private String id;

	private String roleNo;

	private Long  resNodeNo;
	
	private Integer powerLevel = 0;
	
	/**
	 * 默认(是否可见)
	 */
	public Integer auto = 0;  
	/**
	 * 查看
	 */
	public Integer read = 0;

	/**
	 * 新增
	 */
	public Integer create = 0;

	/**
	 * 修改
	 */
	public Integer update = 0;

	/**
	 * 删除
	 */
	public Integer delete = 0;
	

	public Integer getCreate() {
		return create;
	}

	public void setCreate(Integer create) {
		this.create = create;
	}

	public Integer getDelete() {
		return delete;
	}

	public void setDelete(Integer delete) {
		this.delete = delete;
	}

	public Integer getRead() {
		return read;
	}

	public void setRead(Integer read) {
		this.read = read;
	}

	public Integer getUpdate() {
		return update;
	}

	public void setUpdate(Integer update) {
		this.update = update;
	}

	public Integer getPowerLevel() {
		int powerLevel= 0 ;
		if(this.auto!=0){
			powerLevel+=(int)Math.pow(2,this.auto);
		}
		if(this.read!=0){
			powerLevel+=(int)Math.pow(2,this.read);
		}
		if(this.create!=0){
			powerLevel+=(int)Math.pow(2,this.create);
		}
		if(this.update!=0){
			powerLevel+=(int)Math.pow(2,this.update);
		}
		if(this.delete!=0){
			powerLevel+=(int)Math.pow(2,this.delete);
		}
		return powerLevel;
	}

	public void setPowerLevel(Integer powerLevel) {
		this.powerLevel = powerLevel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getResNodeNo() {
		return resNodeNo;
	}

	public void setResNodeNo(Long resNodeNo) {
		this.resNodeNo = resNodeNo;
	}

	public String getRoleNo() {
		return roleNo;
	}

	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}

	public Integer getAuto() {
		return auto;
	}

	public void setAuto(Integer auto) {
		this.auto = auto;
	}
	
}
