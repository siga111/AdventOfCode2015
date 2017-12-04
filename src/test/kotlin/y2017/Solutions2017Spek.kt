package y2017

import com.winterbe.expekt.should
import core.load2017input
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import y2017.week1.Day1
import y2017.week1.Day2
import y2017.week1.Day3
import y2017.week1.Day4

class Solutions2017Spek : Spek({

    given("day 1") {
        val day = load2017input(1) { Day1(it) }

        it("gets star for simple") {
            day.calculate().should.equal("1203")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("1146")
        }
    }

    given("day 2") {
        val day = load2017input(2) { Day2(it) }

        it("gets star for simple") {
            day.calculate().should.equal("47623")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("312")
        }
    }

    given("day 3") {
        val day = load2017input(3) { Day3(it) }

        it("gets star for simple") {
            day.calculate().should.equal("419")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("295229")
        }
    }

    given("day 4") {
        val day = load2017input(4) { Day4(it) }

        it("gets star for simple") {
            day.calculate().should.equal("383")
        }
        it("gets star for advanced") {
            day.calculateAdvanced().should.equal("265")
        }
    }

})