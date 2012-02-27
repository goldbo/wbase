package com.wingo.wbase.service;

import java.util.List;

import com.wingo.wbase.common.base.BaseServiceImpl;
import com.wingo.wbase.dao.WbasePostDao;
import com.wingo.wbase.model.WbasePost;
import com.wingo.wbase.web.form.WbasePostForm;

/**
 * @Title: WbasePostService.java
 * @Package com.wingo.wbase.service;
 * @Description: 岗位对象SERVICE
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */
public class WbasePostService extends BaseServiceImpl {
	private WbasePostDao wbasePostDao;

	public void setWbasePostDao(WbasePostDao wbasePostDao) {
		this.wbasePostDao = wbasePostDao;
	}

	/**
	 * 获取所有岗位数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public List<WbasePost> getPostList() {
		return wbasePostDao.getPostList();
	}

	/**
	 * 查找岗位信息 BY PostNo
	 * 
	 * @param id
	 * @return
	 */
	public WbasePost findPostByPostNo(String postNo) {
		return wbasePostDao.findPostByPostNo(postNo);
	}

	/**
	 * 获取查询岗位数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public List getPostListByOther(WbasePostForm form, int pageSize,
			int startRow) {
		return wbasePostDao.getPostListByOther(form, pageSize, startRow);
	}

	/**
	 * 获取总记录数
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public int getTotalByOther(WbasePostForm form) {
		return wbasePostDao.getTotalByOther(form);
	}

	/**
	 * 创建岗位
	 * 
	 * @param Post
	 */
	public boolean createPost(WbasePost Post) {
		return wbasePostDao.createPost(Post);
	}

	/**
	 * 修改岗位
	 * 
	 * @param Post
	 */
	public void updatePost(WbasePost Post) {
		wbasePostDao.updatePost(Post);
	}

	/**
	 * 查找岗位信息 BY ID
	 * 
	 * @param id
	 * @return
	 */
	public WbasePost findPostById(String id) {
		return wbasePostDao.findPostById(id);
	}

	/**
	 * 删除岗位信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deletePostById(String id) {
		return wbasePostDao.deletePostById(id);
	}

	/**
	 * 删除岗位信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deletePostByIds(String[] ids) {
		return wbasePostDao.deletePostByIds(ids);
	}

}
