package sealed


class PushNotifier : Notifier<Notification.PushNotification> {
    override val supportedType = Notification.PushNotification::class
    override fun send(notification: Notification.PushNotification): String {
       return "Sending ${notification.message} to ${notification.deviceToken}"
    }
}