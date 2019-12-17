package com.neuedu.planewar.entity;

import com.neuedu.planewar.client.PlaneWarClient;
import com.neuedu.planewar.common.ImageUtil;

import java.awt.*;

public class Snow extends PlaneWarObject {

    static Image [] imgs = new Image[3];
    static {
        for(int i = 0;i < 3 ;i++ ){
            imgs[i]=ImageUtil.images.get("snow"+(i+1));
        }
    }
    public Snow(){}
    public Snow(PlaneWarClient pwc,int x,int y){
        this.pwc =pwc;
        this.x = x;
        this.y = y;
        this.speed= 4;
        this.width = imgs[0].getWidth(null);
        this.height = imgs[0].getHeight(null);
    }
    int count = 0;
    @Override
    public void draw(Graphics g) {
        if(count>2){
            count=0;
        }
        g.drawImage(imgs[count],x,y,null);
        count++;
        move();
    }

    @Override
    public void move() {
        y += speed;
    }
}
