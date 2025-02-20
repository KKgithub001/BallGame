import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame{

    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.png");

    double x = 200;
    double y = 200;

    double degree = 3.14/3;   //弧度。 3.14=180°。   60度。

    //boolean right = true; //控制小球的水平位移的方向

    //绘制窗口
    public  void  paint(Graphics g) {
        System.out.println("窗口被画了一次！");
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int) x, (int) y, null);

        //其中数学知识 听不懂也没关系 一般工作用不着 除非写游戏 人工智能 需要数学知识
        //企业开发 一般涉及到数据库操作

        //现在是10*，后期加了摩擦 变慢变8 变6 变1 停下来
        //球碰到洞 不画 消失 相当于进洞 可以做很多变化
        //控制语句 面向对象

        //千万不要沉迷在此 作为兴趣敲一敲
        x = x + 20*Math.cos(degree);
        y = y + 20*Math.sin(degree);

        //碰到上下边界
        if(y>501-40-30||y<40+40){
            degree = - degree;
        }

        //碰到左右边界
        if(x>856-40-30||x<40){
            degree = 3.14 - degree;
        }
    }

/*
        if(right){
            x = x + 10;
        }else {
            x = x - 10;
        }

        if(x>856-30-40){
            right = false;
        }

        if(x<30){
            right = true;
        }
        x = x + 2;

    }
*/

    //创建窗口
    void launchFrame(){
        setSize(856,501);
        setLocation(100,100);
        setVisible(true);

        //实现动画，每秒绘制窗口25次
        while(true){
            repaint();

            try {
                Thread.sleep(40);   //1s = 1000ms; 大约1秒绘制1000/40=25次。
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public static void main(String[] args){
        System.out.println("我的小游戏开始了！");

        BallGame  game = new BallGame();
        game.launchFrame();
    }

}













