package com._520it._01_hello;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction03 extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("mayu");
        return SUCCESS;
    }
    public void list(){
        System.out.println("hirate yurina");
    }
    public void thug(){
        System.out.println("watanabe risa");
    }
}
