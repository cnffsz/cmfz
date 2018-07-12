package com.hx.cmfz.utils;

import com.hx.cmfz.entity.Manager;
import com.hx.cmfz.entity.SysPermission;
import com.hx.cmfz.entity.SysRole;
import com.hx.cmfz.service.ManagerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2018/7/11.
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private ManagerService managerService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("----------加载权限验证----------");
        String name = (String) principalCollection.getPrimaryPrincipal();
        List<SysRole> roles = managerService.queryRoleByMgrName(name);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (SysRole role : roles) {
            info.addRole(role.getRoleTag());
        }
        List<SysPermission> permissions = managerService.queryPermisssionByMgrName(name);
        for (SysPermission permission : permissions) {
            info.addStringPermission(permission.getPermissionTag());
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        Manager manager = managerService.queryMgr(username);
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
