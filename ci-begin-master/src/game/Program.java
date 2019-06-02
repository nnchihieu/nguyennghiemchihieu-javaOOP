package game;//import java.sql.SQLOutput;
//
///**
// * Created by huynq on 7/4/17.
// */
//
//public class Program {
//    public static void main(String[] args) {
////        Student student1 = new Student();
////        Student student2 = new Student("Tran Van Vu", 15);
////
////        System.out.println(student1.name);
////        student1.eat();
////        System.out.println(student2.name);
////        student2.sleep();
////    }
////    public static double sum(double a, double b) {
////        return a + b;
////    }
//
////    public static void sumAndPrint(double a, double b) {
////        System.out.println(a + b);
////    }
//    public static double[] equation2(double a, double b, double c) {
//        if(a == 0) {
//            if(b == 0) {
//                return null;
//            } else {
//                double[] result = { -b / c, -b / c};
//                return result;
//            }
//        } else {
//            double delta = b * b - 4 * a * c;
//            if(delta >= 0) {
//                double x1 = (-b + Math.sqrt(delta))/2/a;
//                double x2 = (-b - Math.sqrt(delta))/2/a;
//                double[] result = { x1, x2 };
//                return result;
//            } else {
//                return null;
//            }
//        }
//    }
////        double result = new double[2];
////        result[0] = 1.1;
////        result[1] = 5.5;
////        return result;
////        double x = Math.sqrt(2); // căn bậc 2
////        double y = Math. pow(5, 2); // 5 mũ 2
////        double result = 1;
////        double[] arr = { result, result };
////        return arr;
//
//
//
//////        String message = "hello world!";
//////        int x = 1; //byte, short, int, long
//////        double b = 2; //float
//////        char c = 'x'; // x tương đương 120
//////        boolean bool = true;
//////        System.out.println(message);
//////        System.out.println(x);
//////        System.out.println(b + c); // 2 + 20
//////        System.out.println(bool);
//////
//////        System.out.println(message + b);
//////        System.out.println(b + message);
////
////        System.out.println (sum(2, 2222));
////
////        double sum = sum(10, 111);
////        System.out.println(sum);
//
////        int random = 11111;
////        if(random > 10000) {
////            System.out.println("Number too large!");
////        } else if(random < 10) {
////            System.out.println("Number too small");
////        } else {
////            System.out.println("This is number: " + random);
////        }
////
////        switch (random) {
////            case 11111: {
////                System.out.println("Number is 11111!");
////                break;
////            }
////            case 1: {
////                System.out.println("Number is 1!");
////                break;
////            }
////        }
////        int[] array = { 1, 1, 2, 7 };
////        int[] array2 = new int[5]; // { 0, 0, 0, 0, 0 }
////
////        for(int i = 0; i < array.length; i++) {
////            System.out.println(array[i]);
////        }
////        for(int i = 0; i < array2.length; i++) {
////            System.out.println(array2[i]);
////        }
////
////        int i = 0;
////        while(i < array.length) {
////            System.out.println(array[i]);
////            i++;
////        }
////        Giải pt bậc 2
////        equation2(double a, b, c)
////        -> có nghiệm double[2]
////        -> null
//
//        double[] result = equation2(1, 2, 1);
//     if(result == null) {
//         System.out.println("can not resolve equation");
//     } else {
//         System.out.println("x1 = " + result[0] + "; x2 = " + result[1]);
//     }
//
//    }
//}

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by huynq on 7/4/17.
 */


public class Program {
    public static void main(String[] args) {
//        ArrayList<String> strings = new ArrayList<>();
////        size = 0
//        strings.add("hello");
//        strings.add("World");
//        for(int i = 0; i < strings.size(); i++) {
//            String element = strings.get(i);
//            System.out.println(element);
//        }
//        ArrayList<Vector2D> vectors = new ArrayList<>();
//        vectors.add(new Vector2D(0, 0));
//        vectors.add(new Vector2D(2, 3));
//        vectors.add(new Vector2D(-4, 5));
//        vectors.add(new Vector2D(6, -7));
//        double max = 0;
//        double maxIndex = 0;
//        for (int i = 0; i < vectors.size(); i++) {
//            Vector2D vector = vectors.get(i);
//            if (vector.x + vector.y > max) {
//                maxIndex = i;
//            }
//            System.out.println(vectors.get(maxIndex));
//        }


        //.add()
        //.remove()
        //.get()
        //.size()
        JFrame window = new JFrame();
        window.setTitle("Game Touhou");
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    KeyEventPress.isUpPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    KeyEventPress.isDownPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_A) {
                    KeyEventPress.isLeftPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_D) {
                    KeyEventPress.isRightPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyEventPress.isFirePress = true;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    KeyEventPress.isUpPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    KeyEventPress.isDownPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_A) {
                    KeyEventPress.isLeftPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_D) {
                    KeyEventPress.isRightPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyEventPress.isFirePress = false;
                }
            }
        });


//        JPanel panel = new JPanel();
        GamePanel panel = new GamePanel();
        panel.setBackground(Color.CYAN);
        window.add(panel);
        panel.setPreferredSize(
                new Dimension(Settings.GAME_WIDTH, Settings.GAME_HEIGHT)
        );
        window.pack();

        window.setVisible(true);
        panel.gameLoop(); // start game

        // comment post Ctrl + ?
        // alt + enter :fix code
        // (fn +) shift + f6 : rename
        // ctrl + alt + l :format code


//        BufferedImage playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
//        System.out.println(playerImage.getWidth());
//        System.out.println(playerImage.getHeight());

    }
}
