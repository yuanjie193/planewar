package com.neuedu.planewar.entity;

import com.neuedu.planewar.client.PlaneWarClient;
import com.neuedu.planewar.common.FrameUtil;
import com.neuedu.planewar.common.ImageUtil;
import com.neuedu.planewar.constant.Constant;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class Plane extends PlaneWarObject {
//    把图片放入数组
    static Image [] imgs = new Image[2];
    boolean good = true;
    /**
     * 飞机血量
     */
    public int HP = 1000;
    public double maxHP = HP;
//    public int DEF;
    public int level;
    public int getHP() {
        return HP;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
    static {
            for(int i = 0;i < imgs.length ;i++ ){
                imgs[i]=ImageUtil.images.get("myplane0"+( i+1 ));
            }
    }
    public Plane(){}
    //有参构造方法
    public Plane(PlaneWarClient pwc,int x,int y){
        this.x = x;
        this.y = y;
        this.pwc =pwc;
        this.width =imgs[1].getWidth(null);
        this.height = imgs[1].getHeight(null);
        this.speed = 10;
    }
    /*//重载有参构造方法
    public Plane(int x ,int y, String imgpath){
        this(x,y);
//        this.img =
    }*/

    /**
     * 飞机的是否存在,true存在
     */
    public boolean planeLife(){
        if(this.pwc.myPlane.getHP() >= 0 ){
            return true;
        }
        return false;
    }
    public void move(){
        if(left && !this.pwc.stop){ x -= speed; }
        if(up &&!this.pwc.stop){ y -= speed; }
        if(right &&!this.pwc.stop){x += speed; }
        if(down &&!this.pwc.stop){y += speed;}
    }

    int count = 0;
    public void draw(Graphics g){
//        g.drawImage(img,x,y,null);
        //画图组
        if(count>1){
            count = 0;
        }
        g.drawImage(imgs[count],x,y,null);
        count ++;
        move();
        outOfBounds();
        if(shoot && !this.pwc.stop && HP>0){
            //每当按下J 键 创建一枚子弹并放入客户端存存放子弹的容器中
            shoot();
        }
        bb.draw(g);
       // 画飞机图标：血量、护盾值、积分、子弹等级
        Image img = ImageUtil.images.get("planeIcon1");
        Image img2 = ImageUtil.images.get("planeIcon2");
        Image img3 = ImageUtil.images.get("planeIcon3");
        Image img4 = ImageUtil.images.get("planeIcon4");
        g.drawImage(img,30,45,null);
        g.drawImage(img2,30,80,null);
        g.drawImage(img3,30,115,null);
        g.drawImage(img4,30,150,null);
        Color c2 = g.getColor();
        Font f = g.getFont();
        g.setColor(Color.WHITE);
        g.setFont(new Font("华文彩云",Font.BOLD,26));
        g.drawString(""+this.pwc.myPlane.level,70,103);
        g.drawString(""+ Bullet.integral,70,137);
        g.drawString(""+ this.pwc.shield.DEF,70,172);
        g.setColor(c2);
        g.setFont(f);
    }

    /**
     * 加复活图片
     */
    public void draw2(Graphics g){
        Image image = ImageUtil.images.get("fh");
        g.drawImage(image,(Constant.FRAME_WIDTH-image.getWidth(null))/2,(Constant.FRAME_HEIGHT-image.getHeight(null))/2,null);
    }
    public BloodBar bb = new BloodBar();
    /**
     * 血条的内部类：不让外部的其它类直接访问,只在本外部类中使用
     * 内部类可以直接访问该外部类的所有成员方法和属性——直接用
     */
    class BloodBar {
        public void draw(Graphics g){
            Color c =g.getColor();
        //进行判断不同血量血量条变色
            if(HP > (maxHP * 0.7) && HP <= maxHP){
                g.setColor(Color.ORANGE);
            }else if(HP > (maxHP * 0.3) && HP <= (maxHP * 0.7)){
                g.setColor(Color.YELLOW);
            }else {
                g.setColor(Color.RED);
            }
            g.drawRect(70,50,120,12);
            g.fillRect(70,50,(int)(120 * (HP / maxHP)),12);
            g.setColor(c);
        }
    }
    /**
     * 定义成员变量，飞机的前后左右和攻击键
     */
    public boolean left,right,up,down,shoot;
    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_A :
                left = true;
                break;
            case KeyEvent.VK_W :
                up = true;
                break;
            case KeyEvent.VK_D :
                right = true;
                break;
            case KeyEvent.VK_S :
                down = true;
                break;
            case KeyEvent.VK_J :
                shoot = true;
                break;
        }
    }
    public void keyReleased(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_A :
                left = false;
                break;
            case KeyEvent.VK_W :
                up = false;
                break;
            case KeyEvent.VK_D :
                right = false;
                break;
            case KeyEvent.VK_S :
                down = false;
                break;
            case KeyEvent.VK_J :
                shoot = false;
                break;
        }
    }
    /**
     * 控制飞机范围
     */
    private void outOfBounds(){
        if(x < 0 ){
            x = 0;
        }
        if(y < 30 ){
            y = 30;
        }
        if(x >Constant.FRAME_WIDTH - this.width){
            x = Constant.FRAME_WIDTH - this.width;
        }
        if(y > Constant.FRAME_HEIGHT - this.height){
            y = Constant.FRAME_HEIGHT - this.height;
        }
    }
    /**
     * 发子弹的方法
     */
    public void shoot(){
        //创建子弹对象，并初始化子弹的初始位置
        Bullet bullet = new Bullet(this.pwc,this.x + this.width/2 - 45,this.y -this.height-20,good,1);
//        Bullet bullet2 = new Bullet(this.x + 30,this.y + 10);
        this.pwc.bullets.add(bullet);
//        this.pwc.bullets.add(bullet2);
    }
    /**
     * 吃道具的方法
     */
    public boolean eatItem(Item item){
        if(this.getRectangle().intersects(item.getRectangle())){
            switch (item.type){
                //加生命
                case 0:
                    this.HP += 100;
                    if(this.HP >= this.maxHP){
                        this.HP = (int)this.maxHP;
                    }
                    break;
                //加防御
                case 1:
                    this.pwc.shield.DEF +=100;
                    if(this.pwc.shield.DEF  >= 500){
                        this.pwc.shield.DEF  = 500;
                    }
                    break;
               //加攻击力
                case 2:
                    this.level += 1;
                    if(this.level>=2){
                        this.level = 2;
                    }
                    break;
                 default:
                     break;
            }
            this.pwc.items.remove(item);
            return true;
        }
        return false;
    }
    public boolean eatItem(List<Item> items){
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if(eatItem(item)){
                return true;
            }
        }
        return false;
    }
    /**
     * 我方飞机与敌机碰撞
     */
    public boolean hitEnemyPlane(EnemyPlane enemyPlane){
        if(this.good != enemyPlane.good && this.getRectangle().intersects(enemyPlane.getRectangle()) ){
            if(this.getHP() >0 && this.pwc.shield.DEF<=0){
                this.setHP(this.getHP()-10);
            }

            return true;
        }
        return false;
    }
    /**
     * 自己与整个敌人比较
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
     * 我方飞机与敌方boss碰撞
     */
    public void hitboss(Boss boss){
        if(this.good != boss.good && this.getRectangle().intersects(boss.getRectangle()) ){
            if(this.getHP() >0 && this.pwc.shield.DEF <= 0){
                this.setHP(this.getHP()-10);
            }

        }

    }
    /**
     * 我方与陨石碰撞掉血
     */
    public void hitMeteorite(Meteorite meteorite){
        if(this.good != meteorite.good && this.getRectangle().intersects(meteorite.getRectangle()) ){
            if(this.getHP() >0 && this.pwc.shield.DEF<=0){
                this.setHP(this.getHP()-10);
            }
        }
    }
}
