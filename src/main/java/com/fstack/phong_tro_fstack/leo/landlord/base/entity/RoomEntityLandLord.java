package com.fstack.phong_tro_fstack.leo.landlord.base.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "room")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomEntityLandLord extends BaseEntityLandLord {
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "image", columnDefinition = "text", nullable = false)
    private String image;

    @Column(name = "video", columnDefinition = "text", nullable = false)
    private String video;

    @Column(name = "electric_service", nullable = false)
    private Float electricService;

    @Column(name = "water_service", nullable = false)
    private Float waterService;

    @Column(name = "rent_price", nullable = false)
    private Float rentPrice;

    @Column(name = "acreage", nullable = false)
    private Float acreage;

    @Column(name = "description", columnDefinition = "text", nullable = false)
    private String description;

    @Column(name = "id_area")
    private long areaId;
}
