package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.dao.UserMapper;
import com.mmall.pojo.User;

/**
 * @author YH
 */
public interface IUserService {
    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    public ServerResponse<String> checkValid(String str, String type);

    public ServerResponse<String> selectQuestion(String username);

    public ServerResponse<String> checkAnswer(String username, String question, String answer);

    public ServerResponse<String> forgetResetPassword(String username, String newPassword, String forgetToken);

    public ServerResponse<String> resetPassword(String oldPassword, String newPassword, User user);

    public ServerResponse<User> updateInfomation(User user);

    public ServerResponse<User> getInformation(Integer userId);

    public ServerResponse<String> checkAdminRole(User user);
}
