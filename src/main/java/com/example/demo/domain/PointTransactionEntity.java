package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="PointTransaction")
@Entity
public class PointTransactionEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column
    private String impUid;

    @Column
    private int amount;

    @Column
    @Enumerated(EnumType.STRING) // Enum 으로 저장하기
    private PointTransactionStatus status;

    @ManyToOne
    private UserEntity user;

    @CreatedDate
    private Date createdAt;

}
