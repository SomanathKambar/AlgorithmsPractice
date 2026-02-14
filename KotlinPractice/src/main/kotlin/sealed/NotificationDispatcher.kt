package sealed

class NotificationDispatcher(notifiers: List<Notifier<*>>) {
    private val notifierMap = notifiers.associateBy { it.supportedType }

    fun dispatch(notification: Notification) {
        val result = notifierMap[notification::class]?.trySend(notification)
        println(result ?: "No notifier found for ${notification::class.simpleName}")
    }
}