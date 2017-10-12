package com.orange.core.controller;

import com.orange.core.common.ResponseEnum;
import com.orange.core.common.ServiceException;
import com.orange.core.page.common.util.StringUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public class BaseController {

    /**
     * 通用页面重定向
     *
     * @param modelMap
     * @param page     页面url
     * @param msg
     * @return
     */
    protected ModelAndView returnPage(ModelMap modelMap, String page, String msg) {
        if (StringUtils.isBlank(page)) {
            throw new ServiceException(ResponseEnum.ILLEGAL_PARAM, "property 'page' config error");
        }
        modelMap.put("page", page);
        modelMap.put("msg", msg);
        return new ModelAndView("main");
    }
}
