package juhwan.study.springrestdocs.service;

import juhwan.study.springrestdocs.model.User;
import juhwan.study.springrestdocs.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User create(User user) {
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    public User read(Long id) {
        return userRepository.findById(id)
                .orElse(null);
    }

    public User update(User requestUser) {
        Optional<User> optionalUser = userRepository.findById(requestUser.getId());

        return optionalUser.map(user -> {
            user.setAccount(requestUser.getAccount());
            user.setEmail(requestUser.getEmail());
            user.setPhoneNumber(requestUser.getPhoneNumber());
            user.setUpdatedAt(LocalDateTime.now());
            return user;
        })
                .map(userRepository::save)
                .orElse(null);
    }

    public boolean delete(Long id){
        return  userRepository.findById(id)
                .map(user-> {
                    userRepository.deleteById(id);
                    return true;
                })
                .orElse(false);
    }
}
