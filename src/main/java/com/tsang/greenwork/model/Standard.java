package com.tsang.greenwork.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Standard {
    private String name;

    private String low;

    private String hight;

}