package com.neuedu.planewar.common;

import com.neuedu.planewar.constant.Constant;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 专门加载项目中的图片
 */
public class ImageUtil {
    /**
     * 使用Map<KEY,VALUE>容器装图片</>
     */
    public static Map<String,Image> images = new HashMap<>();
    static {
        //我方飞机的图片
        for(int i = 0; i < 2 ; i++ ){
     // images.put("myplane0"+( i+1 ),FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/plane/myplane0"+( i+1 )+".png"));
       images.put("myplane0"+( i+1 ),FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/plane/Sehero"+ i +".png"));
        }
        //我方飞机的图标
        images.put("planeIcon1",FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/plane/icon/tb3.png"));
        images.put("planeIcon2",FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/plane/icon/tb4.png"));
        images.put("planeIcon3",FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/plane/icon/tb5.png"));
        images.put("planeIcon4",FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/plane/icon/tb6.png"));

        /**
         * 我方飞机的子弹
         */
        images.put("plane_bullet0",FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/bullet/mybullets/bullet2_1.png"));
        images.put("plane_bullet1",FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/bullet/mybullets/bullet2_3.png"));
        images.put("plane_bullet2",FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/bullet/mybullets/bullet2_5.png"));
        /**
         * 敌方的飞机
         */
        for(int i = 0 ; i < 3 ;i++ ){
            images.put("enemyPlane0_"+( i+1 ),FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/enemyplane/enemy3_"+( i+1 )+".png"));
        }
        for(int i = 0 ; i < 2 ;i++ ){
            images.put("enemyPlane1_"+( i+1 ),FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/enemyplane/enemy10_"+( i+1 )+".png"));
        }
        for(int i = 0 ; i < 2 ;i++ ){
            images.put("enemyPlane2_"+( i+1 ),FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/enemyplane/enemy2_"+( i+1 )+".png"));
        }
        for(int i = 0 ; i < 2 ;i++ ){
            images.put("enemyPlane3_"+( i+1 ),FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/enemyplane/enemy9_"+( i+1 )+".png"));
        }
        /**
         * 敌方booss
         */
        for (int i = 0; i < 3; i++) {
            images.put("boss0_"+(i+1),FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/enemyplane/boss/boss2_"+ (i+1) +".png"));
        }
        /**
         * boss名
         */
        images.put("bossName",FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/enemyplane/boss/bossName.png"));
        /**
         * 敌方飞机boss的爆炸
         */
        for (int i = 0; i < 3; i++) {
            images.put("boss_"+(i+1),FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/explode/boss/boss_"+(i+1)+".png"));
        }

        /**
         * 敌方飞机的子弹
         */
        images.put("enemyplane_bullet",FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/bullet/enemybullets/enemyplane_bullet_0_1.png"));
        images.put("enemyplane_bullet2",FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/bullet/enemybullets/bullet3_1.png"));
        images.put("enemyplane_bullet3",FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/bullet/enemybullets/bossbullet0_1.png"));
        images.put("enemyplane_bullet4",FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/bullet/enemybullets/bossbullet0_2.png"));
        images.put("enemyplane_bullet5",FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/bullet/enemybullets/bossbullet0_3.png"));
        images.put("enemyplane_bullet6",FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/bullet/enemybullets/bossbullet0_4.png"));
        images.put("enemyplane_bullet7",FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/bullet/enemybullets/bossbullet0_5.png"));

        /**
         * 敌方飞机爆炸
         */
        for(int i = 0 ; i < 6 ;i++ ){
          //  images.put("myplane0"+( i+1 ),FrameUtil.getImage(Constant.IMG_PATH_PRE+"myplane/plane/Sehero"+ i +".png"));
           images.put("explode"+( i+1 ),FrameUtil.getImage(Constant.IMG_PATH_PRE + "myplane/explode/blast0_"+( i+1 )+".png"));
        }
        /**
         * 加血道具
         */
        images.put("item_HP",FrameUtil.getImage(Constant.IMG_PATH_PRE+"item/item0_4.png"));
        /**
         * 加护盾道具
         */
        images.put("def",FrameUtil.getImage(Constant.IMG_PATH_PRE + "item/def_1.jpg.png"));
        images.put("def2",FrameUtil.getImage(Constant.IMG_PATH_PRE + "item/Shield.png"));

        /**
         * 加攻击力道具
         */
        images.put("hurt",FrameUtil.getImage(Constant.IMG_PATH_PRE + "item/item2_1.png"));
        /**
         * 背景图片
         */
        images.put("bGround",FrameUtil.getImage(Constant.IMG_PATH_PRE+"background/bg5.png"));
        images.put("bGround2",FrameUtil.getImage(Constant.IMG_PATH_PRE+"background/bg8.png"));
        /**
         * 陨石图片
         */
        images.put("yushi",FrameUtil.getImage(Constant.IMG_PATH_PRE+"item/meteorite/yunshi0_1.png"));
        images.put("yushi2",FrameUtil.getImage(Constant.IMG_PATH_PRE+"item/meteorite/yunshi0_2.png"));
        images.put("yushi3",FrameUtil.getImage(Constant.IMG_PATH_PRE+"item/meteorite/yunshi0_3.png"));
        images.put("yushi4",FrameUtil.getImage(Constant.IMG_PATH_PRE+"item/meteorite/yunshi0_4.png"));
        images.put("yushi5",FrameUtil.getImage(Constant.IMG_PATH_PRE+"item/meteorite/yunshi0_5.png"));
        images.put("yushi6",FrameUtil.getImage(Constant.IMG_PATH_PRE+"item/meteorite/yunshi0_6.png"));

        /**
         * 雪花图片
         */
        for (int i = 0; i <3; i++) {
            images.put("snow"+(i+1),FrameUtil.getImage(Constant.IMG_PATH_PRE+"item/snow/Snow0_"+(i+1)+".png"));
        }
        /**
         * 复活图片
         */
        images.put("fh",FrameUtil.getImage(Constant.IMG_PATH_PRE+"item/fh1.png"));
        /**
         * 危险警告
         */
        images.put("dg",FrameUtil.getImage(Constant.IMG_PATH_PRE+"item/dangerous.png"));
        //暂停
        images.put("stop",FrameUtil.getImage(Constant.IMG_PATH_PRE+"item/stop/stop.png"));
        /**
         * 游戏开始图
         */
        images.put("startGame",FrameUtil.getImage(Constant.IMG_PATH_PRE+"background/sg2.jpg.png"));
        images.put("startFont",FrameUtil.getImage(Constant.IMG_PATH_PRE+"background/startGame.png"));
        /**
         * 游戏结束图
         */
        images.put("GameOver",FrameUtil.getImage(Constant.IMG_PATH_PRE+"background/GameOver3.jpg"));
        images.put("GameOver2",FrameUtil.getImage(Constant.IMG_PATH_PRE+"background/loading5.png"));
        images.put("GameOver3",FrameUtil.getImage(Constant.IMG_PATH_PRE+"background/bg6.png"));
        images.put("GameOver4",FrameUtil.getImage(Constant.IMG_PATH_PRE+"background/zi.jpg.png"));
        images.put("GameOver5",FrameUtil.getImage(Constant.IMG_PATH_PRE+"background/font/tub2_1.png"));

    }
}
