import java.awt.*;
import java.awt.event.*;
// 마우스 움직이면 자취 남기는 프로그램
public class awtTest extends Frame implements MouseMotionListener{
    int x; int y; Graphics g;
    awtTest(String title){
        super(title);
        addWindowListener(new WindowAdapter() { // 닫기 누르면 프로세스 종료
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        addMouseMotionListener(this);
        // 크기, 레이아웃 조절
        setLayout(null);
        setSize(500, 400);
        setVisible(true);

        //g.drawString("마우스를 움직여보세요", 10, 50);
        //repaint();
    }

    public static void main(String args[]){
        new awtTest("awtTest");
    }

    // repaint -> update -> paint
    public void paint(Graphics g){
        // x, y 좌표에 * 출력
        g.drawString("마우스를 움직여 보세요", 10, 50);
        g.drawString("*", x, y);
    }

    public void update(Graphics g){
        paint(g);
    }

    public void mouseMoved(MouseEvent event){
        x = event.getX(); y = event.getY(); // 마우스가 위치한 좌표 받기
        repaint();
    }

    public void mouseDragged(MouseEvent event){}
}
