package com.modakbul.dto.campsite;

import com.modakbul.entity.booking.Booking;
import com.modakbul.entity.campsite.Campsite;
import com.modakbul.entity.campground.Campground;
import com.modakbul.entity.campsite.CampsiteOptionLink;
import com.modakbul.entity.campsite.CampsitePrice;
import com.modakbul.entity.image.CampsiteImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CampsiteDto {
    private Long id;
    private Long campgroundId; // 변경: 외래키를 Campground 엔티티로 변경
    private String campsiteName;
    private String campsiteDescription;
    private int headCount;
    private int weekdayPrice;
    private int weekendPrice;
    private int campsiteNumber;

    private List<CampsiteOptionLink> campsiteOptionLinks;
    private List<CampsiteImage> campsiteImages;
    private List<Booking> bookings;

    // CampsiteDto를 Campsite 엔티티로 변환하는 메서드
    public Campsite toEntity(Campground campground) {
        return Campsite.builder()
                .id(this.id)
                .campground(campground)
                .campsiteName(this.campsiteName)
                .campsiteDescription(this.campsiteDescription)
                .headCount(this.headCount)
                .weekdayPrice(this.weekdayPrice)
                .weekendPrice(this.weekendPrice)
                .campsiteNumber(this.campsiteNumber)
                .campsiteOptionLinks(this.campsiteOptionLinks)
                .campsiteImages(this.campsiteImages)
                .bookings(this.bookings)
                .build();
    }

    // Campsite 엔티티를 기반으로 DTO를 생성하는 생성자
    public CampsiteDto(Campsite campsite) {
        this.id = campsite.getId();
        this.campgroundId = campsite.getCampground().getId();
        this.campsiteName = campsite.getCampsiteName();
        this.campsiteDescription = campsite.getCampsiteDescription();
        this.headCount = campsite.getHeadCount();
        this.weekdayPrice = campsite.getWeekdayPrice();
        this.weekendPrice = campsite.getWeekendPrice();
        this.campsiteNumber = campsite.getCampsiteNumber();
        this.campsiteOptionLinks = campsite.getCampsiteOptionLinks();
        this.campsiteImages = campsite.getCampsiteImages();
        this.bookings = campsite.getBookings();
    }
}
