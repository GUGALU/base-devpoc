package com.polli.gustavo.devpoc.modules.user.usecase;

import com.polli.gustavo.devpoc.modules.user.dto.UserDTO;
import com.polli.gustavo.devpoc.modules.user.entity.User;
import com.polli.gustavo.devpoc.modules.user.mapper.UserMapper;
import com.polli.gustavo.devpoc.modules.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateUserUseCase {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User execute(UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        return userRepository.save(user);
    }
}