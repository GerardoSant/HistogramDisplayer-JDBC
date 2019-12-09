package View;

import Model.Histogram;
import Model.Mail;

import java.util.List;

public class MailHistogramBuilder {

    public static Histogram build(List<Mail> mailList) {
        Histogram histogram = new Histogram();
        for (Mail mail : mailList){
            histogram.increment(mail.getMail());
        }
        return histogram;
    }

}