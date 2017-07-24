package com.orange.core.common;


import java.io.Serializable;

public class ResultBean implements Serializable {
    private static final long serialVersionUID = 5647005206941206294L;
    private int errorCode = ServiceCode.SUCCESS;
    private String description = "Success";
    private String access_token;
    private Object content;

    private ResultBean() {
    }

    public static ResultBean format() {
        return new ResultBeanBuilder().build();
    }

    public static ResultBean format(Object content) {
        return new ResultBeanBuilder().content(content).build();
    }

    public static ResultBean format(String access_token, Object content) {
        return new ResultBeanBuilder().access_token(access_token).content(content).build();
    }

    public static ResultBean format(ServiceException exception) {
        return new ResultBeanBuilder().errorCode(exception.getCode()).description(exception.getMessage()).build();
    }

    public static ResultBean format(int errorCode, String description) {
        return new ResultBeanBuilder().errorCode(errorCode).description(description).build();
    }

    public static class ResultBeanBuilder {
        private ResultBean resultBean;

        public ResultBeanBuilder() {
            this.resultBean = new ResultBean();
        }

        public ResultBeanBuilder errorCode(int errorCode) {
            this.resultBean.setErrorCode(errorCode);
            return this;
        }

        public ResultBeanBuilder content(Object content) {
            this.resultBean.setContent(content);
            return this;
        }

        public ResultBeanBuilder description(String description) {
            this.resultBean.setDescription(description);
            return this;
        }

        public ResultBeanBuilder access_token(String access_token) {
            this.resultBean.setAccess_token(access_token);
            return this;
        }

        public ResultBean build() {
            return resultBean;
        }
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
