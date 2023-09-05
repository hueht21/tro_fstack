package com.fstack.phong_tro_fstack.leo.landlord.base.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "province")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProvinceEntityLandLord {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "type", length = 45, nullable = false)
    private String type;

}
