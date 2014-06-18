package demo.shiro.service;

import java.util.Map;
import org.smart4j.security.exception.LoginException;
import org.smart4j.security.exception.RegisterException;

public interface UserService {

    void login(String username, String password, boolean isRememberMe) throws LoginException;

    void register(Map<String, String> fieldMap) throws RegisterException;
}
