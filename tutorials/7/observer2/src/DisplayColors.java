
import javax.swing.*;
import javax.swing.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;

public class DisplayColors{

    public static void main(String[] args) {
	SwingFacade.launch(new DisplayColors().mainPanel(), "Compute Complementary Colors");
    }

    protected ColorPanel originalColorPanel;
    protected ColorPanel complementaryColorPanel;

    protected JSlider hueSlider;
    protected JSlider saturationSlider;
    protected JSlider brightnessSlider;

    protected JLabel hueValueLabel;
    protected JLabel saturationValueLabel;
    protected JLabel brightnessValueLabel;

    protected JPanel colorsPanel() {
	JPanel p = new JPanel();
	p.setLayout(new GridLayout(1,2));
	
	originalColorPanel = createOriginalColorPanel(0,(float).5,(float).5);
	originalColorPanel.registerSlider(hueSlider);
	originalColorPanel.registerSlider(saturationSlider);
	originalColorPanel.registerSlider(brightnessSlider);
	p.add(SwingFacade.createTitledPanel("Original Color", originalColorPanel));
	
	complementaryColorPanel = createComplementaryColorPanel((float).5, (float).5, (float).5);
	complementaryColorPanel.registerSlider(hueSlider);
	complementaryColorPanel.registerSlider(saturationSlider);
	complementaryColorPanel.registerSlider(brightnessSlider);
	p.add(SwingFacade.createTitledPanel("Complementary Color", complementaryColorPanel));
	
	return p;
    }

    protected JPanel mainPanel() {
    	
    	hueSlider = slider("hue");
    	saturationSlider = slider("saturation");
    	saturationSlider.setValue(50);
    	brightnessSlider = slider("brightness");
    	brightnessSlider.setValue(50);
    	
	JPanel p = new JPanel();
	p.setLayout(new GridLayout(2,1));

	
	JPanel colorsPanel = colorsPanel();
	JPanel subP = new JPanel();
	subP.setLayout(new GridLayout(3,1));
	
	
	subP.add(sliderBox("H", hueSlider, hueValueLabel));
	
	subP.add(sliderBox("S", saturationSlider, saturationValueLabel));
	
	subP.add(sliderBox("B", brightnessSlider, brightnessValueLabel));
	p.add(subP);
	p.add(colorsPanel);
	return p;
    }

    private JSlider slider(String name){
	JSlider slider = new JSlider();
	slider.setName(name);
	// WHAT GOES HERE?
	// You need to make it possible for the app to get the slider values out.
	//slider.addChangeListener(this);
	slider.setValue(slider.getMinimum());
	return slider;
    }

    private Box sliderBox(String sliderLabel, JSlider slider, JLabel valueLabel){
	if(valueLabel == null){
	    valueLabel = new JLabel();
	    valueLabel.setFont(SwingFacade.getStandardFont());
	    valueLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
	    valueLabel.setForeground(java.awt.Color.black);
	}
	Box b = Box. createHorizontalBox();
	JLabel label = new JLabel(sliderLabel);
	label.setFont(SwingFacade.getStandardFont());
	label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
	label.setForeground(java.awt.Color.black);
	b.add(label);
	b.add(valueLabel);
	b.add(slider);
	b.setPreferredSize(new Dimension(600, 50));
	return b;
    }
    
    protected ColorPanel createOriginalColorPanel(float h, float s, float b)
    {
    	ColorPanel colorPanel = new OriginalColorPanel(h,s,b);
    	colorPanel.setPreferredSize(new Dimension(300, 200));
    	return colorPanel;
    }

    protected ColorPanel createComplementaryColorPanel(float h, float s, float b)
    {
    	ColorPanel colorPanel = new ComplementaryColorPanel(h,s,b);
    	colorPanel.setPreferredSize(new Dimension(300, 200));
    	return colorPanel;
    }
/*
    protected ColorPanel createOriginalColorPanel(Color initialColor)
    {
    	ColorPanel colorPanel = new OriginalColorPanel(initialColor);
    	colorPanel.setPreferredSize(new Dimension(300, 200));
    	return colorPanel;
    }

    protected ColorPanel createComplementaryColorPanel(Color initialColor)
    {
    	ColorPanel colorPanel = new ComplementaryColorPanel(initialColor);
    	colorPanel.setPreferredSize(new Dimension(300, 200));
    	return colorPanel;
    }
    */
    
}
    
