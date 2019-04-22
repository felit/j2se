package com.livedrof.guava;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Coupon {
    private Long couponId;
    private Long userId;
    private String name;
    private Integer age;
}
