package com.snmwyl.GUI.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

//游戏的画板
public class GamePanel extends JPanel implements KeyListener, ActionListener {
    //定义蛇的数据结构
    int length;
    int[] snakeX = new int[816];
    int[] snakeY = new int[816];
    String direction;
    boolean isStart;   //游戏是否开始
    boolean isFail;   //游戏是否失败
    int foodx;
    int foody;
    Random random = new Random();
    int score;

    //构造器
    public GamePanel() {
        init();
        this.setFocusable(true);   //获得焦点事件
        this.addKeyListener(this);   //获得键盘监听事件
    }

    //初始化方法
    public void init(){
        length = 3;
        snakeX[0] = 100; snakeY[0] = 100;   //脑袋的坐标
        snakeX[1] = 75; snakeY[1] = 100;   //第一个身体的坐标
        snakeX[2] = 50; snakeY[2] = 100;   //第二个身体的坐标
        direction = "R";
        isStart = false;   //游戏当前的状态
        isFail = false;
        score = 0;
        foodx = 25 + 25 * random.nextInt(34);
        foody = 75 + 25 * random.nextInt(24);
        timer.start();   //刷新
    }

    //定时器,以ms为单位，1000ms = 1s
    Timer timer = new Timer(100, this);

    //绘制面板
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);   //清屏
        this.setBackground(Color.WHITE);   //绘制静态的面板
        g.fillRect(25,75,850,600);   //默认的游戏界面
        Data.header.paintIcon(this,g,25,11);   //头部广告栏
        switch(direction){
            case "R":Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);break;
            case "L":Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);break;
            case "U":Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);break;
            case "D":Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);break;
        }
        for(int i = 1; i < length; i++){
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
        Data.food.paintIcon(this,g,foodx,foody);
        if(!isStart){
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("按下空格开始游戏！",280,300);
        }
        if(isFail){
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("游戏失败！按下空格重新开始！",200,300);
        }
        //画积分
        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑", Font.BOLD, 20));
        g.drawString("积分" + score,750,35);
    }

    //事件监听
    public void actionPerformed(ActionEvent e){
        if(isStart && !isFail){
            //吃饭
            if(snakeX[0] == foodx && snakeY[0] == foody){
                length++;
                score += 10;
                foodx = 25 + 25 * random.nextInt(34);
                foody = 75 + 25 * random.nextInt(24);
            }

            //移动
            for(int i = length - 1; i > 0; i--){
                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }
            switch(direction){
                case "R":
                    snakeX[0] = snakeX[0]+25;
                    //if(snakeX[0] > 850){snakeX[0] = 25;}
                    break;
                case "L":
                    snakeX[0] = snakeX[0]-25;
                    //if(snakeX[0] < 25){snakeX[0] = 850;}
                    break;
                case "U":
                    snakeY[0] = snakeY[0]-25;
                    //if(snakeY[0] < 75){snakeY[0] = 650;}
                    break;
                case "D":
                    snakeY[0] = snakeY[0]+25;
                    //if(snakeY[0] > 650){snakeY[0] = 75;}
                    break;
            }

            //失败判定
            for(int i = 1; i < length; i++) {
                if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                    isFail = true;
                }
            }
            if(snakeX[0] < 25 || snakeX[0] > 850 || snakeY[0] < 75 || snakeY[0] > 650){
                isFail = true;
            }

            //刷新
            repaint();
        }
    }

    //键盘监听事件
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch(keyCode){
            case KeyEvent.VK_SPACE:
                if(isFail){
                    //重新开始
                    init();
                } else{
                    isStart = !isStart;
                }
                break;
            case KeyEvent.VK_UP:
                direction = "U";
                break;
            case KeyEvent.VK_DOWN:
                direction = "D";
                break;
            case KeyEvent.VK_LEFT:
                direction = "L";
                break;
            case KeyEvent.VK_RIGHT:
                direction = "R";
                break;
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
