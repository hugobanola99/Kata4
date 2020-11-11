/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata4.view;

import kata4.model.Histogram;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author hugob
 */
public class HistogramDisplay extends ApplicationFrame{
    
    private final Histogram<String> histogram;
    public HistogramDisplay(String title,Histogram histogram) {
        super(title);
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }
    
    private JPanel createPanel(){
        return new ChartPanel(createChart(createDataset()));
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart("JFreeChart Histogram",
                "emails", "nº emails", dataSet, PlotOrientation.VERTICAL,
                false,false,rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String key  : histogram.keySet()) {
            dataset.addValue(histogram.get(key), "", key);
        }
        
        /*
        dataset.addValue(5, "", "ulpgc.es");
        dataset.addValue(1, "", "elpais.es");
        dataset.addValue(4, "", "youtube.es");
        dataset.addValue(2, "", "google.es");
        dataset.addValue(3, "", "marca.es");
*/
        return dataset;
       
    }
    
    public void execute(){
        this.setVisible(true);
    }
    
}
