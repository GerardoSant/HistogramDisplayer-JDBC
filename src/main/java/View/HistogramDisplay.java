package View;

import java.awt.Dimension;
import javax.swing.JPanel;

import Model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author Usuario
 */
public class HistogramDisplay extends ApplicationFrame{


    private final Histogram<String> histogram;

    public HistogramDisplay(Histogram<String> histogram){
        super("HISTOGRAM");
        this.histogram=histogram;
        this.setContentPane(createPanel());
        this.pack();
    }

    public void execute(){
        setVisible(true);
    }

    private JPanel createPanel(){
        ChartPanel chartpanel = new ChartPanel(createChart(createDataSet()));
        chartpanel.setPreferredSize(new Dimension(500,400));
        return chartpanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart=ChartFactory.createBarChart("Histogram JFreeChart",
                "Dominios e-mail","Nº de emails",dataSet, PlotOrientation.VERTICAL,
                false,false, rootPaneCheckingEnabled);
        return chart;

    }

    private DefaultCategoryDataset createDataSet(){
        DefaultCategoryDataset dataSet= new DefaultCategoryDataset();

        for (String key : histogram.keySet()){
            dataSet.addValue(histogram.get(key), "",key);
        }

        return dataSet;
    }
}

