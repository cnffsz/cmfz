package com.hx.cmfz.utils;

import com.hx.cmfz.entity.Manager;
import com.hx.cmfz.service.ManagerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2018/7/11.
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private ManagerService managerService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        char[] password = usernamePasswordToken.getPassword();
        Manager manager = managerService.queryMgr(username,password.toString());
        if(manager!=null){
            return new SimpleAuthenticationInfo(
                    manager.getMgrName(),
                    manager.getMgrPwd(),
                    ByteSource.Util.bytes(manager.getSalt()),
                    this.getName());
        }
        return null;
    }
}
