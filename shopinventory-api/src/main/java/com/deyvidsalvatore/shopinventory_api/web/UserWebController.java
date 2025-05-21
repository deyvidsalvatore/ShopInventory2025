package com.deyvidsalvatore.shopinventory_api.web;

import static com.deyvidsalvatore.shopinventory_api.utils.WebUtils.createPageable;
import static com.deyvidsalvatore.shopinventory_api.utils.WebUtils.createSortParams;

import java.io.IOException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.deyvidsalvatore.shopinventory_api.domain.user.UserDTO;
import com.deyvidsalvatore.shopinventory_api.domain.user.UserService;
import com.deyvidsalvatore.shopinventory_api.domain.user.dto.UpdateUserPasswordDTO;
import com.deyvidsalvatore.shopinventory_api.domain.user.dto.UserCreateDTO;
import com.deyvidsalvatore.shopinventory_api.domain.user.dto.UserUpdateDTO;
import com.deyvidsalvatore.shopinventory_api.web.docs.UserControllerDocs;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "api/v1/user")
@Tag(name = "User", description = "Endpoints for Managing Users")
public class UserWebController implements UserControllerDocs {

    private final UserService userService;

    public UserWebController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) String sort
    ) {
        String[] sortParams = createSortParams(sort);
        Pageable pageable = createPageable(page, size, sortParams);
        return ResponseEntity.ok(userService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody @Valid UserCreateDTO dto) {
        return ResponseEntity.status(201).body(userService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody @Valid UserUpdateDTO dto) {
        return ResponseEntity.ok(userService.update(id, dto));
    }

    @PatchMapping("/{id}/password")
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @RequestBody @Valid UpdateUserPasswordDTO dto) {
        userService.updatePassword(id, dto);
        return ResponseEntity.noContent().build();
    }
    
    @PatchMapping("/{id}/profile-image")
    public ResponseEntity<Void> updateProfileImage(
            @PathVariable Long id,
            @RequestParam MultipartFile file) throws IOException {
        
        userService.updateUserProfileImg(id, file);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
