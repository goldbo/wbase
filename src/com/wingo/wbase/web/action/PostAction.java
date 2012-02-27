package com.wingo.wbase.web.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wingo.wbase.common.Constants;
import com.wingo.wbase.common.base.BaseAction;
import com.wingo.wbase.common.helper.PagerHelper;
import com.wingo.wbase.common.helper.SpringHelper;
import com.wingo.wbase.common.vo.page.Pager;
import com.wingo.wbase.model.WbasePost;
import com.wingo.wbase.service.WbasePostService;
import com.wingo.wbase.web.form.WbasePostForm;

/**
 * @Title: PostAction.java
 * @Package com.wingo.wbase.web.action
 * @Description: TODO(用一句话描述该文件做什么)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-1-7 下午02:42:14
 * @version V1.0
 */
public class PostAction extends BaseAction {

	private WbasePostService wbasePostService = (WbasePostService) SpringHelper
			.getBean("wbasePostService");

	private static WbasePostForm pagePostForm = null;

	/**
	 * 显示所有岗位信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showPostList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		pagePostForm = (WbasePostForm) form;
		List datas = null;
		int total = 0;// 总记录数
		Pager pager = null;// 分页信息
		total = wbasePostService.getTotalByOther(pagePostForm);
		pager = PagerHelper.getPager(request, total);

		datas = wbasePostService.getPostListByOther(pagePostForm, pager
				.getPageSize(), pager.getStartRow());

		request.setAttribute("datas", datas);
		request.setAttribute("pager", pager);
		request.setAttribute("wbasePostForm", pagePostForm);

		return mapping.findForward("showPostList");
	}

	/**
	 * 创建岗位
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward editPost(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbasePostForm postForm = (WbasePostForm) form;
		String todo = postForm.getTodo();
		String forward = "";
		if (TODO_CREATE.equals(todo)) {
			forward = "createPost";
		} else if (TODO_UPDATE.equals(todo)) {
			String id = postForm.getId();
			WbasePost post = wbasePostService.findPostById(id);
			postForm = (WbasePostForm) this.modelToForm(post,
					"com.wingo.wbase.web.form.WbasePostForm");
			forward = "updatePost";
		} else {
			log.error("createOrUpdatePost－TODO参数传递错误或为空！");
		}

		request.setAttribute("wbasePostForm", postForm);
		return mapping.findForward(forward);
	}

	/**
	 * 新建岗位
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward createPost(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbasePostForm postForm = (WbasePostForm) form;
		WbasePost post = new WbasePost();
		String msg = "新增成功!";
		String todo = postForm.getTodo();
		String postNo = postForm.getPostNo();
		WbasePost postObj = wbasePostService.findPostByPostNo(postNo);
		if (postObj == null) {
			post = (WbasePost) this.formToModel(postForm,
					"com.wingo.wbase.model.WbasePost");
			post.setCreateDate(new Date());
			boolean flag = wbasePostService.createPost(post);
			msg = flag ? "新增成功!" : "新增失败!";
		} else {
			msg = "该岗位编号已被使用,新增失败!";
		}

		if (TODO_CREATE.equals(todo)) {
			postForm = new WbasePostForm();
			request.setAttribute("wbasePostForm", postForm);
			request.setAttribute(Constants.ALERT_MESSAGE, msg);
			return mapping.findForward("createPost");
		} else {
			this.returnJsMsg(response, msg, "window.close();");
			return null;
		}

	}

	/**
	 * 修改岗位
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updatePost(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbasePostForm postForm = (WbasePostForm) form;
		boolean flag = true;
		try {
			WbasePost post = wbasePostService.findPostById(postForm.getId());
			post.setPostName(postForm.getPostName());
			post.setPostLevel(postForm.getPostLevel());
			post.setRemark(postForm.getRemark());
			wbasePostService.updatePost(post);
			postForm.setTodo("update");
			request.setAttribute("wbasePostForm", postForm);
		} catch (Exception e) {
			flag = false;
		}
		request.setAttribute(Constants.ALERT_MESSAGE, flag == true ? "修改成功！"
				: "修改失败！");
		return mapping.findForward("updatePost");
	}

	/**
	 * 删除岗位
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deletePost(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WbasePostForm postForm = (WbasePostForm) form;
		boolean flag = wbasePostService.deletePostByIds(postForm
				.getSelectedRow());
		request.setAttribute(Constants.ALERT_MESSAGE, flag == true ? "删除成功！"
				: "删除失败！");
		pagePostForm = new WbasePostForm();
		request.setAttribute("wbasePostForm", pagePostForm);
		return showPostList(mapping, form, request, response);
	}

}
