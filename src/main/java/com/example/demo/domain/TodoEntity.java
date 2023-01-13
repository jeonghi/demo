package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// 애는 Entity 이자, Model 역할을 함께하는 데이터를 담는 클래스임.
@Builder // 빌더를 이용하면 생성자 매개변수의 순서를 기억할 필요가 없다
@NoArgsConstructor // 매개변수가 없는 생성자 구현 . 자바 클래스를 엔티티로 정의할 때 꼭 필요함.
@AllArgsConstructor
@Data // 멤버 변수들의 Getter/ Setter 메서드를 구현 . 자바 클래스를 엔티티로 정의할 때 꼭 필요함.
@Entity(name = "Todo") //
@Table(name = "Todo")
public class TodoEntity {

    @Id // PK 설정 . 자바 클래스를 엔티티로 정의할 때 꼭 필요함.
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String userId;
    private String title;
    private boolean done;
}