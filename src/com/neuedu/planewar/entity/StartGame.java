package com.neuedu.planewar.entity;

import com.neuedu.planewar.client.PlaneWarClient;
import com.neuedu.planewar.common.ImageUtil;
import com.neuedu.planewar.constant.Constant;

import java.awt.*;
import java.awt.event.KeyEvent;

public class StartGame extends PlaneWarObject {
    public StartGame(){}
    public StartGame(PlaneWarClient pwc, int x, int y){
         this.x = x;
         this.y = y;
         this.img = ImageUtil.images.get("startGame");
         this.width = img.getWidth(null);
         this.height = img.getHeight(null);
     }

    @Override
    public void draw(Graphics g) {
        Image sg = ImageUtil.images.get("startFont");
        g.drawImage(img,x,y,null);
        g.drawImage(sg,(Constant.FRAME_WIDTH-sg.getWidth(null))/2,160,null);
        Font f = g.getFont();
        Color c = g.getColor();
        g.setColor(Color.GRAY);
        g.setFont(new Font("华文彩云",Font.BOLD,26));
        g.drawString("H：开始游戏",Constant.FRAME_WIDTH/2-70,Constant.FRAME_HEIGHT/2+160);
        g.drawString("O：退出游戏",Constant.FRAME_WIDTH/2-70,Constant.FRAME_HEIGHT/2+200);
        g.setFont(f);
        g.setColor(c);
    }

}
