package com.deyvidsalvatore.shopinventory_api.web.docs;

import java.io.IOException;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.deyvidsalvatore.shopinventory_api.domain.user.UserDTO;
import com.deyvidsalvatore.shopinventory_api.domain.user.dto.UpdateUserPasswordDTO;
import com.deyvidsalvatore.shopinventory_api.domain.user.dto.UserCreateDTO;
import com.deyvidsalvatore.shopinventory_api.domain.user.dto.UserUpdateDTO;
import com.deyvidsalvatore.shopinventory_api.web.docs._response.PageResponseUserDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

public interface UserControllerDocs {

    @Operation(summary = "Find all users",
            description = "Returns paginated list of all users",
            tags = {"User"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful operation",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation =  PageResponseUserDTO.class)))),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
            })
    ResponseEntity<Page<UserDTO>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sort
    );

    @Operation(summary = "Find user by ID",
            description = "Returns a user by their ID",
            tags = {"User"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful operation",
                            content = @Content(schema = @Schema(implementation = UserDTO.class))),
                    @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
            })
    ResponseEntity<UserDTO> findById(@PathVariable Long id);

    @Operation(summary = "Create new user",
            description = "Creates a new user with given details",
            tags = {"User"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "User created",
                            content = @Content(schema = @Schema(implementation = UserDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error", content = @Content),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
            })
    ResponseEntity<UserDTO> create(@RequestBody @Valid UserCreateDTO dto);

    @Operation(summary = "Update user",
            description = "Updates an existing user by ID",
            tags = {"User"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "User updated",
                            content = @Content(schema = @Schema(implementation = UserDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error", content = @Content),
                    @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
            })
    ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody @Valid UserUpdateDTO dto);

    @Operation(summary = "Update user password",
            description = "Updates the password of an existing user",
            tags = {"User"},
            responses = {
                    @ApiResponse(responseCode = "204", description = "Password updated", content = @Content),
                    @ApiResponse(responseCode = "400", description = "Validation error", content = @Content),
                    @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
            })
    ResponseEntity<Void> updatePassword(@PathVariable Long id, @RequestBody @Valid UpdateUserPasswordDTO dto);

    @Operation(summary = "Update user profile image",
            description = "Updates the profile image of an existing user",
            tags = {"User"},
            responses = {
                    @ApiResponse(responseCode = "204", description = "Profile image updated", content = @Content),
                    @ApiResponse(responseCode = "400", description = "Invalid file or request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
            })
    ResponseEntity<Void> updateProfileImage(@PathVariable Long id, @RequestParam MultipartFile file) throws IOException;

    @Operation(summary = "Delete user",
            description = "Deletes a user by ID",
            tags = {"User"},
            responses = {
                    @ApiResponse(responseCode = "204", description = "User deleted", content = @Content),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
            })
    ResponseEntity<Void> delete(@PathVariable Long id);
}
