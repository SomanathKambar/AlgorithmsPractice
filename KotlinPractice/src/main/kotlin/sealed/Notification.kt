package sealed

sealed class Notification(open val message: String) {
    data class EmailNotification(val emailAddress:String, override val message: String) : Notification(message)
    data class SMSNotification(val phoneNumber:String, override val message: String) : Notification(message)
    data class PushNotification(val deviceToken:String, override val message: String) : Notification(message)
}