package august01

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "parse string containing dir into a single directory" {
        parse("dir") shouldBe listOf("dir")
    }
    "first name in dir/n/tsubdir1 should be dir" {
        "dir\\n\\tsubdir1".getFirstName() shouldBe "dir"
    }
    "level of empty string should be 0" {
        "".getLevel() shouldBe 0
    }
    "level of /n/tsubdir1 should be 1" {
        "\\n\\tsubdir1".getLevel() shouldBe 1
    }
    "s.x is a file name" {
        "s.x".isFileName() shouldBe true
    }
    "sx is not a file name" {
        "sx".isFileName() shouldBe false
    }
    "s. is not a file name" {
        println("s.".split("."))
        "s.".isFileName() shouldBe false
    }
    "parse string containing dir/n/tsubdir1 should be two directories" {
        val parsedString = parse("dir\\n\\tsubdir1")
        parsedString shouldBe listOf("dir", "dir/subdir1")
    }
    "parse string containing dir/n/tsubdir1/n/tsubdir2 should be three directories" {
        val parsedString = parse("dir\\n\\tsubdir1\\n\\tsubdir2")
        parsedString shouldBe listOf("dir", "dir/subdir1", "dir/subdir2")
    }
    "parse string containing dir/n/tsubdir1/n/tsubdir2/n/t/tfile.ext should be three directories and a file" {
        val parsedString = parse("dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext")
        parsedString shouldBe listOf("dir", "dir/subdir1", "dir/subdir2", "dir/subdir2/file.ext")
    }
})