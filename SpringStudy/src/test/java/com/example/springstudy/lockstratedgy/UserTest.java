package com.example.springstudy.lockstratedgy;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        // Given
        User user = new User();
        user.setName("name1");
        user.setEmail("email@study.io");

        userRepository.save(user);

        // When
        Optional<User> userFromDB = userRepository.findById(user.getId());

        // Then
        assertNotNull(userFromDB);
    }

    @Test
    public void testPessimisticLock() {
        // Given
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            numbers.add(i);
        }

        // When
        numbers.parallelStream().forEach((index) -> {
            log.info("GET user ! (count: " + index + ")");

            Optional<User> userOptional = userRepository.findById(1L);

            if (userOptional.isPresent()) {
                User user = userOptional.get();
                user.setName("changed " + index);

                userRepository.save(user);
            }
        });

        // Then
    }
}
