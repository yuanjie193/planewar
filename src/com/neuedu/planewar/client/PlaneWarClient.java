package com.neuedu.planewar.client;

import com.neuedu.planewar.common.CommonFrame;
import com.neuedu.planewar.common.MusicUtil;
import com.neuedu.planewar.constant.Constant;
import com.neuedu.planewar.entity.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlaneWarClient extends CommonFrame {
    Random r = new Random();
    /**
     *初始化
     */
    public StartGame sg = new StartGame(this,0,0);
    public GameOver gameOver = new GameOver(this,0,0);
    public Plane myPlane = new Plane(this,Constant.FRAME_WIDTH/2-50,Constant.FRAME_HEIGHT-150);
    public Boss boss =new Boss(this,Constant.FRAME_WIDTH/4,-800);
    public Background bg1 = new Background(this,0,0,0);
    public Background bg2 = new Background(this,0, bg1.y - bg1.height,1);
    public Danger dg = new Danger(this,Constant.FRAME_WIDTH/2-100,100);
    public Shield shield = new Shield(this,0,0);
    public Stop stop2 = new Stop(this,0,0);
    /**
     * 陨石
     */
    public Meteorite mt = new Meteorite(this,(int)(Math.random()*Constant.FRAME_WIDTH),(int)(Math.random()*Constant.FRAME_HEIGHT),r.nextInt(6));
    public Meteorite mt2 = new Meteorite(this,(int)(Math.random()*Constant.FRAME_WIDTH),(int)(Math.random()*Constant.FRAME_HEIGHT),r.nextInt(6));
    public Meteorite mt3 = new Meteorite(this,(int)(Math.random()*Constant.FRAME_WIDTH),(int)(Math.random()*Constant.FRAME_HEIGHT),r.nextInt(6));
    /**
     * 雪花
     */
    public Snow s = new Snow(this,(int)(Math.random()*Constant.FRAME_WIDTH),(int)(Math.random()*Constant.FRAME_HEIGHT));
    public Snow s2 = new Snow(this,(int)(Math.random()*Constant.FRAME_WIDTH),(int)(Math.random()*Constant.FRAME_HEIGHT));
    public Snow s3 = new Snow(this,(int)(Math.random()*Constant.FRAME_WIDTH),(int)(Math.random()*Constant.FRAME_HEIGHT));
    public Snow s4 = new Snow(this,(int)(Math.random()*Constant.FRAME_WIDTH),(int)(Math.random()*Constant.FRAME_HEIGHT));
    public Snow s5 = new Snow(this,(int)(Math.random()*Constant.FRAME_WIDTH),(int)(Math.random()*Constant.FRAME_HEIGHT));
    /**
     * 创建子弹容器
     */
    public List<Bullet> bullets = new ArrayList<>();
    public List<EnemyPlane> enemyPlanes = new ArrayList<>();
    public List <Explode> explodes = new ArrayList<>();
    public List<Item> items = new ArrayList<>();

    /**
     * 画敌机并进行运动
     */
    /*{
        int num = 0;
        while (num < 20){
            int n = (int)r.nextInt(1000);
            if( n<=1000 && n >800 ){
                for(int i = 0 ;i < 7; i++){
                    EnemyPlane enemyPlane = new EnemyPlane(this,Constant.FRAME_WIDTH/10+(i * 70) ,-Constant.FRAME_HEIGHT/10+(i * 50)-(num *70) ,r.nextInt(3));
                    enemyPlanes.add(enemyPlane);
                }
            }else if(n<=800 && n >600 ){
                for(int i = 0 ;i < 7; i++){
                    EnemyPlane enemyPlane = new EnemyPlane(this,Constant.FRAME_WIDTH/10+(i * 70) ,Constant.FRAME_HEIGHT/10-(i * 50)-(num *70),r.nextInt(3));
                    enemyPlanes.add(enemyPlane);
                }
            }else if(n<=600 && n >400){
                for(int i = 0 ;i < 5; i++){
                    EnemyPlane enemyPlane = new EnemyPlane(this,Constant.FRAME_WIDTH/5+(i * 70) ,Constant.FRAME_HEIGHT/10-(num *70),r.nextInt(3));
                    enemyPlanes.add(enemyPlane);
                }
            }else if(n<=400 && n >200){
                for(int i = 0 ;i < 5; i++){
                    // EnemyPlane enemyPlane = new EnemyPlane(this,Constant.FRAME_WIDTH/5*(int)Math.cos(Math.PI/4) ,Constant.FRAME_HEIGHT/5*(int)Math.sin(Math.PI/4),r.nextInt(2));
                    EnemyPlane enemyPlane = new EnemyPlane(this,Constant.FRAME_WIDTH/5+(i*70),-Constant.FRAME_HEIGHT/10+(i*20)+(num *70),r.nextInt(3));
                    enemyPlanes.add(enemyPlane);
                }
            }else {
                for(int i = 0 ;i < 5; i++){
                    // EnemyPlane enemyPlane = new EnemyPlane(this,Constant.FRAME_WIDTH/5*(int)Math.cos(Math.PI/4) ,Constant.FRAME_HEIGHT/5*(int)Math.sin(Math.PI/4),r.nextInt(2));
                    EnemyPlane enemyPlane = new EnemyPlane(this,Constant.FRAME_WIDTH/5-(i*70),-Constant.FRAME_HEIGHT/10+(i*20)-(num *70),r.nextInt(3));
                    enemyPlanes.add(enemyPlane);
                }
            }

        num++;
        }
    }*/
    {
        int num = 0;
        while (num < 5){
            for(int i = 0 ;i < 7; i++){
                EnemyPlane enemyPlane = new EnemyPlane(this,(int)(Math.random()*Constant.FRAME_WIDTH/3)+(i * 70) ,(int)(Math.random()*Constant.FRAME_HEIGHT/2)-(i * 50)-(num *150) ,r.nextInt(4),200);
                enemyPlanes.add(enemyPlane);
            }
            for(int i = 0 ;i < 7; i++){
                EnemyPlane enemyPlane = new EnemyPlane(this,(int)(Math.random()*Constant.FRAME_WIDTH/3)+(i * 70)  ,-(int)(Math.random()*Constant.FRAME_HEIGHT)-(i * 50)-(num *150),r.nextInt(4),300);
                enemyPlanes.add(enemyPlane);
            }
            num++;
        }
    }
    public void loadFrame(String title){
        super.loadFrame(title);
        //添加键盘监听器
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                myPlane.keyPressed(e);
                keyPressed2(e);
            }
            @Override
            public void keyReleased(KeyEvent e) {
                myPlane.keyReleased(e);
                keyReleased2(e);
            }
        });

        new MusicUtil("com/neuedu/planewar/video/bg.mp3",true).start();
    }
    public void paint(Graphics g){
       if (!over && !start){
            sg.draw(g);
        }
        if (start && !over){

        /**
         * 背景轮播
         */
        bg1.draw(g);
        bg2.draw(g);
        while (bg1.y >  bg1.height){
            bg1.y = bg1.y - 2*bg1.y+3;
            bg1.draw(g);
        }
        while (bg2.y >  bg2.height){
            bg2.y = bg2.y - 2*bg2.y+3;
            bg2.draw(g);
        }
          //陨石随机降落
            mt.draw(g);
            mt2.draw(g);
            mt3.draw(g);
            while (mt.y>Constant.FRAME_HEIGHT){
                mt.y = 0;
                mt.x =(int)(Math.random()*Constant.FRAME_WIDTH);
            }
            while (mt2.y>Constant.FRAME_HEIGHT){
                mt2.y = 0;
                mt2.x =(int)(Math.random()*Constant.FRAME_WIDTH);
            }
            while (mt3.y>Constant.FRAME_HEIGHT){
                mt3.y = 0;
                mt3.x =(int)(Math.random()*Constant.FRAME_WIDTH);
            }
            //雪花随机降落
//            s.draw(g);
//            s2.draw(g);
//            s3.draw(g);
//            s4.draw(g);
//            while (s.y>Constant.FRAME_HEIGHT){
//                s.y = 0;
//                s.x = (int)(Math.random()*Constant.FRAME_WIDTH);
//            }
//            while (s2.y>Constant.FRAME_HEIGHT){
//                s2.y = 0;
//                s2.x =(int)(Math.random()*Constant.FRAME_WIDTH);
//            }
//            while (s3.y>Constant.FRAME_HEIGHT){
//                s3.y = 0;
//                s3.x = (int)(Math.random()*Constant.FRAME_WIDTH);
//            }
//            while (s4.y>Constant.FRAME_HEIGHT){
//                s4.y = 0;
//                s4.x = (int)(Math.random()*Constant.FRAME_WIDTH);
//            }
//            while (s5.y>Constant.FRAME_HEIGHT){
//                s5.y = 0;
//                s5.x = (int)(Math.random()*Constant.FRAME_WIDTH);
//            }
       /* if(myPlane.planeLife()){
            myPlane.draw(g);
        }else {
            Font f = g.getFont();
            g.setFont(new Font("微软雅黑",Font.BOLD,30));
            g.drawString("游戏结束",300,300);
            g.setFont(f);
            return;
        }*/

       //当不选择复活并且飞机血量为零且已爆炸后，进入结束页面
        if (resurrection2 == 1 && explodes.size() <= 0 && myPlane.getHP() <=0){
            start = false;
            over = true;
        }
        if (explodes.size() <= 0 && boss.getHP() <=0){
             start = false;
              over = true;
        }
         //飞机与敌机相撞
            myPlane.hitEnemyPlane(enemyPlanes);
         //飞机与敌方boss相撞
            myPlane.hitboss(boss);
            //飞机与陨石相撞
            myPlane.hitMeteorite(mt);
            myPlane.hitMeteorite(mt2);
            myPlane.hitMeteorite(mt3);
            //护盾与敌机相撞
            shield.hitEnemyPlane(enemyPlanes);
            //护盾与敌方boss相撞
            shield.hitBoss(boss);
            //飞机与陨石相撞
            shield.hitMeteorite(mt);
            shield.hitMeteorite(mt2);
            shield.hitMeteorite(mt3);
            //画出子弹
        for (int i = 0; i < bullets.size(); i++) {
           Bullet b =  bullets.get(i);
            b.draw(g);
            //子弹击打敌人
            b.hitEnemyPlane(enemyPlanes);
            b.hitPlane(myPlane);
            b.hitboss(boss);
            b.hitShield(shield);
        }
        //画出敌方飞机
        for (int i = 0; i < enemyPlanes.size(); i++) {
                EnemyPlane e = enemyPlanes.get(i);
                e.draw(g);
                if(e.y>Constant.FRAME_HEIGHT){
                    e.y = 0;
                    e.x = (int)(Math.random()* Constant.FRAME_WIDTH);
                }
            }
         // 画出敌方道具
        for (int i = 0; i < items.size(); i++) {
           Item item =  items.get(i);
           item.draw(g);
        }
        //我方飞机吃道具
        myPlane.eatItem(items);
        //boss出场
        if(enemyPlanes.size() < 5){
              dg.draw(g);
            if(boss.boosLife()&& dg.y>Constant.FRAME_HEIGHT){
                boss.draw(g);
            }
        }

        /**
         * 把爆炸容器画出来
         */
        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).draw(g);
        }

            //画出我方飞机
            if(myPlane.planeLife()){
                myPlane.draw(g);
            }
            //画飞机护盾
            if(shield.DEF>0){
                shield.draw(g);
            }
            //画面暂停
            if(stop){
                stop2.draw(g);
                mt.speed = 0;
                mt2.speed = 0;
                mt3.speed = 0;
                boss.speed = 0;
                bg1.speed = 0;
                bg2.speed = 0;
                for (int i = 0; i < enemyPlanes.size(); i++) {
                    enemyPlanes.get(i).speed =0;
                }
            } else{
                    boss.speed = 10;
                    mt.speed = 7;
                    mt2.speed = 7;
                    mt3.speed = 7;
                    bg1.speed = 5;
                    bg2.speed = 5;
                    for (int i = 0; i < enemyPlanes.size(); i++) {
                        enemyPlanes.get(i).speed =2;
                    }
            }
            //复活飞机
            if(myPlane.getHP()<=0 && !stop){
                myPlane.draw2(g);
                mt.speed = 0;
                mt2.speed = 0;
                mt3.speed = 0;
                boss.speed = 0;
                bg1.speed = 0;
                bg2.speed = 0;
                for (int i = 0; i < enemyPlanes.size(); i++) {
                    enemyPlanes.get(i).speed =0;
                }
                //选择复活
                if(resurrection == 2){
                    myPlane.setHP((int)myPlane.maxHP);
                    mt.speed = 7;
                    mt2.speed = 7;
                    mt3.speed = 7;
                    boss.speed = 10;
                    bg1.speed = 5;
                    bg2.speed = 5;
                    for (int i = 0; i < enemyPlanes.size(); i++) {
                        enemyPlanes.get(i).speed =2;
                    }
                }
            }
       /* Font f = g.getFont();
        g.setFont(new Font("微软雅黑",Font.BOLD,30));
        g.drawString("子弹容器的大小"+ bullets.size(),100,100);
        g.drawString("飞机血量"+ myPlane.HP,100,200);
        g.drawString("飞机护盾"+ shield.DEF,100,300);
        g.drawString("武器等级"+ myPlane.level,100,400);
        g.drawString("boss血量"+ boss.getHP(),100,500);
        g.drawString("积分"+ Bullet.integral ,100,550);
        g.setFont(f);*/
        }
        if(over && !start){
            if(myPlane.getHP()<= 0 ){
                gameOver.type = 1;
            }
            if(boss.getHP()<= 0 ){
                gameOver.type = 2;
            }
           gameOver.draw(g);
        }
    }

    /**
     * 控制游戏开始和结束
     * @param args
     */
    public  boolean start,over;
    //是否复活
    public int resurrection = 1;
    public int resurrection2 ;
    //是否暂停
    public  boolean stop;
    public void keyPressed2(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_H:
                start = true;
                break;
            case KeyEvent.VK_O:
                over = true;
                break;
            case KeyEvent.VK_K:
                resurrection = 2;
                break;
            case KeyEvent.VK_L:
                resurrection2 = 1;
                break;
            case KeyEvent.VK_SPACE:
                stop =  !stop;
                break;
            default:
                 break;

        }
    }
    public void keyReleased2(KeyEvent e){
        switch (e.getKeyCode()) {
            case KeyEvent.VK_K:
                resurrection = 1;
                break;
        }
    }


    public static void main(String[] args) {
        new PlaneWarClient().loadFrame("第一个窗口");
    }
}
