package com.neuedu.planewar.entity;

import com.neuedu.planewar.client.PlaneWarClient;
import com.neuedu.planewar.common.ImageUtil;

import java.awt.*;

public class Explode extends PlaneWarObject {
    public  boolean good;
    public int explode;
    public static Image[] images = new Image[6];
    public static Image[] images2 = new Image[3];
    static {
        for (int i = 0; i < images.length; i++) {
            images[i] = ImageUtil.images.get("explode"+( i+1 ));
        }
        for (int i = 0; i < images2.length; i++) {
            images2[i] = ImageUtil.images.get("boss_"+( i+1 ));
        }
    }
    public Explode(){}
    public Explode(PlaneWarClient pwc,int x,int y,int explode){
        this.pwc = pwc;
        this.x = x;
        this.y = y;
        this.explode =explode;
        this.width = images[0].getWidth(null);
        this.height = images[0].getHeight(null);
    }

    int count = 0;
    @Override
    public void draw(Graphics g) {
        switch (this.explode){
            case 1:
                if(count>5){
                    count = 0;
                    this.pwc.explodes.remove(this);
                    return;
                }
                g.drawImage(images[count],x,y,null);
                break;
            case 2:
                if(count>2){
                    count = 0;
                    this.pwc.explodes.remove(this);
                    return;
                }
                g.drawImage(images2[count],x,y,null);
                break;
        }
        count++;
        //画图组
       /* if(count>5) {
            count = 0;
            this.pwc.explodes.remove(this);
            return;
        }
        g.drawImage(images[count],x,y,null);
        count ++;*/
    }
}
