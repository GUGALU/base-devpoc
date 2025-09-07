package com.polli.gustavo.devpoc.modules.user.usecase;

import com.polli.gustavo.devpoc.modules.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteUserUseCase {

    private final UserRepository userRepository;

    public void execute(Long id) {
        userRepository.deleteById(id);
    }
}
