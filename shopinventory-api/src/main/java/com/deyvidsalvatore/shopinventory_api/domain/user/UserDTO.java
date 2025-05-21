package com.deyvidsalvatore.shopinventory_api.domain.user;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

public class UserDTO extends RepresentationModel<UserDTO> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private Short roleId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String username;
    private String mobile;
    private String email;
    private String passwordHash;
    private Date registeredAt;
    private String imageUrl;
    private Date lastLogin;
    private String intro;
    private String profile;

    public UserDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getRoleId() {
        return roleId;
    }

    public void setRoleId(Short roleId) {
        this.roleId = roleId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Date getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Date registeredAt) {
        this.registeredAt = registeredAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, id, imageUrl, intro, lastLogin, lastName, middleName, mobile,
                passwordHash, profile, registeredAt, roleId, username);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        UserDTO other = (UserDTO) obj;
        return Objects.equals(email, other.email) &&
               Objects.equals(firstName, other.firstName) &&
               Objects.equals(id, other.id) &&
               Objects.equals(imageUrl, other.imageUrl) &&
               Objects.equals(intro, other.intro) &&
               Objects.equals(lastLogin, other.lastLogin) &&
               Objects.equals(lastName, other.lastName) &&
               Objects.equals(middleName, other.middleName) &&
               Objects.equals(mobile, other.mobile) &&
               Objects.equals(passwordHash, other.passwordHash) &&
               Objects.equals(profile, other.profile) &&
               Objects.equals(registeredAt, other.registeredAt) &&
               Objects.equals(roleId, other.roleId) &&
               Objects.equals(username, other.username);
    }
}
