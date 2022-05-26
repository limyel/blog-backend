package com.limyel.blog.service.impl;

import com.limyel.blog.common.exception.ApiException;
import com.limyel.blog.dao.UserRepository;
import com.limyel.blog.entity.User;
import com.limyel.blog.dto.AdminLoginDTO;
import com.limyel.blog.service.UserService;
import com.limyel.blog.common.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author limyel
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public User getByInfo(String username, String email) {
        return userRepository.findUserByUsernameAndEmail(username, email)
                .orElseThrow(() -> new ApiException(70001));
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public String login(User user, AdminLoginDTO userLoginDTO) {

        return null;
    }
}
