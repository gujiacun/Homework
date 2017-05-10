package com._520it._01_upload;

public class LogicException extends RuntimeException {

    public LogicException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public LogicException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public LogicException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public LogicException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    public LogicException(String string) {
        super(string);
        
    }
    /**
     * 小结：在新建异常类时，不要先在测试类写出XXXException("YYY"),再自动建类和自动通过父类建构造器
     * 否则XXXException(String string)的构造器里面不会有调用父类构造器的super语句
     */
}
