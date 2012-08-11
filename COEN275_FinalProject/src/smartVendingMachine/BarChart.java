package smartVendingMachine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JPanel;


public class BarChart extends JPanel {

	private Map<String, Integer> bars =
            new LinkedHashMap<String, Integer>();

	public BarChart(){
		
	}
		
	/**
	 * Add new bar to chart
	 * @param color color to display bar
	 * @param value size of bar
	 */
	public void addBar(String day, int value)
	{
		bars.put(day, value);
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		// determine longest bar
		//super.paintComponent(g);
		int max = Integer.MIN_VALUE;
		for (Integer value : bars.values())
		{
			max = Math.max(max, value);
		}

		// paint bars

		int width = bars.size() == 0 ? 0 : (getWidth() / bars.size()) -2;
		int x = 1;
		for (String day : bars.keySet())
		{
			int value = bars.get(day);
			int height = (int)
                            ((getHeight()-25) * ((double)value / max));
			g.setColor(Color.blue);
			g.fillRect(x, getHeight() - height, width, height);
			g.setColor(Color.white);
			g.drawRect(x, getHeight() - height, width, height);
			g.drawString(day, x , getHeight() - height-4);
			x += (width + 3);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(568, 440);
	}
	
}
