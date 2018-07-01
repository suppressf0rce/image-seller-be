package service;

public interface MailService {

    void sendMail(String message, String title, String recipient) throws Exception;

}
