package august01

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ProblemTest: StringSpec({
    "parse emptying string creates an empty list of paths" {
        parse("") shouldBe listOf()
    }
    "parse string containing dir into a single directory" {
        parse("dir") shouldBe listOf("/dir")
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
        "s.x".isFile() shouldBe true
    }
    "sx is not a file name" {
        "sx".isFile() shouldBe false
    }
    "s. is not a file name" {
        println("s.".split("."))
        "s.".isFile() shouldBe false
    }
    "parse string containing dir/n/tsubdir1 should be two directories" {
        val parsedString = parse("dir\\n\\tsubdir1")
        parsedString shouldBe listOf("/dir", "/dir/subdir1")
    }
    "parse string containing dir/n/tsubdir1/n/tsubdir2 should be three directories" {
        val parsedString = parse("dir\\n\\tsubdir1\\n\\tsubdir2")
        parsedString shouldBe listOf("/dir", "/dir/subdir1", "/dir/subdir2")
    }
    "parse string containing dir/n/tsubdir1/n/tsubdir2/n/t/tfile.ext should be three directories and a file" {
        val parsedString = parse("dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext")
        parsedString shouldBe listOf("/dir", "/dir/subdir1", "/dir/subdir2", "/dir/subdir2/file.ext")
    }
    "parse string dir/n/tsubdir1/n/t/tfile1.ext/n/t/tsubsubdir1/n/tsubdir2/n/t/tsubsubdir2/n/t/t/tfile2.ext" {
        val parsedString = parse("dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext")
        parsedString shouldBe listOf(
            "/dir",
            "/dir/subdir1",
            "/dir/subdir1/file1.ext",
            "/dir/subdir1/subsubdir1",
            "/dir/subdir2",
            "/dir/subdir2/subsubdir2",
            "/dir/subdir2/subsubdir2/file2.ext",
        )
    }
    "file with longest length in string containing dir/n/tsubdir1/n/tsubdir2/n/t/tfile.ext has length of 20" {
        problem("dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext") shouldBe 20
    }
    "file with longest name from the example has a length of 32" {
        problem("dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext") shouldBe 32
    }
})