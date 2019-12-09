package Controller;

import Model.Histogram;
import Model.Mail;
import View.HistogramDisplay;
import View.MailHistogramBuilder;
import View.MailListReaderBD;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Mail> mailList = MailListReaderBD.read();
        Histogram histogram = MailHistogramBuilder.build(mailList);
        HistogramDisplay histogramDisplay = new HistogramDisplay(histogram);
        histogramDisplay.execute();

    }







}
