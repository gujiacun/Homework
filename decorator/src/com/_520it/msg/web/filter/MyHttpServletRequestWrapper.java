package com._520it.msg.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com._520it.msg.util.FilterUtil;

public class MyHttpServletRequestWrapper extends HttpServletRequestWrapper {

    public MyHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getParameter(String name) {
        // 判断在servlet中的是否为title或content，指定要过滤的内容
        if ("title".equals(name) || "content".equals(name)) {
            //拿真实数据
            String value = super.getParameter(name);
            //调用工具类方法,把敏感词替换为*，再返回
            return FilterUtil.filter(value);
        }
        return super.getParameter(name);
    }
}
