import java.awt.Color;
import java.util.Arrays;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

public class OriginalColorPanel extends ColorPanel {

	public OriginalColorPanel(float h, float s, float b) {
		super(h,s,b);
		// TODO Auto-generated constructor stub
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
			break;
		case "saturation":
			s = value;
			break;
		case "brightness":
			b = value;
			break;
		}
	
		Color newColor = Color.getHSBColor(h,s,b);
		setColor(newColor);
		
		/*if(hueSlider != null && saturationSlider != null && brightnessSlider != null){
			float newHue = (float)hueSlider.getValue()/100;
			float newSaturation = (float)saturationSlider.getValue()/100;
			float newBrightness = (float)brightnessSlider.getValue()/100;
			Color newColor = Color.getHSBColor(newHue, newSaturation, newBrightness);
			float complementaryHue = newHue - (float)0.5;
			if(complementaryHue < 0){
				complementaryHue = complementaryHue + 1;
			}
			Color complementaryColor = Color.getHSBColor(complementaryHue, newSaturation, newBrightness);
			// WHAT GOES HERE?
			// You need to update the two color panels with the appropriate colors
			originalColorPanel.setColor(newColor);
			complementaryColorPanel.setColor(complementaryColor);
		}*/
	}
}
