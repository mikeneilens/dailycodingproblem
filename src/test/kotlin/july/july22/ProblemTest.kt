package july.july22

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import july.july22.Message
import july.july22.decodedAllMessages
import july.july22.decodedMessages

class ProblemTest: StringSpec({
    "decoding messages when messages contain no encoded data should return the list of messages" {
        val messages = listOf(Message(decodedMessage = "abc", encodedMessage =""))
        decodedMessages(messages) shouldBe messages
    }
    "decoding listOf(Message('','1') should give listOf(Message('a',''))" {
        val messages = listOf(Message(decodedMessage = "", encodedMessage ="1"))
        decodedMessages(messages) shouldBe listOf(Message(decodedMessage ="a",encodedMessage =""))
    }
    "decoding listOf(Message('','11') should give listOf(Message('a','1',Message('k',''))" {
        val messages = listOf(Message(decodedMessage = "", encodedMessage ="11"))
        decodedMessages(messages) shouldBe listOf(
            Message(decodedMessage ="a", encodedMessage ="1"),
            Message(decodedMessage ="k",encodedMessage ="")
        )
    }
    "decoding all messages when listOf(Message('','11') should give listOf(Message('aa','',Message('k',''))" {
        val messages = listOf(Message(decodedMessage = "", encodedMessage ="11"))
        decodedAllMessages(messages) shouldBe listOf(
            Message(decodedMessage ="aa", encodedMessage =""),
            Message(decodedMessage ="k",encodedMessage ="")
        )
    }
    "decoding all messages when listOf(Message('','111') should give listOf(Message('aaa','',Message('ak',''),Message('ka',''))" {
        val messages = listOf(Message(decodedMessage = "", encodedMessage ="111"))
        decodedAllMessages(messages) shouldBe listOf(
            Message(decodedMessage ="aaa", encodedMessage =""),
            Message(decodedMessage ="ak",encodedMessage =""),
            Message(decodedMessage ="ka",encodedMessage ="")
        )
    }
    "decoding all messages when listOf(Message('','203') should give listOf(Message('tc',''))" {
        val messages = listOf(Message(decodedMessage = "", encodedMessage ="203"))
        decodedAllMessages(messages) shouldBe listOf(Message(decodedMessage ="tc", encodedMessage =""))
    }
})