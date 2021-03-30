package by.tms.bookstorec37.service;

import by.tms.bookstorec37.entity.User;
import by.tms.bookstorec37.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    public void addUser (User user) {
        userRepository.save(user);
    }

    public void deleteUserByUserName (String username) {
        userRepository.deleteUserByUsername(username);
    }

    public void deleteUserById (long id) {
        userRepository.deleteById(id);
    }

    public boolean isUserExistByUserName (String username) {
        return userRepository.existsUserByUsername(username);
    }

    public boolean isUserExistById (long id) {
        return userRepository.existsById(id);
    }

    public User getUserByUserName (String username) {
        return userRepository.getUserByUsername(username);
    }

    public User getUserById (long id) {
        return userRepository.getOne(id);
    }

    public void updateUserPasswordByUsername (String username, String newPassword) {
        userRepository.getUserByUsername(username).setPassword(newPassword);
    }

    public void updateUserPasswordById (long id, String newPassword) {
        userRepository.getUserById(id).setPassword(newPassword);
    }

    public void updateUserNameByUsername (String username, String newUsername) {
        userRepository.getUserByUsername(username).setUsername(newUsername);
    }

    public void updateUserNameById (long id, String newUsername) {
        userRepository.getUserById(id).setUsername(newUsername);
    }

}
