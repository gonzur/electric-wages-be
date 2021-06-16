package io.electricwages.server.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.electricwages.server.models.User;
import io.electricwages.server.repositories.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DataJpaTest
public class LoginControllerTest {

    @Autowired
    static UserRepository userRepository;

    @BeforeAll
    static void init() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        userRepository.save(user);
    }

    @Test
    void loginTest(@Autowired MockMvc mockMvc) throws Exception {
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(user);
        mockMvc.perform(post("/login")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
