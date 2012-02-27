package com.wingo.wbase.vo;

import com.wingo.wbase.common.helper.MD5Helper;

/**
 * @Title: Limits.java
 * @Package com.wingo.wbase.test
 * @Description: TODO(用一句话描述该文件做什么)
 * @author CN：谢茂盛 EN:SamHsieh 珠海市网佳科技有限公司.
 * @date 2011-2-11 下午02:16:28
 * @version V1.0
 */
public class Limits {
	
	/**
	 * 默认(是否可见)
	 */
	public static final int POWER_AUTO = 1;  
	/**
	 * 查看
	 */
	public static final int POWER_SELECT = 2;

	/**
	 * 新增
	 */
	public static final int POWER_CREATE = 3;

	/**
	 * 修改
	 */
	public static final int POWER_UPDATE = 4;

	/**
	 * 删除
	 */
	public static final int POWER_DELETE = 5;



	/**
	 * * 验证权限 *
	 * 
	 * @param limitsSum
	 *            权限总和 权限总和 为每个权限的3次方相加 *
	 * @param checkInt
	 *            具体权限 *
	 * @return
	 * 
	 */

	public static boolean checkLimits(int limitsSum, int checkInt) {

		return ((limitsSum & (1 << checkInt)) > 0);
	}

	/**
	 * * 生成权限总值 *
	 * 
	 * @param limits *
	 * @return
	 * 
	 */

	public static int createLimits(String[] limits) {

		int limitsSum = 0;
		for (int i = 0; i < limits.length; i++) {

			limitsSum += (1 << Integer.parseInt(limits[i]));
		}
		return limitsSum;
	}

	public static boolean checkPower(int userPurview, int optPurview) {
		int purviewValue = (int) Math.pow(2, optPurview);
		return (userPurview & purviewValue) == purviewValue;
	}

	public static void main(String [] arg){
		int userPurview=(int)Math.pow(2,2)+(int)Math.pow(2,3)+(int)Math.pow(2,5);
		System.out.println("查询新增修改权限总和："+userPurview);
//		int optPurview = 6;
//		
//		boolean flag = checkPower(userPurview, optPurview);
//		
//		System.out.println("是否有 5 删除 的权限"+flag);
		System.out.println(MD5Helper.MD5Encode("admin"));
		
	}
	
}