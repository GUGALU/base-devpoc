package com.polli.gustavo.devpoc.modules.user.controller;

import com.polli.gustavo.devpoc.modules.user.dto.UserDTO;
import com.polli.gustavo.devpoc.modules.user.dto.UserResponseDTO;
import com.polli.gustavo.devpoc.modules.user.entity.User;
import com.polli.gustavo.devpoc.modules.user.mapper.UserMapper;
import com.polli.gustavo.devpoc.modules.user.usecase.CreateUserUseCase;
import com.polli.gustavo.devpoc.modules.user.usecase.DeleteUserUseCase;
import com.polli.gustavo.devpoc.modules.user.usecase.FindUserUseCase;
import com.polli.gustavo.devpoc.modules.user.usecase.UpdateUserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final FindUserUseCase findUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final UserMapper userMapper;

    @PostMapping
    public UserResponseDTO create(@RequestBody UserDTO userDTO) {
        User user = createUserUseCase.execute(userDTO);
        return userMapper.toUserResponseDTO(user);
    }

    @GetMapping
    public List<UserResponseDTO> find() {
        return findUserUseCase.execute().stream()
                .map(userMapper::toUserResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserResponseDTO findById(@PathVariable Long id) {
        User user = findUserUseCase.execute(id);
        return userMapper.toUserResponseDTO(user);
    }

    @PutMapping("/{id}")
    public UserResponseDTO update(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        User user = updateUserUseCase.execute(id, userDTO);
        return userMapper.toUserResponseDTO(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteUserUseCase.execute(id);
    }
}