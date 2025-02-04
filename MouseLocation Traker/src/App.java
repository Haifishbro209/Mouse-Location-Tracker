import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class App {
    public static void main(String[] args) throws Exception {
        MyFrame frame = new MyFrame();
        
    }

}


class MyFrame extends JFrame {

    MyPanel panel;

    MyFrame() {
        panel = new MyPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}

class MyPanel extends JPanel implements MouseMotionListener {
    double mouseX, mouseY;
    int panelX = 1000;
    int panelY = 1000;

    MyPanel() {
        this.setPreferredSize(new Dimension(panelX, panelY));
        this.addMouseMotionListener(this);
        this.setBackground(Color.BLACK);
    } 

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.setStroke(new BasicStroke(1));
        g2D.setColor(Color.WHITE); 
        g2D.drawLine((int) mouseX, 0, (int) mouseX, panelY);
        g2D.drawLine(0, (int) mouseY, panelX, (int) mouseY);
        String coords = String.format("Mouse Coordinates: (%.1f, %.1f)", mouseX, mouseY);
        g2D.drawString(coords, 10, 20);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        repaint();
    }
}
