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
@Table(name = "UniRoles")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class UniRolesEntity {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;

    @Column(name = "name", columnDefinition = "VARCHAR(255) COMMENT '角色名称'")
    private String name;

    @Column(name = "description", columnDefinition = "VARCHAR(255) COMMENT '角色简介'")
    private String description;
}
