package com.modakbul.dto.campsite;

import com.modakbul.entity.campsite.Campsite;
import com.modakbul.entity.campground.Campground;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CampsiteDto {
    private Long id;
    private Campground campground; // 변경: 외래키를 Campground 엔티티로 변경
    private String campsiteName;
    private String campsiteDescription;
    private int headCount;
    private int weekdayPrice;
    private int weekendPrice;

    // CampsiteDto를 Campsite 엔티티로 변환하는 메서드
    public Campsite toEntity() {
        return Campsite.builder()
                .id(this.id)
                .campground(this.campground)
                .campsiteName(this.campsiteName)
                .campsiteDescription(this.campsiteDescription)
                .headCount(this.headCount)
                .weekdayPrice(this.weekdayPrice)
                .weekendPrice(this.weekendPrice)
                .build();
    }

    // Campsite 엔티티를 기반으로 DTO를 생성하는 생성자
    public CampsiteDto(Campsite campsite) {
        this.id = campsite.getId();
        this.campground = campsite.getCampground();
        this.campsiteName = campsite.getCampsiteName();
        this.campsiteDescription = campsite.getCampsiteDescription();
        this.headCount = campsite.getHeadCount();
        this.weekdayPrice = campsite.getWeekdayPrice();
        this.weekendPrice = campsite.getWeekendPrice();
    }
}
