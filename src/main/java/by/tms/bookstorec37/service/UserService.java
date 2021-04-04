package by.tms.bookstorec37.service;

import by.tms.bookstorec37.entity.User;
import by.tms.bookstorec37.repository.UserRepository;
import by.tms.bookstorec37.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUserByUserName(String username) {
        User user = getUserByUserName(username);
        if (user.getUsername().equals(username)) {
            userRepository.deleteUserByUsername(username);
        } else {
            throw new UserNotFoundException("User is not found");
        }
    }

    public void deleteUserById(long id) {
        User user = getUserById(id);
        if (getUserById(id).equals(user)) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("User is not found");
        }
    }

    public boolean isUserExistByUserName(String username) {
        User user = getUserByUserName(username);
        if (getUserByUserName(username).equals(user)) {
            return userRepository.existsUserByUsername(username);
        } else {
            throw new UserNotFoundException("User is not found");
        }
    }

    public boolean isUserExistById(long id) {
        User user = getUserById(id);
        if (getUserById(id).equals(user)) {
            return userRepository.existsById(id);
        } else {
            throw new UserNotFoundException("User is not found");
        }
    }

    public User getUserByUserName(String username) {
        if (userRepository.getUserByUsername(username) == null) {
            throw new UserNotFoundException("User is not found");
        } else {
            return userRepository.getUserByUsername(username);
        }
    }

    public User getUserById(long id) {
        if (userRepository.getUserById(id) == null) {
            throw new UserNotFoundException("User is not found");
        } else {
            return userRepository.getOne(id);
        }
    }

    public void updateUserPasswordByUsername(String username, String newPassword) {
        User user = getUserByUserName(username);
        if (getUserByUserName(username).equals(user)) {
            userRepository.getUserByUsername(username).setPassword(newPassword);
        } else {
            throw new UserNotFoundException("User is not found");
        }
    }

    public void updateUserPasswordById(long id, String newPassword) {
        User user = getUserById(id);
        if (getUserById(id).equals(user)) {
            userRepository.getUserById(id).setPassword(newPassword);
        } else {
            throw new UserNotFoundException("User is not found");
        }
    }

    public void updateUserNameByUsername(String username, String newUsername) {
        User user = getUserByUserName(username);
        if (getUserByUserName(username).equals(user)) {
            userRepository.getUserByUsername(username).setUsername(newUsername);
        } else {
            throw new UserNotFoundException("User is not found");
        }
    }

    public void updateUserNameById(long id, String newUsername) {
        User user = getUserById(id);
        if (getUserById(id).equals(user)) {
            userRepository.getUserById(id).setUsername(newUsername);
        } else {
            throw new UserNotFoundException("User is not found");
        }
    }
}
