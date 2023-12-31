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
@Table(name = "post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostEntityLandLord extends BaseEntityLandLord {
    @Column(name = "thumbnail", length = 255)
    private String thumbnail;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "content", columnDefinition = "text", nullable = false)
    private String content;

    @Column(name = "phone_number", length = 12, nullable = false)
    private String phoneNumber;

    @Column(name = "phone_zalo", length = 12, nullable = false)
    private String phoneZalo;

    @Column(name = "status", nullable = false)
    private Integer status;

    @CreatedDate
    @Column(name = "created_time", nullable = false, updatable = false)
    private Date createdTime;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "number_date")
    private Integer numberDate;

    @Column(name = "id_user")
    private long userId;

    @Column(name = "id_area")
    private long areaId;
}
