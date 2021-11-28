package pl.ps.demo.service.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UserDTO {

    private Long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    public UserDTO() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private Long id;
        private String userName;
        private String password;
        private String firstName;
        private String lastName;
        private String email;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder userName(String userName){
            this.userName = userName;
            return this;
        }

        public Builder password(String password){
            this.password = password;
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

        public UserDTO build() {
            UserDTO userDTO = new UserDTO();
            userDTO.id = this.id;
            userDTO.userName = this.userName;
            userDTO.password = this.password;
            userDTO.firstName = this.firstName;
            userDTO.lastName = this.lastName;
            userDTO.email = this.email;

            return userDTO;
        }
    }
}
