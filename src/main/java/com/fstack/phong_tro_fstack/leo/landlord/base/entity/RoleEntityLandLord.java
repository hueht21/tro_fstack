package com.fstack.phong_tro_fstack.leo.landlord.base.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;


@Entity
@Table(name = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntityLandLord extends BaseEntityLandLord {
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

}
