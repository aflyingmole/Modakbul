package com.modakbul.entity.member;

import com.modakbul.entity.booking.Booking;
import com.modakbul.entity.booking.Review;
import com.modakbul.entity.campground.Campground;
import com.modakbul.entity.chat.ChatMessage;
import com.modakbul.entity.chat.ChatRoom;
import com.modakbul.entity.coupon.MemberCoupon;
import com.modakbul.entity.freeboard.Freeboard;
import com.modakbul.entity.freeboard.FreeboardComment;
import com.modakbul.entity.payment.Membership;
import com.modakbul.entity.payment.Payment;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true) // 유니크 제약 조건 설정
    private String userId;
    private String password;
    private String userName;
    private String phone;
    private String mail;
    private String role;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private String provider; // "kakao", "naver", "google"

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<ChatMessage> chatMessages;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<ChatRoom> chatRooms;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Payment> payments;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberCoupon> memberCoupons;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Freeboard> freeboards;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<FreeboardComment> freeboardComments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "membership_id") // 외래 키로 사용할 membership_id
    private Membership membership; // Membership 엔티티와의 관계 설정

    public Member(String userId) {
        this.userId = userId;
    }
}
