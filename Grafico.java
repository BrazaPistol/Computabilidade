import java.awt.Dimension;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Grafico extends JFrame {

	public Grafico(XYSeries series) {
		super("Complexidade ALgoritmo");
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		
		JFreeChart chart = ChartFactory.createXYLineChart("Grafico de linha de exemplo", "X", "Y", dataset);
		
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(800, 600));
		setContentPane(chartPanel);
		
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
