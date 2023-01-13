package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="Product")
@Entity(name="Product")
public class ProductEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int price;

    @Column
    @ColumnDefault(value="false")
    private boolean isSoldout;

    @OneToOne
    @JoinColumn
    private ProductSalesLocationEntity productSalesLocation;

    // Many 에 해당하는 테이블(Product)에서는 @JoinColumn 이 생략 가능하다.
    @ManyToOne
    private ProductCategoryEntity productCategory;

    @ManyToOne
    private UserEntity user;

    @JoinTable
    @ManyToMany()
    private Set<ProductTagEntity> productTags;

}
