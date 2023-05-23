package com.jinkss.blog.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);
        return (User) optionalUser.orElse(null);


    }

    public User createUser(User user) {
        User userSaved = null;
        try{
            userSaved = (User) userRepository.save(user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return userSaved;
        }
    }

    public User updateUser(Long id, User user) {

        User userSaved = null;
        try{
            userSaved = (User) userRepository.save(user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return userSaved;
        }
    }

    public boolean deleteUser(Long id) {

        try{
            userRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return true;
        }

    }


}
