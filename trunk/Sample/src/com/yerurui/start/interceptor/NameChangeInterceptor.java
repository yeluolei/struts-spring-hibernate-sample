package com.yerurui.start.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class NameChangeInterceptor extends AbstractInterceptor{


	/**
	 * 
	 */
	private static final long serialVersionUID = -483497886456332402L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
//		HttpServletRequest request=(HttpServletRequest)ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);  
//		OgnlValueStack stack =  (OgnlValueStack) request.getAttribute("struts.valueStack");
		
		invocation.getStack().set("name", invocation.getStack().findValue("name") + "小萝莉");
		return invocation.invoke();
	}

}
