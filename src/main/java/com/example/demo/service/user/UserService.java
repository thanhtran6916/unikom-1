package com.example.demo.service.user;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.User;
import com.example.demo.model.UserPrincipal;
import com.example.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new NotFoundException(NotFoundException.ID_NOT_FOUND);
        }
        return userOptional;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean delete(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new NotFoundException(NotFoundException.ID_NOT_FOUND);
        }
        User user = userOptional.get();
        user.setDeleteAt(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user);
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserExistByUsername(username);
        UserDetails userDetails = UserPrincipal.build(user);
        return userDetails;
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findUserExistByUsername(username);
        if (user == null) {
            throw new NotFoundException("Username dose not exist");
        }
        return user;
    }
}
