package sealed

import sealed.Notification
import sealed.Notifier


inline fun <reified T : Notification> List<Notifier<*>>.findNotifier(): Notifier<T>? {
    return firstOrNull { it.supportedType == T::class } as? Notifier<T>
}