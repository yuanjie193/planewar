package com.neuedu.planewar.entity;

import com.neuedu.planewar.client.PlaneWarClient;
import com.neuedu.planewar.common.ImageUtil;

import java.awt.*;
import java.util.List;

public class Shield extends PlaneWarObject {
    boolean good = true;
    public int DEF;
    public Shield(){}
    public Shield(PlaneWarClient pwc ,int x,int y){
      this.pwc = pwc;
      this.x = x;
      this.y = y;
      this.img = ImageUtil.images.get("def2");
      this.width = img.getWidth(null);
      this.height = img.getHeight(null);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img,this.pwc.myPlane.x-20,this.pwc.myPlane.y-10,null);
    }
    /**
     * 护盾与敌机相撞
     */
    public boolean hitEnemyPlane(EnemyPlane enemyPlane){
        if(this.good != enemyPlane.good && this.getRectangle().intersects(enemyPlane.getRectangle()) ){
            if(DEF >0){
                DEF -= 10;
            }
            return true;
        }
        return false;
    }
    /**
     * 护盾与整个敌人比较
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
     * 飞机护盾与敌方boss碰撞
     */
    public void hitBoss(Boss boss){
        if(this.good != boss.good && this.getRectangle().intersects(boss.getRectangle()) ){
            if(  DEF >0 ){
                DEF -= 10;
                return;
            }

        }
    }
    /**
     * 护盾与陨石碰撞掉保护
     */
    public void hitMeteorite(Meteorite meteorite){
        if(this.good != meteorite.good && this.getRectangle().intersects(meteorite.getRectangle()) ){
            if(DEF >0){
               DEF -= 10;
               return;
            }
        }
    }
}
