package com.snpc.mybatispostgres.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    private Integer id;
    private String name;
    private Integer labelId;
    private String category;
    private String gender;
    private Boolean currentlyActive;
    private Date created;
    private Date updated;
}
