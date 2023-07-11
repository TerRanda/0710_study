package com.tj.edu.practice5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Order {
    @Id
    private Long orderNo;
    private String guestNo;
    private String gName;
    private String gPhone;
    private String gAddrNo;
    private String gAddr1;
    private String gAddr2;
    private String userId;
    private String uName;
    private String uPhone;
    private String productNo;
    private LocalDateTime oCdatetime;
    private String oCnt;
    private String oAddrno;
    private String oAddr1;
    private String oAddr2;
    private String oPhone;
    private String oMessage;
    private String oPurchase;
    private String price;
    private String oDeposit;
    private String deliveryNo;
    private String dPrice;
    private String dMessage;
    private String dStatus;
    private String dDate;
    private String dArrived;
    private String pPrice;
    private String pContent;
    private String pName;
    private String kind;
    private String code;
    private String name;
    private String total;
    private String fundYn;
}
