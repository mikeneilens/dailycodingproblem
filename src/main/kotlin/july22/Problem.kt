package july22

data class Message(val decodedMessage:String, val encodedMessage:String ) {
    private fun decodeDigit(length:Int = 1):Message? =
        if (encodedMessage.length >= length && lookupTable.containsKey(encodedMessage.take(length))) {
            Message(decodedMessage + lookupTable.getValue(encodedMessage.take(length)), encodedMessage.drop(length) )
        } else null

    fun decoded():List<Message> =
        if (encodedMessage.isEmpty()) listOf(this)
        else (1..2).fold(emptyList()){ result, length ->
            val newMessage= decodeDigit(length)
            if (newMessage!= null) result + newMessage else result
        }
}

fun decodedAllMessages(messages:List<Message>):List<Message> =
    if (messages.all{it.encodedMessage.isEmpty()})
        messages
    else
        decodedAllMessages(decodedMessages(messages))

fun decodedMessages(messages:List<Message>):List<Message> = messages.flatMap(Message::decoded)


