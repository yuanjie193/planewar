package com.neuedu.planewar.entity;

import com.neuedu.planewar.client.PlaneWarClient;
import com.neuedu.planewar.common.ImageUtil;

import java.awt.*;

public class Meteorite extends PlaneWarObject {
    int type;
    boolean good = false;
    public Meteorite(){}
    public Meteorite(PlaneWarClient pwc ,int x,int y,int type){
        this.x =x;
        this.y = y;
        this.speed = 7;
        this.type =type;
        this.img = confirmByType();
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }
    private Image confirmByType() {
        switch (type){
            case 0 :
              this.img = ImageUtil.images.get("yushi");
              break;
            case 1:
                this.img = ImageUtil.images.get("yushi2");
                break;
            case 2:
                this.img = ImageUtil.images.get("yushi3");
                break;
            case 3:
                this.img = ImageUtil.images.get("yushi4");
                break;
            case 4:
                this.img = ImageUtil.images.get("yushi5");
                break;
            case 5:
                this.img = ImageUtil.images.get("yushi6");
                break;
             default:
                 break;
        }
        return img;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img,x,y,null);
        move();
    }
    @Override
    public void move() {
        y +=speed;
    }
}
