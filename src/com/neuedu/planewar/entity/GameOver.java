package com.neuedu.planewar.entity;

import com.neuedu.planewar.client.PlaneWarClient;
import com.neuedu.planewar.common.ImageUtil;
import com.neuedu.planewar.constant.Constant;

import java.awt.*;

public class GameOver extends PlaneWarObject{
    public int type= 0;
    public GameOver(){}
    public GameOver(PlaneWarClient pwc,int x,int y){
        this.pwc = pwc;
        this.x =x;
        this.y = y;
        this.img = ImageUtil.images.get("GameOver");
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }

    @Override
    public void draw(Graphics g) {

//        g.drawRect(0,0,Constant.FRAME_WIDTH,Constant.FRAME_HEIGHT);
//        g.fillRect(0,0,Constant.FRAME_WIDTH,Constant.FRAME_HEIGHT);

       switch (type){
           case 0:
               g.drawImage(img,x,y,null);
               Font f = g.getFont();
               Color c = g.getColor();
               g.setColor(Color.white);
               g.setFont(new Font("华文彩云",Font.BOLD,36));
               g.drawString("再见！",Constant.FRAME_WIDTH/2-100,Constant.FRAME_HEIGHT/2-120);
               g.setFont(f);
               g.setColor(c);
               break;
           case 1:
               g.drawImage(img,x,y,null);
               Image image = ImageUtil.images.get("GameOver4");
               g.drawImage(image,(Constant.FRAME_WIDTH-image.getWidth(null))/2,120,null);
               Font f1 = g.getFont();
               Color c1 = g.getColor();
               g.setColor(Color.white);
//               g.setFont(new Font("华文彩云",Font.BOLD,40));
//               g.drawString("GameOver !",Constant.FRAME_WIDTH/2-100,Constant.FRAME_HEIGHT/2-120);
               g.setFont(new Font("华文彩云",Font.BOLD,30));
               g.drawString("积分："+ Bullet.integral,Constant.FRAME_WIDTH/2-70,Constant.FRAME_HEIGHT/2+160);
              // g.drawString("K：重新开始",Constant.FRAME_WIDTH/2-70,Constant.FRAME_HEIGHT/2+200);
               g.setFont(f1);
               g.setColor(c1);
               break;
           case 2:
               g.drawImage(img,x,y,null);
               Image load = ImageUtil.images.get("GameOver5");
               g.drawImage(load,(Constant.FRAME_WIDTH-load.getWidth(null))/2-40,120,null);
               Font f2 = g.getFont();
               Color c2 = g.getColor();
               g.setColor(Color.white);
               g.setFont(new Font("华文彩云",Font.BOLD,30));
               g.drawString("积分："+ Bullet.integral,Constant.FRAME_WIDTH/2-70,Constant.FRAME_HEIGHT/2+160);
               g.setFont(f2);
               g.setColor(c2);
               break;
       }

    }
}
