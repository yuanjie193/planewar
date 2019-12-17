package com.neuedu.planewar.entity;

import com.neuedu.planewar.client.PlaneWarClient;
import com.neuedu.planewar.common.ImageUtil;
import com.neuedu.planewar.constant.Constant;

import java.awt.*;
import java.util.Random;

public class Boss extends PlaneWarObject {
    public static Image[] boss = new Image[3];
    boolean good = false;
    double theta = Math.PI / 4;
    public int HP = 10000;
    public Double maxHP =(double)HP;
    Random r = new Random();
    static {
        for (int i = 0; i < boss.length; i++) {
            boss[i] = ImageUtil.images.get("boss0_"+ ( i+1 ));
        }
    }
    public Boss(){ }
    public Boss(PlaneWarClient pwc,int x,int y){
        this.pwc = pwc;
        this.x =x ;
        this.y = y;
        this.speed = 10;
        this.width = boss[0].getWidth(null);
        this.height = boss[0].getHeight(null);
    }

    public int getHP() {
        return this.HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
    public boolean boosLife(){
        if(this.getHP()> 0){
            return true;
        }
        return false;
    }

    int count = 0;
    @Override
    public void draw(Graphics g) {
        //画出动图boss
        if(count >2){
            count = 0;
        }
        g.drawImage(boss[count],x,y,null);
        count++;
        move();
        if(this.pwc.myPlane.getHP()>0 && !this.pwc.stop){
            if(r.nextInt(1000)>= 900){
                shoot();
            }
        if(r.nextInt(1000)>= 800){
            shoot2();
            shoot3();
            shoot4();
            shoot5();
            shoot6();
          }
        }
        bbb.draw(g);
        Image image = ImageUtil.images.get("bossName");
        g.drawImage(image,x-40,y-10,null);
    }

    @Override
    public void move() {
        if(y<180){
            y += speed;
        }
        x += (int)(speed * Math.cos(theta));
        //弹上下边
        if( x <= 30 || x >= Constant.FRAME_WIDTH - this.width){
            theta = Math.PI - theta;
        }
    }
    public void shoot(){
        Bullet bullet = new Bullet(this.pwc,this.x+this.width/2-40,this.y+this.height-100,good,2);
        this.pwc.bullets.add(bullet);
    }
    public void shoot2(){
        Bullet bullet = new Bullet(this.pwc,this.x+this.width/2-20,this.y+this.height-100,good,3);
        this.pwc.bullets.add(bullet);
    }
    public void shoot3(){
        Bullet bullet = new Bullet(this.pwc,this.x+this.width/2,this.y+this.height-100,good,4);
        this.pwc.bullets.add(bullet);
    }
    public void shoot4(){
        Bullet bullet = new Bullet(this.pwc,this.x+this.width/2+20,this.y+this.height-100,good,5);
        this.pwc.bullets.add(bullet);
    }
    public void shoot5(){
        Bullet bullet = new Bullet(this.pwc,this.x+this.width/2+40,this.y+this.height-100,good,6);
        this.pwc.bullets.add(bullet);
    }
    public void shoot6(){
        Bullet bullet = new Bullet(this.pwc,this.x+this.width/2-20,this.y+this.height-100,good,7);
        this.pwc.bullets.add(bullet);
    }
    public BossBloodBar bbb = new BossBloodBar();
    /**
     * boss的血条
     */
    class BossBloodBar {
        public void draw(Graphics g){
            Color c = g.getColor();
            //进行判断不同血量血量条变色
            if( HP > ( maxHP * 0.7 ) && HP <= maxHP){
                g.setColor(Color.YELLOW);
            }else if(HP > (maxHP * 0.3) && HP <= (maxHP * 0.7)){
                g.setColor(Color.cyan);
            }else {
                g.setColor(Color.RED);
            }
            g.drawRect(x+60,y,200,10);
            g.fillRect(x+60,y,(int)(200 * (HP / maxHP)),10);
            g.setColor(c);
        }
    }
}
