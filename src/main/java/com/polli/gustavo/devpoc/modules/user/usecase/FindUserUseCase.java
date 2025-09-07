package com.polli.gustavo.devpoc.modules.user.usecase;

import com.polli.gustavo.devpoc.modules.user.entity.User;
import com.polli.gustavo.devpoc.modules.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FindUserUseCase {

    private final UserRepository userRepository;

    public List<User> execute() {
        return userRepository.findAll();
    }

    public User execute(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
