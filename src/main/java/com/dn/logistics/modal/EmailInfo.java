package com.dn.logistics.modal;

import javax.validation.constraints.NotBlank;

public class EmailInfo {
    @NotBlank(message = "Email is mandatory")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
