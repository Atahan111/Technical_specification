package com.example.restapiexampl.service;

import com.example.restapiexampl.dto.UserRequestDto;
import com.example.restapiexampl.dto.UserUpdateRequestDto;
import com.example.restapiexampl.entity.User;
import com.example.restapiexampl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(UserRequestDto userRequestDto) {

        User user = new User();
        user.setName(userRequestDto.getName());

        userRepository.save(user);
    }


    public List<User> getAll() {

        return userRepository.findAll();
    }

    public User findById(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(
                () -> new Exception("User not found id = " + id)
        );
    }

    public void update(UserUpdateRequestDto userUpdateRequestDto) throws Exception {
        User user = userRepository.findById(userUpdateRequestDto.getId())
                .orElseThrow(() -> new Exception("User not found id = " + userUpdateRequestDto.getId()));
        user.setName(userUpdateRequestDto.getName());
        userRepository.save(user);
    }



    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

}
