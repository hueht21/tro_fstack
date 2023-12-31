package com.fstack.phong_tro_fstack.leo.landlord.base.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceDTOLandLord extends BaseDTOLandLord {
    private String name;

    private String type;
}
