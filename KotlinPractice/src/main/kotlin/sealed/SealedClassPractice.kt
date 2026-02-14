package sealed

fun main() {
    val emailNotifier = EmailNotifier()
    val smsNotifier = SMSNotifier()
    val pushNotifier = PushNotifier()

    val notificationDispatcher = NotificationDispatcher(listOf(emailNotifier, smsNotifier, pushNotifier))
    val emailNotification = Notification.EmailNotification("abc@xyz.com", "Hi")
    val smsNotification = Notification.SMSNotification("990091910", "Whats up")
    val pushNotification = Notification.PushNotification("990091910", "Hey There")
    notificationDispatcher.dispatch(emailNotification)
    notificationDispatcher.dispatch(pushNotification)
    notificationDispatcher.dispatch(smsNotification)

}



