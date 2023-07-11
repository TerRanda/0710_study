package com.tj.edu.practice5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class MyRegistry {
    @Id
    private String registryNo;
    private String productNo;
    private String tripNo;
    private String rCdatetime;
    private String rUdatetime;
    private String rOption;
    private String rContent;
    private int rCnt;
    private String userId;
    private String fundYn;
    private String imgSrc;
    private String pStock;
    private String pName;
    private int pPrice;
    private int totalprice;
    private String orderNo;
    private String uName;
    private String fsetprice;
    private String fputprice;
    private String fundingNo;
}
