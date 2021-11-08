package com.aizhan.service;

import com.aizhan.dao.RoleDao;
import com.aizhan.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    public final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    @Transactional
    public List<String> getNamesOfRolesToList() {
        return roleDao.getNamesOfRolesToList();
    }

    @Override
    @Transactional
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }
}
