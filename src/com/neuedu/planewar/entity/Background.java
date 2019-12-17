package com.neuedu.planewar.entity;

import com.neuedu.planewar.client.PlaneWarClient;
import com.neuedu.planewar.common.ImageUtil;

import java.awt.*;

public class Background extends PlaneWarObject {
    static Image img = ImageUtil.images.get("bGround");
    static Image image = ImageUtil.images.get("bGround2");
    public int type;

    public Background(){}
    public Background(PlaneWarClient pwc, int x, int y,int type){
        this.pwc = pwc;
        this.x = x;
        this.y = y;
        this.speed =5;
        this.type = type;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }
    @Override
    public void draw(Graphics g) {
        switch (type){
            case 0:
                g.drawImage(img,x,y,null);
                break;
            case 1:
                g.drawImage(image,x,y,null);
                break;
             default:
                break;
        }

        move();
    }
    @Override
    public void move() {
        y +=speed;
    }
    /**
     * 背景轮播
     */


}
