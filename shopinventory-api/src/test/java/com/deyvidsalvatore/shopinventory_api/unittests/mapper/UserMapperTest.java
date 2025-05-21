package com.deyvidsalvatore.shopinventory_api.unittests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.deyvidsalvatore.shopinventory_api.domain.mapper.ObjectMapper;
import com.deyvidsalvatore.shopinventory_api.domain.user.UserDTO;
import com.deyvidsalvatore.shopinventory_api.domain.user.UserModel;
import com.deyvidsalvatore.shopinventory_api.unittests.mapper.mock.MockUser;

public class UserMapperTest {

    MockUser inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockUser();
    }

    @Test
    public void parseEntityToDTOTest() {
        UserDTO output = ObjectMapper.parseObject(inputObject.mockEntity(), UserDTO.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First0", output.getFirstName());
        assertEquals("user0", output.getUsername());
        assertEquals("user0@email.com", output.getEmail());
    }

    @Test
    public void parseDTOToEntityTest() {
        UserModel output = ObjectMapper.parseObject(inputObject.mockDTO(), UserModel.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First0", output.getFirstName());
        assertEquals("user0", output.getUsername());
        assertEquals("user0@email.com", output.getEmail());
    }

    @Test
    public void parseEntityListToDTOListTest() {
        List<UserDTO> outputList = ObjectMapper.parseListObjects(inputObject.mockEntityList(), UserDTO.class);
        assertEquals(14, outputList.size());
        assertEquals("First0", outputList.get(0).getFirstName());
        assertEquals("First7", outputList.get(7).getFirstName());
        assertEquals("First12", outputList.get(12).getFirstName());
    }

    @Test
    public void parseDTOListToEntityListTest() {
        List<UserModel> outputList = ObjectMapper.parseListObjects(inputObject.mockDTOList(), UserModel.class);
        assertEquals(14, outputList.size());
        assertEquals("user0", outputList.get(0).getUsername());
        assertEquals("user7", outputList.get(7).getUsername());
        assertEquals("user12", outputList.get(12).getUsername());
    }
}
