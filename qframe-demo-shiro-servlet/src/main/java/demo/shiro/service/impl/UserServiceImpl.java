package demo.shiro.service.impl;

import demo.shiro.service.UserService;
import demo.shiro.tool.Database;
import java.util.Map;
import org.smart4j.security.SmartSecurityHelper;
import org.smart4j.security.exception.LoginException;
import org.smart4j.security.exception.RegisterException;

public class UserServiceImpl implements UserService {

    @Override
    public void login(String username, String password, boolean isRememberMe) throws LoginException {
        SmartSecurityHelper.login(username, password, isRememberMe);
    }

    @Override
    public void register(Map<String, String> fieldMap) throws RegisterException {
        String username = fieldMap.get("username");
        String password = fieldMap.get("password");

        // 在 user 表中根据 username 查询用户是否已存在
        String selectSQL = "select count(*) from user where username = ?";
        Long userCount = Database.queryColumn(selectSQL, username);
        if (userCount > 0) {
            throw new RegisterException();
        }

        // 加密密码
        password = SmartSecurityHelper.encrypt(password);

        // 插入 user 表
        String insertSQL = "insert into user (username, password) values (?, ?)";
        Database.update(insertSQL, username, password);
    }
}
