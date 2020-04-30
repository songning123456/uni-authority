package com.uni.authority.repository;

import com.uni.authority.entity.UniUsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author songning
 * @date 2020/4/30
 * description
 */
public interface UniUsersRepository extends JpaRepository<UniUsersEntity, String> {

    UniUsersEntity findByUsername();
}
