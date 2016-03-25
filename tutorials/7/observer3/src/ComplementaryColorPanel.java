import java.awt.Color;
import java.awt.Container;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

public class ComplementaryColorPanel extends ColorPanel implements PropertyChangeListener{

	public ComplementaryColorPanel(float h , float s, float b) {
		super(h,s,b);
	}

	
	protected float getComplementaryHue(float h)
	{
		float complementaryHue = h - (float)0.5;
		
		if(complementaryHue < 0){
			complementaryHue = complementaryHue + 1;
		}
		return complementaryHue;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		// TODO Auto-generated method stub
		System.out.println("property change"+e.getPropertyName());
		
		ColorPanel cp = (ColorPanel) e.getSource();
		
		float [] hsb  = cp.getHSB();
		h = getComplementaryHue(hsb[0]);
		s = hsb[1];
		b = hsb[2];
		
		Color complementaryColor = Color.getHSBColor(h,s,b);
		setColor(complementaryColor);
		
	}
	
	public void registerPanel(ColorPanel cp)
	{
		cp.addPropertyChangeListener(this);
	}
}
