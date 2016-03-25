import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.Graphics;

public abstract class ColorPanel extends JPanel{
    public Color color;
    protected float h,s,b;

    /*public ColorPanel(Color initialColor){
	this.color = initialColor;
    }*/
    
    public ColorPanel(float h, float s, float b)
    {
    	this.h = h;
    	this.s = s;
    	this.b = b;
    	this.color = Color.getHSBColor(h, s, b);
    }
    
    public void setColor(Color newColor){
	this.color = newColor;
	repaint();
    }
    

    protected void paintComponent(Graphics g){
	this.setBackground(color);
	super.paintComponent(g);
    }


    
    public float[] getHSB()
    {
    	float[] ret = {h,s,b};
    	return ret;
    }
   
	
}