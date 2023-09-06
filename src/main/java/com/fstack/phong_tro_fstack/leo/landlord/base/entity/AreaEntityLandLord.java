package com.fstack.phong_tro_fstack.leo.landlord.base.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "area")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AreaEntityLandLord extends BaseEntityLandLord {
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "longitude", length = 50)
    private String longitude;

    @Column(name = "latitude", length = 50)
    private String latitude;

    @Column(name="exact_address", length = 255)
    private String exactAddress;

    @Column(name = "id_province")
    private String provinceId;

    @Column(name = "id_district")
    private String districtId;

    @Column(name = "id_ward")
    private String wardId;

}
