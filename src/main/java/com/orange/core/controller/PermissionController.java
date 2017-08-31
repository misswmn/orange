package com.orange.core.controller;

import com.orange.core.business.PermissionSupportBusiness;
import com.orange.core.common.ResultBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * @author ex-wangmengnan
 * @date 2017/8/31
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Inject
    private PermissionSupportBusiness permissionSupportBusiness;

    @RequestMapping(value = {"/load"}, method = RequestMethod.GET, name = "记载所有权限资源")
    public ResultBean listPermission() {
        return ResultBean.format(permissionSupportBusiness.getRequestMapping());
    }
}