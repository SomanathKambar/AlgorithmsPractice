package sealed

class EmailNotifier : Notifier<Notification.EmailNotification> {
    override val supportedType = Notification.EmailNotification::class
    override fun send(notification: Notification.EmailNotification): String {
        return "Sending ${notification.message} to ${notification.emailAddress}"
    }
}