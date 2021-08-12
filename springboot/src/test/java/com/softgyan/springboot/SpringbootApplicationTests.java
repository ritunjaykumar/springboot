package com.softgyan.springboot;

import com.softgyan.springboot.dao.UserRepository;
import com.softgyan.springboot.dao.UserServices;
import com.softgyan.springboot.models.User;
import org.assertj.core.api.AbstractBooleanAssert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringbootApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserServices services;

    @MockBean
    private UserRepository repository;

    @Test
    void saveRecord() {
        User resultUser = services.insertNewUser(repository, new User("ritu_text", "kharanti_test", "java dev_test"));
        User testUser = services.getSingleUser(repository, resultUser.getId());
        AbstractBooleanAssert<?> abstractBooleanAssert = assertThat(resultUser.getName().equals(testUser.getName()));
        System.out.println(abstractBooleanAssert);
    }

    @Test
    void getAllRecord() {
        when(repository.findAll()).thenReturn(Stream.of(
                new User(100, "abc", "xyz", "mnq"), new User(100, "abc", "xyz", "mnq")
        ).collect(Collectors.toList()));
        assertEquals(2,services.getAllUserList(repository).size());
    }


}
