# 🐍 Java 贪吃蛇游戏

一个使用 Java Swing 实现的经典贪吃蛇游戏。

## 🎮 游戏特性
- 经典的贪吃蛇玩法
- 图形化界面，方向图标显示
- 积分系统和食物生成
- 碰撞检测（墙壁和自身）
- 游戏状态控制（开始/暂停/重新开始）

## 🚀 如何运行

### 前提条件
- 安装 **JDK 8 或更高版本**
- 终端或命令行工具

### 方法一：命令行运行（推荐）

1. **下载项目**
   ```bash
   git clone https://github.com/你的用户名/java-snake-game.git
   cd java-snake-game
   ```

2. **调整包结构（重要！）**
   由于项目使用特定包路径，你需要：
   
   **选项A：保持原包结构运行**
   ```bash
   # 编译
   javac -d . src/com/snmwyl/GUI/snake/*.java
   
   # 运行
   java com.snmwyl.GUI.snake.StartGame
   ```
   
   **选项B：简化为默认包（更简单）**
   1. 编辑所有 `.java` 文件，将 `package com.snmwyl.GUI.snake;` 改为 `package snake;`
   2. 将文件移动到 `src/snake/` 目录
   3. 然后运行：
   ```bash
   javac -d . src/snake/*.java
   java snake.StartGame
   ```

### 方法二：使用 IDE 运行（最简单）
1. 用 **IntelliJ IDEA** 或 **Eclipse** 打开项目文件夹
2. IDE 会自动识别 Java 项目结构
3. 找到并运行 `StartGame.java`

## 📁 项目文件结构

```
java-snake-game/
├── README.md               # 本说明文件
└── src/                    # 源代码目录
    ├── com/snmwyl/GUI/snake/  # 原始包结构
    │   ├── StartGame.java     # 游戏启动类
    │   ├── GamePanel.java     # 游戏主逻辑（绘制、移动、碰撞）
    │   └── Data.java          # 图片资源加载
    └── static/              # 游戏图片资源
        ├── header.png       # 顶部横幅
        ├── up.png           # 向上蛇头
        ├── down.png         # 向下蛇头
        ├── left.png         # 向左蛇头
        ├── right.png        # 向右蛇头
        ├── body.png         # 蛇身体
        └── food.png         # 食物
```

## 🎯 游戏控制

| 按键 | 功能 |
|------|------|
| **空格键** | 开始游戏 / 暂停游戏 |
| **↑ 方向键** | 向上移动 |
| **↓ 方向键** | 向下移动 |
| **← 方向键** | 向左移动 |
| **→ 方向键** | 向右移动 |
| **游戏失败后按空格** | 重新开始游戏 |

## 🛠️ 技术实现

### 核心类说明
- **StartGame**: 程序入口，创建游戏窗口
- **GamePanel**: 游戏核心面板，继承 `JPanel`
  - 实现 `KeyListener` 处理键盘输入
  - 实现 `ActionListener` 处理定时器事件
  - 包含蛇的移动逻辑、碰撞检测、食物生成
- **Data**: 静态资源加载器，预加载所有游戏图片

### 游戏逻辑
1. **蛇的移动**: 使用数组存储蛇身坐标，定时更新
2. **食物系统**: 随机在网格位置生成食物
3. **碰撞检测**: 检测墙壁碰撞和自身碰撞
4. **积分系统**: 每吃一个食物得10分，蛇身长度+1
5. **游戏状态**: 开始、暂停、失败三种状态

## 🔧 常见问题

### Q1: 编译时提示"软件包不存在"？
**A**: 确保包名与目录结构匹配。要么：
- 保持 `src/com/snmwyl/GUI/snake/` 的目录结构
- 或者修改代码中的 `package` 声明

### Q2: 运行后提示"找不到或无法加载主类"？
**A**: 类路径设置不正确。尝试：
```bash
java -cp "." com.snmwyl.GUI.snake.StartGame
```

### Q3: 游戏图片不显示？
**A**: 确保 `images/` 文件夹与编译后的 `.class` 文件在同一目录，或修改 `Data.java` 中的图片路径。

## 📝 开发说明

这个项目是学习 Java GUI 编程的练习作品，涵盖了：
- Swing 组件使用（JFrame, JPanel, Timer）
- 事件监听机制（键盘事件、定时器事件）
- 自定义绘图（paintComponent 方法）
- 游戏循环和状态管理

## 📄 许可证

MIT License - 自由使用和修改

---

**提示**: 如果你在运行中遇到任何问题，欢迎在 GitHub 提交 Issue 或自行调整代码中的包声明以匹配你的开发环境。
