package com.polli.gustavo.devpoc.modules.user.usecase;

import com.polli.gustavo.devpoc.modules.user.dto.UserDTO;
import com.polli.gustavo.devpoc.modules.user.entity.User;
import com.polli.gustavo.devpoc.modules.user.mapper.UserMapper;
import com.polli.gustavo.devpoc.modules.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateUserUseCase {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User execute(Long id, UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        user.setId(id);
        return userRepository.save(user);
    }
}