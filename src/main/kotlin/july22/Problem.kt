package july22

data class Message(val decodedMessage:String, val encodedMessage:String ) {
    fun decodeDigit(length:Int = 1):Message? =
        if (encodedMessage.length >= length && map.containsKey(encodedMessage.take(length))) {
            Message(decodedMessage + map.getValue(encodedMessage.take(length)), encodedMessage.drop(length) )
        } else null

    fun decoded():List<Message> {
        if (encodedMessage.isEmpty()) return listOf(this)
        val message1 = decodeDigit(length = 1)
        val message2 = decodeDigit(length = 2)
        return when {
            message1 != null && message2 != null -> listOf(message1, message2)
            message1 != null && message2 == null -> listOf(message1)
            message1 == null && message2 != null -> listOf(message2)
            else -> listOf()
        }
    }
}

fun decodedAllMessages(messages:List<Message>):List<Message> =
    if (messages.all{it.encodedMessage.isEmpty()})
        messages
    else
        decodedAllMessages(decodedMessages(messages))

fun decodedMessages(messages:List<Message>):List<Message> = messages.flatMap { message -> message.decoded() }


