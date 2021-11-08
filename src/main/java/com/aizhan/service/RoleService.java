package com.aizhan.service;

import com.aizhan.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    List<String> getNamesOfRolesToList();

    Role getRoleByName(String name);
}
