package com.tsang.greenwork.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Elefee implements Serializable {

    private String rangee;

    private Double fee;

}