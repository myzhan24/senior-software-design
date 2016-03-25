import java.awt.Color;
import java.util.Arrays;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

public class ComplementaryColorPanel extends ColorPanel {

	public ComplementaryColorPanel(float h , float s, float b) {
		super(h,s,b);
	}

	@Override
	public void stateChanged(ChangeEvent e){	
		JSlider sl = (JSlider)e.getSource();
		System.out.println("state change from ChangeEvent "+sl.getName()+" my color is "+color.toString()+" my current hsb is "+Arrays.toString(getHSB()));
		
		float value = (float)sl.getValue()/100;
		
		switch(sl.getName())
		{
		case "hue":
			h=value;
			float complementaryHue = h - (float)0.5;
			
			if(complementaryHue < 0){
				complementaryHue = complementaryHue + 1;
			}
			h = complementaryHue;
			
			break;
		case "saturation":
			s = value;
			break;
		case "brightness":
			b = value;
			break;
		}
	
		
		Color complementaryColor = Color.getHSBColor(h,s,b);
		
		setColor(complementaryColor);
	}

}
