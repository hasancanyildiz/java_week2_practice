public class NotificationFactory {
    public static NotificationService creatNotification(String s) {
        if (s.equals("console")){
            return new ConsoleNotification();
        }
        else if(s.equals("email"))    {
            return new EmailNotification()  ;
            }
        else {
            throw new IllegalArgumentException("Unknown nofification type : " + s);
            }

        }

}
