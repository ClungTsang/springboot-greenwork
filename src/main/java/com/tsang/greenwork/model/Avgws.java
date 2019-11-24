package com.tsang.greenwork.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Avgws {
    private String year1;

    private String month1;

    private String day1;

    private String hour1;

    private String avgTemp;

    private String avgHum;

    private String avgLight;

    private String avgPm1;

    private String avgPm25;

    private String avgPm10;

}