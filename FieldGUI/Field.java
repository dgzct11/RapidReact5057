

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import javax.swing.event.MouseInputListener;
import java.awt.geom.Path2D;
import java.awt.geom.AffineTransform;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics2D;
public class Field extends JFrame{
    JFrame frame;
    Panel panel;
    
    public Field(){
      
    }
    
    public void display(){
        frame = new JFrame();
        frame.setTitle("Field");
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new Panel("./FieldGUI\\rapid_react_field_render_cropped.png");
        frame.add(panel);
        panel.setFocusable(true);
        frame.setFocusable(true);
     
        frame.requestFocusInWindow();
        panel.requestFocusInWindow();
        System.out.printf("position: %d %d", panel.getWidth(), panel.getHeight());
        System.out.println(panel.getPreferredSize());
       

       
        frame.setSize(panel.getPreferredSize());
       
      
       
        frame.pack();
      
        
        frame.setVisible(true);
      
    }
  

    
}


//__________________________________________________________________


class Panel extends JPanel{
    public Image fieldImage;
    ArrayList<double[]> balls = new ArrayList<double[]>();
    ArrayList<Agent> robots = new ArrayList<Agent>();
    public double robotWidth;
    public double pixelsPerMeter;
    Color red;
    Color blue;
    public double[] robotPos = new double[2];
    double ballDiameter;
    public Panel(String path) {
       
        fieldImage = Toolkit.getDefaultToolkit().getImage(path);
        
        
    }

    @Override
    public void paint(Graphics g1) {
        super.paintComponent(g1);
        Graphics2D g = (Graphics2D) g1;
        g.drawImage(fieldImage, 0, 0, null);
        for(Agent robot: robots)
            drawRobot(g, robot);
        for(double[] ball: balls)
            drawBall(g, ball);
        repaint();
    }
    public int getHeight(){
        return fieldImage.getHeight(null);
    }
    public int getWidth(){
        return fieldImage.getWidth(null);
    }
    @Override
    public Dimension getPreferredSize() {
        
        return new Dimension(fieldImage.getWidth(null), fieldImage.getHeight(null));
    }

   public int[] metersToPixelsArr(double[] input){
    int[] result = {(int)(input[0]*pixelsPerMeter),
        (int)(input[1]*pixelsPerMeter)};
    return result;
   }

   
    public void drawRobot(Graphics g, Agent robot){
     
        int[] pos = metersToPixelsArr(robot.getPose());
        
        g.setColor(robot.color);
        
        g.fillRect(pos[0] - (int)(robotWidth*pixelsPerMeter/2), pos[1] - (int)(robotWidth*pixelsPerMeter/2), (int)(robotWidth*pixelsPerMeter), (int)(robotWidth*pixelsPerMeter));
     
    }
   public void drawBall(Graphics g, double[] ball){
       int[] pos = metersToPixelsArr(ball);
       
       if(ball[2] ==0) g.setColor(red);
       else g.setColor(blue);
       g.fillOval(pos[0], pos[1], (int)(ballDiameter*pixelsPerMeter), (int)(ballDiameter*pixelsPerMeter));

   }
  
 


    
   

   
}



