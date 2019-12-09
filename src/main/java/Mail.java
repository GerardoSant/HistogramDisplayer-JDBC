public class Mail {
    private String mail;


    public Mail(String mail) {
        this.mail=mail;
    }

    public String getDomain(){
        return mail.substring(mail.indexOf("@")+1,mail.length());
    }

    public static boolean isMail(String fileLine){
        return fileLine.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");

    }

    public String getMail() {
        return mail;
    }



}