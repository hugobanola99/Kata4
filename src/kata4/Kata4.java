/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata4;

import kata4.view.MailHistogramBuilder;
import kata4.view.HistogramDisplay;
import persistence.MailListReader;
import kata4.model.Mail;
import kata4.model.Histogram;
import java.util.List;

/**
 *
 * @author hugob
 */
public class Kata4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String fileName = new String("emails.txt");
        List<Mail> mailList = MailListReader.read(fileName);
        Histogram<String> mailHistogram = MailHistogramBuilder.build(mailList);
        
        
        Histogram<String> histogram = new Histogram();
        
        
        HistogramDisplay histogramDisplay = new HistogramDisplay("Histogram",mailHistogram);
        histogramDisplay.execute();
    }
    
}
