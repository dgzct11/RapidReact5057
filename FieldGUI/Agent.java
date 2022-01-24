
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
public class Agent {
    public double x;
    public double y;
    public Color color;

    public Agent(double xc, double yc, boolean is_red){
        x = xc; 
        y = yc;
        if(is_red)
            color = new Color(255,0,0);
        else    color = new Color(0,0,255);
    }
    public double[] getPose(){
        double[] result = {x,y};
        return result;
    }
}