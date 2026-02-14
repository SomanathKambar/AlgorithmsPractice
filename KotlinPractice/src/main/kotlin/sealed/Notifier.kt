package sealed

import kotlin.reflect.KClass


interface Notifier<out T : Notification> {

    val supportedType: KClass<*>
    fun send(notification: @UnsafeVariance T): String

    @Suppress("UNCHECKED_CAST")
    fun trySend(notification: Notification): String? {
        return if (supportedType.isInstance(notification)) {
            send(notification as T)
        } else {
            null
        }
    }
}