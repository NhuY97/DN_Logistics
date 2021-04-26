package com.dn.logistics.modal;

import javax.validation.constraints.NotBlank;

public class UserInfo {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Phone is mandatory")
    private String phone;
    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Message is mandatory")
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
