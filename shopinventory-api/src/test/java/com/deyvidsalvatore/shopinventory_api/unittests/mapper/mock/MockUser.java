package com.deyvidsalvatore.shopinventory_api.unittests.mapper.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.deyvidsalvatore.shopinventory_api.domain.user.UserDTO;
import com.deyvidsalvatore.shopinventory_api.domain.user.UserModel;

public class MockUser {

    public UserModel mockEntity() {
        return mockEntity(0);
    }

    public UserDTO mockDTO() {
        return mockDTO(0);
    }

    public List<UserModel> mockEntityList() {
        List<UserModel> users = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            users.add(mockEntity(i));
        }
        return users;
    }

    public List<UserDTO> mockDTOList() {
        List<UserDTO> users = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            users.add(mockDTO(i));
        }
        return users;
    }

    public UserModel mockEntity(Integer number) {
        UserModel user = new UserModel();
        user.setId(number.longValue());
        user.setRoleId((short) 1);
        user.setFirstName("First" + number);
        user.setMiddleName("Middle" + number);
        user.setLastName("Last" + number);
        user.setUsername("user" + number);
        user.setMobile("999999999" + number);
        user.setEmail("user" + number + "@email.com");
        user.setPasswordHash("hash" + number);
        user.setRegisteredAt(new Date());
        user.setImageUrl("http://image" + number + ".com");
        user.setLastLogin(new Date());
        user.setIntro("Intro " + number);
        user.setProfile("Profile " + number);
        return user;
    }

    public UserDTO mockDTO(Integer number) {
        UserDTO user = new UserDTO();
        user.setId(number.longValue());
        user.setRoleId((short) 1);
        user.setFirstName("First" + number);
        user.setMiddleName("Middle" + number);
        user.setLastName("Last" + number);
        user.setUsername("user" + number);
        user.setMobile("999999999" + number);
        user.setEmail("user" + number + "@email.com");
        user.setPasswordHash("hash" + number);
        user.setRegisteredAt(new Date());
        user.setImageUrl("http://image" + number + ".com");
        user.setLastLogin(new Date());
        user.setIntro("Intro " + number);
        user.setProfile("Profile " + number);
        return user;
    }
}