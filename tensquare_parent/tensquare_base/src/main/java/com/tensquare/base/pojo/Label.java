package com.tensquare.base.pojo;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_label")
public class Label{
    @Id
    private String id;
    private String labelname;   // 标签名称
    private String state;   // 状态
    private Long count; // 使用数量
    private Long fans;  // 关注数
    private String recommend;   // 是否推荐

}
