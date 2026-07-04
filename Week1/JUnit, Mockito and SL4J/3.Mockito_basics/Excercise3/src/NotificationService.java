public class NotificationService {

    private EmailService emailService;

    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void notifyUser() {
        emailService.sendEmail("suhani@gmail.com", "Welcome!");
    }
}