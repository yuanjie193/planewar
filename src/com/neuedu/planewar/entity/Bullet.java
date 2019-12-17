package com.neuedu.planewar.entity;

import com.neuedu.planewar.client.PlaneWarClient;
import com.neuedu.planewar.common.ImageUtil;
import com.neuedu.planewar.constant.Constant;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class Bullet extends PlaneWarObject {
    //加上分清敌我双方的变量 true为我方，false为敌方
    public  boolean good;
    public  int hurt;
    public  int bulletType;
    public static int integral;
    static Random r = new Random();
    public Bullet(){}
    public Bullet(PlaneWarClient pwc,int x, int y,boolean good,int bulletType){
        this.x = x;
        this.y = y;
        this.pwc = pwc;
        this.good =good;
        this.bulletType = bulletType;
        if(good){
            switch(pwc.myPlane.level){
                case 0:
                    this.img =ImageUtil.images.get("plane_bullet0");
                    this.hurt =50;
                    break;
                case 1:
                    this.img =ImageUtil.images.get("plane_bullet1");
                    this.hurt = 100;
                    break;
                case 2:
                    this.img =ImageUtil.images.get("plane_bullet2");
                    this.hurt = 200;
                    break;
            }

        }else {
            switch (bulletType){
                case 1:
                    this.img =ImageUtil.images.get("enemyplane_bullet");
                    break;
                case 2:
                    this.img =ImageUtil.images.get("enemyplane_bullet2");
                    break;
                case 3:
                    this.img =ImageUtil.images.get("enemyplane_bullet7");
                    break;
                case 4:
                    this.img =ImageUtil.images.get("enemyplane_bullet7");
                    break;
                case 5:
                    this.img =ImageUtil.images.get("enemyplane_bullet7");
                    break;
                case 6:
                    this.img =ImageUtil.images.get("enemyplane_bullet7");
                    break;
                case 7:
                    this.img =ImageUtil.images.get("enemyplane_bullet7");
                    break;
                default:
                     break;
            }
        }
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
        this.speed = 20;

    }
    public void draw(Graphics g ){
            g.drawImage(img,x,y,null);
            move();

    }

    /**
     * 子弹运动轨迹
     */
    @Override
    public void move() {
        if(good){
            y -= speed;
        }else {
            switch(bulletType){
                case 1:
                    y += speed;
                    break;
                case 2:
                    y +=speed;
                    break;
                case 3:
                    y +=speed;
                    x -= 20;
                    break;
                case 4:
                    y +=speed;
                    x -= 10;
                    break;
                case 5:
                    y +=speed;
                    break;
                case 6:
                    y +=speed;
                    x += 10;
                    break;
                case 7:
                    y +=speed;
                    x += 20;
                    break;
            }

        }
       outOfBound();
    }
    public void move2() {
        if(good){
            y -= speed;
        }else {
            y += speed;
        }
        outOfBound();
    }
    /**
     * 子弹是否越界,越界后移除
     */
    private void outOfBound(){
        if (x < -20 || x > Constant.FRAME_WIDTH + 20 || y < -20 || y > Constant.FRAME_HEIGHT + 20){
            this.pwc.bullets.remove(this);
        }
    }
    /**
     * 子弹击打飞机，默认没打到,一颗子弹打一个飞机
     */
    public boolean hitEnemyPlane(EnemyPlane enemyPlane){
        if(this.good != enemyPlane.good && this.getRectangle().intersects(enemyPlane.getRectangle()) ){
            //打到之后 该enemyPlane死掉，同时子弹销毁
            if(enemyPlane.HP>0){
                enemyPlane.HP -= hurt;
            }else {
                this.pwc.enemyPlanes.remove(enemyPlane);
                integral +=100;
                //爆炸
                Explode e = new Explode(pwc,enemyPlane.x,enemyPlane.y,1);
                this.pwc.explodes.add(e);
                if(r.nextInt(100)>80){
                    Item item = new Item(pwc,enemyPlane.x,enemyPlane.y,r.nextInt(3));
                    this.pwc.items.add(item);
                }

            }
            this.pwc.bullets.remove(this);
            return true;
        }
        return false;
    }
    /**
     * 一颗子弹与整个敌人比较
     */
    public boolean hitEnemyPlane(List<EnemyPlane> enemyPlanes){
        for (int i = 0; i < enemyPlanes.size(); i++) {
            EnemyPlane ep = enemyPlanes.get(i);
            if(hitEnemyPlane(ep)){
                return true;
            }
        }
        return false;
    }
    /**
     * 敌方子弹击打我方飞机，
     */
    public boolean hitPlane(Plane myPlane){
           if(this.good != myPlane.good && this.getRectangle().intersects(myPlane.getRectangle()) ){
               //打到我方时，掉血
               if(myPlane.getHP()>0 && this.pwc.shield.DEF<=0){
                   myPlane.setHP(myPlane.getHP() -10);
               }
               if(myPlane.getHP()==0){
                   Explode e = new Explode(pwc,myPlane.x,myPlane.y,1);
                   this.pwc.explodes.add(e);
               }
               //爆炸
               this.pwc.bullets.remove(this);
               return true;
           }

        return false;
    }
    /**
     * 敌方子弹击打我方飞机护盾，
     */
    public boolean hitShield(Shield shield){
        if(this.good != shield.good && this.getRectangle().intersects(shield.getRectangle()) ){
            //打到我方时，护盾防御降低
            if(shield.DEF>0){
                shield.DEF -= 10;
            }
            return true;
        }

        return false;
    }

    /**
     * 我方子弹击打boss
     */
    public void hitboss(Boss boss){
            if(this.good != boss.good && this.getRectangle().intersects(boss.getRectangle()) ){
                //打到boss时，掉血
                if(boss.getHP()>0){
                    boss.setHP(boss.getHP() - 10);
                }
                if(boss.getHP()==0){
                    integral += 100000;
                    Explode e = new Explode(pwc,boss.x,boss.y,2);
                    this.pwc.explodes.add(e);
                }
                    this.pwc.bullets.remove(this);
                }
            }



}
