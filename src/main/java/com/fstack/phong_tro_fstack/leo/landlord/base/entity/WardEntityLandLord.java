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
@Table(name = "ward")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class WardEntityLandLord {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "type", length = 45, nullable = false)
    private String type;
    @Column(name = "id_district")
    private long districtId;

    public WardEntityLandLord(long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
}
