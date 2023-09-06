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
@Table(name = "transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntitylandlord extends BaseEntityLandLord {
    @Column(name = "deposit_amount", columnDefinition = "float", nullable = false)
    private Float depositAmount;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Column(name = "id_user")
    private long userId;
}
