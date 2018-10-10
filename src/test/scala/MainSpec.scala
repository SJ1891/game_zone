import org.scalatest.Matchers._
import org.scalatest.WordSpec

class MainSpec extends WordSpec {

  "return2" should {
    "return2" in {
      Main.return2() shouldBe 2
    }
  }

}
