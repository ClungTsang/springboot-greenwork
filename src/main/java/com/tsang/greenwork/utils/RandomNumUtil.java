package com.tsang.greenwork.utils;

import java.security.SecureRandom;
import java.util.Random;

public class RandomNumUtil {
    public static StringBuilder PickMachNum(){
        String [] maUid = {
                "ma101","ma102","ma103","ma104","ma105","ma106",
                "ma201","ma202","ma203",
                "ma301","ma302","ma303","ma304","ma305","ma306",
                "ma401","ma402","ma403",
                "ma501","ma502","ma503","ma504","ma505","ma506",
                "ma601","ma602","ma603",
                "ma701","ma702","ma703","ma704","ma705","ma706",
                "ma801","ma802","ma803",
                "ma901","ma902","ma903","ma904","ma905","ma906"
        };
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<maUid.length ; i++){
            int situa = rand.nextInt(2)+1;
            int nrg = rand.nextInt(15)+10;
            sb.append(maUid[i])
                    .append(situa)
                    .append(nrg)
                    .append("0")
                    .append("9999");

        }
            return sb;
    }
    public static StringBuilder PickWsNum(){
        String [] wsUid  = {"ws002","ws003","ws004","ws005","ws006","ws007","ws008","ws009"};
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<wsUid.length;i++ ){
            int pm = rand.nextInt(6)+35;
            int temperature = rand.nextInt(5)+20;
            int humidity = rand.nextInt(15)+13;
            int ele = rand.nextInt(10)+10;
            sb.append(wsUid[i])
                    .append(pm)
                    .append(temperature)
                    .append(humidity)
                    .append(ele);
        }
        return sb;
    }
    public static StringBuilder pickWs1Num(String pm){
        String wsUid = "ws001";
        Random rand = new Random();
                StringBuilder sb = new StringBuilder();
                int temperature = rand.nextInt(5+20);
                int humidity = rand.nextInt(15)+13;
                int ele = rand.nextInt(10)+10;
        sb.append(wsUid)
                .append(pm)
                .append(temperature)
                .append(humidity)
                .append(ele);
        return sb;
    }

    public static StringBuilder PickNormalWsNum(String workshopid){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        int pm = rand.nextInt(5)+20;
        int temperature = rand.nextInt(5)+16;
        int humidity = rand.nextInt(15)+21;
        int ele = rand.nextInt(10)+10;
        sb.append(workshopid)
                .append(pm)
                .append(temperature)
                .append(humidity)
                .append(ele);
        return sb;
    }
}


