package com.neuedu.planewar.entity;

import com.neuedu.planewar.client.PlaneWarClient;
import com.neuedu.planewar.common.ImageUtil;

import java.awt.*;
import java.util.Random;

public class EnemyPlane extends PlaneWarObject {
    public static Image [] images = new Image[3];
    public static Image [] images2 = new Image[2];
    public static Image [] images3 = new Image[2];
    public static Image [] images4 = new Image[2];
    boolean good = false;
    public int type;
    public int HP;
   static  {
       for(int i = 0;i < images.length ;i++ ){
           images[i] = ImageUtil.images.get("enemyPlane0_"+( i+1 ));
       }
       for (int i = 0; i < images2.length; i++) {
           images2[i] = ImageUtil.images.get("enemyPlane1_"+( i+1 ));
       }
       for (int i = 0; i < images3.length; i++) {
           images3[i] = ImageUtil.images.get("enemyPlane2_"+( i+1 ));
       }
       for (int i = 0; i < images4.length; i++) {
           images4[i] = ImageUtil.images.get("enemyPlane3_"+( i+1 ));
       }
    }
    public EnemyPlane(){}
    public EnemyPlane(PlaneWarClient pwc,int x,int y,int type,int HP){
        this.pwc = pwc;
        this.x = x;
        this .y = y ;
        this.type =type;
        this.HP = HP;
        this.width = images[0].getWidth(null);
        this.height = images[0].getHeight(null);
        this.speed = 2;
    }
    int count = 0;
   static Random r = new Random();
    @Override
    public void draw(Graphics g) {
        switch (type){
            case 0:
                if(count>2){
                    count = 0;
                }
                g.drawImage(images[count],x,y,null);
                break;
            case 1:
                if(count>1){
                    count = 0;
                }
                g.drawImage(images2[count],x,y,null);
                break;
            case 2:
                if(count>1){
                    count = 0;
                }
                g.drawImage(images3[count],x,y,null);
                break;
            case 3:
                if(count>1){
                    count = 0;
                }
                g.drawImage(images4[count],x,y,null);
                break;
        }
//        g.drawImage(img,x,y,null);
        //画图组

        count++;
        move();
        if(this.y > 0 && this.pwc.myPlane.getHP()>0){
            if( !this.pwc.stop ){
                if(r.nextInt(1000)>= 990){
                    shoot();
                }
            }
        }
    }

    @Override
    public void move() {
        this.y += speed;
    }
    public void shoot(){
        //创建子弹对象，并初始化子弹的初始位置
        Bullet bullet = new Bullet(this.pwc,this.x + this.width/2 - 5,this.y -this.height/2,good,1);
        this.pwc.bullets.add(bullet);
    }

}
