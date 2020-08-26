package com.kudos.kudosManager.mapper;

import com.kudos.kudosManager.entity.UserEntity;
import com.kudos.kudosManager.model.User;

public class UserServiceMapper {

    public static UserEntity getUserEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setEmail(user.getEmail());
        entity.setRoleid(user.getRoleid());
        entity.setLoginPassword(user.getLoginPassword());
        return entity;
    }
}
