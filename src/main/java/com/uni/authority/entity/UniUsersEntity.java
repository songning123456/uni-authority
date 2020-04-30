package com.uni.authority.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author songning
 * @date 2020/4/30
 * description
 */
@Data
@Entity
@Table(name = "UniUsers")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class UniUsersEntity {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;

    @Column(name = "username", columnDefinition = "VARCHAR(255) COMMENT '用户名'")
    private String username;

    @Column(name = "password", columnDefinition = "VARCHAR(64) COMMENT '密码'")
    private String password;

    @Column(name = "roleNames", columnDefinition = "VARCHAR(255) COMMENT '关联角色，多个以逗号分隔'")
    private String roleNames;

    @Column(name = "status", columnDefinition = "TINYINT COMMENT '用户状态，0正常，1注销'")
    private int status;
}
