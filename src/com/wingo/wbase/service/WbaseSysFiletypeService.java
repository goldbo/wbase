package com.wingo.wbase.service;

import java.util.List;

import com.wingo.wbase.common.base.BaseServiceImpl;
import com.wingo.wbase.dao.WbaseSysFiletypeDao;
import com.wingo.wbase.model.WbaseSysFiletype;
import com.wingo.wbase.web.form.WbaseSysFiletypeForm;

/**
 * @Title: WbaseSysFiletypeService.java
 * @Package com.wingo.wbase.service;
 * @Description: 系统文件类型对象SERVICE
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */
public class WbaseSysFiletypeService extends BaseServiceImpl {
	private WbaseSysFiletypeDao wbaseSysFiletypeDao;

	public void setWbaseSysFiletypeDao(WbaseSysFiletypeDao wbaseSysFiletypeDao) {
		this.wbaseSysFiletypeDao = wbaseSysFiletypeDao;
	}

	/**
	 * 获取所有系统文件类型数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public List<WbaseSysFiletype> getSysFiletypeList() {
		return wbaseSysFiletypeDao.getSysFiletypeList();
	}

	/**
	 * 查找系统文件类型信息 BY SysFiletypeNo
	 * 
	 * @param id
	 * @return
	 */
	public WbaseSysFiletype findSysFiletypeByFileSuffix(String fileSuffix) {
		return wbaseSysFiletypeDao.findSysFiletypeByFileSuffix(fileSuffix);
	}

	/**
	 * 获取查询系统文件类型数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public List getSysFiletypeListByOther(WbaseSysFiletypeForm form, int pageSize,
			int startRow) {
		return wbaseSysFiletypeDao.getSysFiletypeListByOther(form, pageSize, startRow);
	}

	/**
	 * 获取总记录数
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public int getTotalByOther(WbaseSysFiletypeForm form) {
		return wbaseSysFiletypeDao.getTotalByOther(form);
	}

	/**
	 * 创建系统文件类型
	 * 
	 * @param SysFiletype
	 */
	public boolean createSysFiletype(WbaseSysFiletype SysFiletype) {
		return wbaseSysFiletypeDao.createSysFiletype(SysFiletype);
	}

	/**
	 * 修改系统文件类型
	 * 
	 * @param SysFiletype
	 */
	public void updateSysFiletype(WbaseSysFiletype SysFiletype) {
		wbaseSysFiletypeDao.updateSysFiletype(SysFiletype);
	}

	/**
	 * 查找系统文件类型信息 BY ID
	 * 
	 * @param id
	 * @return
	 */
	public WbaseSysFiletype findSysFiletypeById(String id) {
		return wbaseSysFiletypeDao.findSysFiletypeById(id);
	}

	/**
	 * 删除系统文件类型信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deleteSysFiletypeById(String id) {
		return wbaseSysFiletypeDao.deleteSysFiletypeById(id);
	}

	/**
	 * 删除系统文件类型信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deleteSysFiletypeByIds(String[] ids) {
		return wbaseSysFiletypeDao.deleteSysFiletypeByIds(ids);
	}

}
