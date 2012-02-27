package com.wingo.wbase.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wingo.wbase.common.base.BaseDAOHibernate;
import com.wingo.wbase.common.helper.PowerHelper;
import com.wingo.wbase.model.WbasePost;
import com.wingo.wbase.web.form.WbasePostForm;

/**
 * @Title: WbasePostDao.java
 * @Package com.wingo.wbase.dao;
 * @Description: 岗位DAO
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午01:46:19
 * @version V1.0
 */

public class WbasePostDao extends BaseDAOHibernate {
	private static final Log log = LogFactory.getLog(WbasePostDao.class);

	protected Class getModelClass() {
		return WbasePost.class;
	}

	/**
	 * 获取所有岗位数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<WbasePost> getPostList() {
		List<WbasePost> orgList = new ArrayList<WbasePost>();
		List oList = this.doFind("from WbasePost order by postLevel DESC");
		orgList = oList;
		return orgList;
	}

	/**
	 * 获取查询岗位数据集合
	 * 
	 * @param form
	 * @param pageSize
	 * @param startRow
	 * @return
	 */
	public int getTotalByOther(WbasePostForm form) {

		StringBuffer query = new StringBuffer();
		// 根据岗位编号
		query.append("from WbasePost o where 1=1 \n");
		if (form.getPostNo().trim().length()>0) {
			query.append(" and o.postNo like '%" + form.getPostNo().trim()
					+ "%' \n");
		}
		// 根据岗位名称
		if (form.getPostName().trim().length()>0) {
			query.append(" and o.postName like '%" + form.getPostName().trim()
					+ "%' \n");
		}

		int total = super.getRowsByHQL("select count(*) " + query.toString());

		return total;
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

		StringBuffer query = new StringBuffer();
		// 根据岗位编号
		query.append("from WbasePost o where 1=1 \n");
		if (form.getPostNo().trim().length()>0) {
			query.append(" and o.postNo like '%" + form.getPostNo().trim()
					+ "%' \n");
		}
		// 根据岗位名称
		if (form.getPostName().trim().length()>0) {
			query.append(" and o.postName like '%" + form.getPostName().trim()
					+ "%' \n");
		}

		query.append(" order by o.postLevel ASC ");
		List datas = super.doFind(query.toString(), pageSize, startRow);

		return datas;
	}

	/**
	 * 创建岗位
	 * 
	 * @param Post
	 */
	public boolean createPost(WbasePost Post) {
		return this.doCreateObjectReturn(Post);
	}

	/**
	 * 修改岗位
	 * 
	 * @param Post
	 */
	public void updatePost(WbasePost Post) {
		this.doUpdateObject(Post);
	}

	/**
	 * 查找岗位信息 BY ID
	 * 
	 * @param id
	 * @return
	 */
	public WbasePost findPostById(String id) {
		WbasePost Post = (WbasePost) this.doFindObjectById(id);
		return Post;
	}

	/**
	 * 查找岗位信息 BY PostNo
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public WbasePost findPostByPostNo(String postNo) {

		List<WbasePost> list = new ArrayList<WbasePost>();
		List<WbasePost> doFindObjectListByParam = (List<WbasePost>) this
				.doFindObjectListByParam(
						"from WbasePost o where o.postNo=:postNo", "postNo",
						postNo);
		list = doFindObjectListByParam;
		WbasePost Post = null;
		if (list != null && !list.isEmpty()) {
			Post = list.get(0);
		}
		return Post;
	}

	/**
	 * 删除岗位信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deletePostById(String id) {
		boolean bool = false;
		try {
			WbasePost Post = this.findPostById(id);
			PowerHelper.deletePostUserByPostNo(Post.getPostNo());
			this.doDeleteObject(Post);
			bool = true;
		} catch (Exception e) {
			bool = false;
		}
		return bool;
	}

	/**
	 * 删除岗位信息
	 * 
	 * @param list
	 * @return
	 */
	public boolean deletePostByIds(String[] ids) {
		boolean bool = false;
		try {
			if (ids != null && ids.length > 0) {
				for (int i = 0; i < ids.length; i++) {
					this.deletePostById(ids[i]);
				}
			}
			bool = true;
		} catch (Exception e) {
			bool = false;
		}
		return bool;
	}

}
