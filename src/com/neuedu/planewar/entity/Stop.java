package com.neuedu.planewar.entity;

import com.neuedu.planewar.client.PlaneWarClient;
import com.neuedu.planewar.common.ImageUtil;

import java.awt.*;

public class Stop extends PlaneWarObject {
    public Stop(){}
    public Stop(PlaneWarClient pwc,int x,int y){
        this.pwc = pwc;
        this.x = x;
        this.y = y;
        this.img = ImageUtil.images.get("stop");
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img,x,y,null);
    }
}
