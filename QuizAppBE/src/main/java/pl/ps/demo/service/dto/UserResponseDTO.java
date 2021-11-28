package pl.ps.demo.service.dto;

import pl.ps.demo.model.enums.RoleName;

public class UserResponseDTO {

    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private RoleName roleName;
    private String accessToken;
    private String refreshToken;

    public UserResponseDTO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private Long id;
        private String userName;
        private String firstName;
        private String lastName;
        private String email;
        private RoleName roleName;
        private String accessToken;
        private String refreshToken;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder userName(String userName){
            this.userName = userName;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder roleName(RoleName roleName){
            this.roleName = roleName;
            return this;
        }

        public Builder accessToken(String accessToken){
            this.accessToken = accessToken;
            return this;
        }

        public Builder refreshToken(String refreshToken){
            this.refreshToken = refreshToken;
            return this;
        }

        public UserResponseDTO build() {
            UserResponseDTO userResponseDTO = new UserResponseDTO();
            userResponseDTO.id = this.id;
            userResponseDTO.userName = this.userName;
            userResponseDTO.firstName = this.firstName;
            userResponseDTO.lastName = this.lastName;
            userResponseDTO.email = this.email;
            userResponseDTO.roleName = this.roleName;
            userResponseDTO.accessToken = this.accessToken;
            userResponseDTO.refreshToken = this.refreshToken;

            return userResponseDTO;
        }
    }
}
