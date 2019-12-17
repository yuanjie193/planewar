package com.neuedu.planewar.entity;

import com.neuedu.planewar.client.PlaneWarClient;
import com.neuedu.planewar.common.ImageUtil;

import java.awt.*;

public class Danger extends  PlaneWarObject {
    public Danger(){}
    public Danger(PlaneWarClient pwc,int x,int y){
        this.pwc = pwc;
        this.x = x;
        this.y = y;
        this.img = ImageUtil.images.get("dg");
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
        this.speed = 8;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img,x,y,null);
        move();
    }

    @Override
    public void move() {
        y += speed;
    }
}
