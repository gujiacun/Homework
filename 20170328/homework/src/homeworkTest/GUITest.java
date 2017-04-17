package homeworkTest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.BorderLayout;
//import java.awt.Button;
//import java.awt.Frame;
//import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;

public class GUITest {

    public static void main(String[] args) {
        // 创建窗口，设置窗口标题显示的字符串
        Frame window = new Frame("时间众筹");
        // 设置窗口在屏幕的显示位置
        window.setLocation(483, 234);
        // 设置窗口的大小
        window.setSize(400, 300);
        // window.setBackground(13);
        // 创建文本框
        final TextField textField = new TextField(30);
        // 把创建好的文本框放在窗口里
        window.add(textField, BorderLayout.SOUTH);
        // 新建按钮，赋予按钮名字，把它放进窗口中
        Button button = new Button("+1s！");
        window.add(button);
        // 为窗口新建一个点击事件，运用内部类
        button.addActionListener(new ActionListener() {
            // 获取文本框里的文档
            String info = textField.getName();

            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("我又可以与华莱士谈笑风生啦，excited！" + info);
                // 让窗口标题显示为输入的文字
                window.setTitle(info);
            }
        });
        // 为关闭按钮设置“按了后停止程序”的事件
        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });

        // 让窗口自行调节大小
        window.pack();
        // 显示窗口
        window.setVisible(true);

    }

}
/**
 * 小结：我嚓咧，addActionListener是button的方法
 */
