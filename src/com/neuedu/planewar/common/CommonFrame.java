package com.neuedu.planewar.common;

import com.neuedu.planewar.constant.Constant;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CommonFrame extends Frame {

    public void loadFrame(String title){
        //设置大小
        this.setSize(Constant.FRAME_WIDTH,Constant.FRAME_HEIGHT);
       /* //设置位置
        this.setLocation(50,50);*/
        //水平垂直居中
        this.setLocationRelativeTo(null);
        //设置可见性:默认不可见
        this.setVisible(true);
        //4.设置关闭窗口按钮的方法的实现：窗口监听器
//        //使用匿名内部类完成抽象类对象的创建
        //jdk8.0+lambda表达式（函数式编程）
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                /*super.windowClosing(e);*/
                //关闭窗口（箭头函数）
                System.exit(0);
            }
        });
        //5.设置改变窗口大小的方法：默认true可更改；设置成不可更改
        this.setResizable(false);
        //设置题目
        this.setTitle(title);
        //启动重画的多线程
        new MyThread().start();
    }
    public void paint(Graphics g){
        // 画直线:起点和终点的位置
          g.drawLine(50,50,150,150);
        //画矩形
        g.drawRect(100,100,400,200);
        //画圆
        g.drawOval(100,100,400,200);
        //获取系统的默认颜色(借还法)
        Color c =g.getColor();
        //改变画笔颜色
        g.setColor(new Color(255, 200, 118));
        //填充
        g.fillRect(200,100,400,200);
        //返回系统颜色
        g.setColor(c);
        //画不规则图形：第一个参数x坐标数组，第二个参数y的数组，第三个参数：几个边
        int[] xpoints ={100,400,500};
        int [] ypoints ={100,100,300};
        int npoints = 3;
        g.drawPolygon(xpoints,ypoints,npoints);
        //画图
       /* g.drawImage(FrameUtil.getImage("com/neuedu/solar/img/EARTH.png"),100,100,null);*/
    }

        //实现java的多线程步骤
        //1. 继承Thread类
//    2.重写run（方法）
        class  MyThread extends Thread{
            public void run(){
                for(;;){
                    //调用paint
//                repaint()方法是外部类MyFrame02中从父类继承过来的，而不是My_Thread
                    repaint();
                    //为了让人眼舒服的识别频率
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        //解决图片闪烁的问题，用双缓冲方法
        Image backImg = null;
        //重写update()方法，在窗口的里层添加一个虚拟的图片
        public void update(Graphics g){
            if(backImg == null ){
                //如果虚拟图片不存在，创建一个和窗口一样大小的图片
                backImg = createImage(Constant.FRAME_WIDTH,Constant.FRAME_HEIGHT);
            }
            //获取到虚拟图片的画笔
            Graphics backg = backImg.getGraphics();
            Color c = backg.getColor();
            backg.setColor(Color.white);
            backg.fillRect(0,0,Constant.FRAME_WIDTH,Constant.FRAME_HEIGHT);
            backg.setColor(c);
            //调用虚拟图片的paint()方法，每50ms刷新一次
            paint(backg);
            g.drawImage(backImg,0,0,null);


        }

}
