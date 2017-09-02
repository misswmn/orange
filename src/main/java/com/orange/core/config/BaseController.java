package com.orange.core.config;

import com.orange.core.common.ServiceCode;
import com.orange.core.common.ServiceException;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public class BaseController {

    /**
     * @param modelMap
     * @param page     页面url
     * @param msg
     * @return
     */
    protected ModelAndView returnPage(ModelMap modelMap, String page, String msg) {
        if (page == null || "".equalsIgnoreCase(page)) {
            throw new ServiceException(ServiceCode.UNKNOWN_EXCEPTION, "property 'page' config error");
        }
        modelMap.put("page", page);
        modelMap.put("msg", msg);
        return new ModelAndView("main");
    }
}
