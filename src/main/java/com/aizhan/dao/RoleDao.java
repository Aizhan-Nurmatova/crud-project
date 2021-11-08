package com.aizhan.dao;

import com.aizhan.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAllRoles();
    List<String> getNamesOfRolesToList();
    Role getRoleByName(String name);
}

