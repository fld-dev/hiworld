package com.shiro.testshiro.realms;

import com.shiro.testshiro.mapper.UserMapper;
import com.shiro.testshiro.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;


//    @Override
//    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher("MD5");
//        hashedCredentialsMatcher.setHashIterations(1);
//        super.setCredentialsMatcher(hashedCredentialsMatcher);
//    }

    //用于用户权限的授取和封装
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        Set<String> roles = new HashSet<>();
        Set<String> permissions=new HashSet<>();

        if ("admin".equals(username)) {
            roles.add("admin");
            permissions.add("user:list");
        }

//        roles.add("admin");//通过@RequireRoles("admin")来修饰controller层来完成权限认证
//        permissions.add("user:list");//通过@RequiredPermission("admin:query")来修饰controller层完成权限认证

        //封装权限信息
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    //用户登录认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //根据AuthenticationToken token,获取通过表单传过来的用户名
        String username = (String)token.getPrincipal();
        //根据用户名从数据库查询数据
        User userByUsername = userMapper.findUserByUsername(username);
        //判断用户的身份
        if (userByUsername==null)throw new UnknownAccountException("用户名或密码不正确");
        //使用API:SimpleAuthenticationTokenInfo 对传入的参数进行验证
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userByUsername.getUsername(),userByUsername.getPassword(),"MyRealm");
        return info;
    }
}
