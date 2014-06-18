package com.channelsoft.shiro.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyShiro {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void testShiro() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		// 获取当前用户
		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
		// 登录
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("shiro", "201314");
		try {
			subject.login(usernamePasswordToken);
		} catch (AuthenticationException e) {
			logger.info("登录失败！");
			return;
		}
		logger.info("登录成功！Hello " + subject.getPrincipal());
		Assert.assertEquals("shiro", subject.getPrincipal());
		// 注销
		subject.logout();
		
	}
}
