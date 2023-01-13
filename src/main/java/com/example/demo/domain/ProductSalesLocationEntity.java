package com.example.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="ProductSalesLocation")
@Entity(name="ProductSalesLocation")
public class ProductSalesLocationEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column
    private String address;

    @Column
    private String addressDetail;

    @Column
    private int lat;

    @Column
    private int lng;

    @Column
    private Date meetingTime;
}
