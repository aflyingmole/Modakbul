package com.modakbul.dto.coupon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CouponDto {
    private int id;
    private String couponCode;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int minimumOrderAmount;
    private int couponType;
    private boolean isActive;
}