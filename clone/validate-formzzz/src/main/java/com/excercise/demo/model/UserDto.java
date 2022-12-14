package com.excercise.demo.model;

import javax.validation.constraints.*;

public class UserDto {
    @NotEmpty(message = "First name is not allow empty")
    @NotBlank(message = "First name is not allow blank")
    @Size(min = 5,max = 45,message = "First name have to between 5 and 45 chars")
    @Pattern(regexp = "^([A-ZĐ][a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+[ ]*)+([A-ZĐ][a-záàảãạăâẩắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ])*+$",message = "Last name not match with format")

    private String firstName;
    @NotEmpty(message = "Last name is not allow empty")
    @NotBlank(message = "Last name is not allow blank")
    @Size(min = 2,max = 45,message = "Last name have to between 5 and 45 chars")
    @Pattern(regexp = "^[A-ZĐ][a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+$",message = "Last name not match with format")
    private String lastName;
    @NotEmpty(message = "Phone number is not allow empty")
    @NotBlank(message = "Phone number is not allow blank")
    @Pattern(regexp = "^[0]\\d{9}", message = "Phone number have to have size = 10 and begin with number is 0")
    private String phoneNumber;
    @Min(value = 19,message = "Age must bigger than 18")
    private int age;
    @Email(message = "Email have to match with format")
    private String email;

    public UserDto() {
    }

    public UserDto(@NotEmpty(message = "First name is not allow empty") @NotBlank(message = "First name is not allow blank") @Size(min = 5, max = 45, message = "First name have to between 5 and 45 chars") @Pattern(regexp = "^([A-ZĐ][a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+[ ]*)+([A-ZĐ][a-záàảãạăâẩắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ])*+$", message = "Last name not match with format") String firstName, @NotEmpty(message = "Last name is not allow empty") @NotBlank(message = "Last name is not allow blank") @Size(min = 2, max = 45, message = "Last name have to between 5 and 45 chars") @Pattern(regexp = "^[A-ZĐ][a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+$", message = "Last name not match with format") String lastName, @NotEmpty(message = "Phone number is not allow empty") @NotBlank(message = "Phone number is not allow blank") @Pattern(regexp = "^[0]\\d{9}", message = "Phone number have to have size = 10 and begin with number is 0") String phoneNumber, @Min(value = 19, message = "Age must bigger than 18") int age, @Email(message = "Email have to match with format") String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
