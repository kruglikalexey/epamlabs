package com.epam.labs.lab9.src.mvc.form.bean;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFormBean {
    @NotNull()
    private String firstName;

    @NotNull
    private String lastName;
}