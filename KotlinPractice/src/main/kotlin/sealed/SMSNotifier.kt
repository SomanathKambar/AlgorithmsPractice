package sealed

import kotlin.reflect.KClass

class SMSNotifier : Notifier<Notification.SMSNotification> {
    override val supportedType = Notification.SMSNotification::class
    override fun send(notification: Notification.SMSNotification): String {
        return "Sending ${notification.message} to ${notification.phoneNumber}"
    }
}