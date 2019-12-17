package com.neuedu.planewar.entity;

import com.neuedu.planewar.client.PlaneWarClient;
import com.neuedu.planewar.common.ImageUtil;
import com.neuedu.planewar.constant.Constant;

import java.awt.*;
import java.util.List;

public class Item extends PlaneWarObject {
    double theta = Math.random() * (Math.PI * 2);
    int type;
    boolean good = true;
    public Item() {}

    public Item(PlaneWarClient pwc, int x, int y,int type) {
        this.pwc = pwc;
        this.x = x;
        this.y = y;
        this.type = type;
        switch (type){
            case 0:
                this.img = ImageUtil.images.get("item_HP");
                break;
            case 1:
                this.img = ImageUtil.images.get("def");
                break;
            case 2:
                this.img = ImageUtil.images.get("hurt");
                break;
            default:
                 break;
        }
        this.width = img.getWidth(null);
        this.height = img.getWidth(null);
        this.speed = 5 ;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img,x,y,null);
        move();
    }
    @Override
    public void move() {
        x += (int)(speed * Math.cos(theta));
        y += (int)(speed * Math.sin(theta));
        //弹上下边
        if(y <= 30 || y >= Constant.FRAME_HEIGHT - this.height){
            theta = -theta;
        }
        if( x <= 30 || x >= Constant.FRAME_WIDTH - this.width){
            theta = Math.PI - theta;
        }
    }

}
