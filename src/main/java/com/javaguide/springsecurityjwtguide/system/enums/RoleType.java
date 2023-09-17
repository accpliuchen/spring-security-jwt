package com.javaguide.springsecurityjwtguide.system.enums;

import lombok.Getter;


@Getter
public enum RoleType {
    USER("USER", "user"),
    TEMP_USER("TEMP_USER", "temp user"),
    MANAGER("MANAGER", "manager"),
    ADMIN("ADMIN", "admin");
    private final String name;
    private final String description;

    RoleType(java.lang.String name, java.lang.String description) {
        this.name = name;
        this.description = description;
    }
}
