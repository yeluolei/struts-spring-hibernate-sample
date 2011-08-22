package com.yerurui.start.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class NameChangeInterceptor extends AbstractInterceptor{


	/**
	 * 
	 */
	private static final long serialVersionUID = -483497886456332402L;

	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {		
		ActionContext actionContext = invocation.getInvocationContext();
		@SuppressWarnings("rawtypes")
		Map params = (Map) actionContext.get(ActionContext.PARAMETERS);;
		params.put("name", ((String[])params.get("name"))[0]+"xiaoluoli");
		return invocation.invoke();
	}
}
