package com.example.mall.services;

import com.example.mall.DAO.UserDAO;
import com.example.mall.models.Role;
import com.example.mall.models.User;
import com.example.mall.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Получение текущего пользователя
    public User getCurrentUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        return userRepository.findByLogin(authentication.getName()).orElse(null);
    }

    // Создание нового пользователя
    public String createUser(UserDAO userDAO) {
        User user = new User();
        user.setName(userDAO.getName());
        user.setSurname(userDAO.getSurname());
        user.setLogin(userDAO.getLogin());
        user.setPassword(passwordEncoder.encode(userDAO.getPassword()));
        user.setRole(Role.USER);
        user.setRegistrationDate(LocalDate.now());
        userRepository.save(user);
        return "User was created successfully";
    }
}
