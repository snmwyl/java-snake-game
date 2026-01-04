package com.snmwyl.GUI.snake;

import javax.swing.*;
import java.net.URL;

//数据中心
public class Data {
    private static URL headerURL = Data.class.getResource("/static/header.png");
    private static URL upURL = Data.class.getResource("/static/up.png");
    private static URL downURL = Data.class.getResource("/static/down.png");
    private static URL leftURL = Data.class.getResource("/static/left.png");
    private static URL rightURL = Data.class.getResource("/static/right.png");
    private static URL bodyURL = Data.class.getResource("/static/body.png");
    private static URL foodURL = Data.class.getResource("/static/food.png");
    public static ImageIcon header = new ImageIcon(headerURL);
    public static ImageIcon up = new ImageIcon(upURL);
    public static ImageIcon down = new ImageIcon(downURL);
    public static ImageIcon left = new ImageIcon(leftURL);
    public static ImageIcon right = new ImageIcon(rightURL);
    public static ImageIcon body = new ImageIcon(bodyURL);
    public static ImageIcon food = new ImageIcon(foodURL);


}
