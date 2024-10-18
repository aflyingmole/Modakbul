package com.modakbul.repository.member;

import com.modakbul.entity.coupon.Coupon;
import com.modakbul.entity.coupon.MemberCoupon;
import com.modakbul.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberCouponRepository extends JpaRepository<MemberCoupon, Long> {
    boolean existsByMemberAndCoupon(Member member, Coupon coupon);
    MemberCoupon findMemberCouponIdById(Integer id);

    // 쿠폰 ID를 반환하는 메서드
    @Query("SELECT mc.coupon.id FROM MemberCoupon mc WHERE mc.member = :member")
    Integer findCouponIdByMember(@Param("member") Member member);
}