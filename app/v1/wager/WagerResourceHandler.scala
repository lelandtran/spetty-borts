package v1.wager

import javax.inject.Inject
import play.api.libs.json.{JsValue, Json, Writes}

import scala.concurrent.ExecutionContext

case class WagerResource(id: String, title: String, amount: Int, clause: String, owner: String)

object WagerResource {
  implicit val implicitWrites = new Writes[WagerResource] {
    def writes(wager: WagerResource): JsValue = {
      Json.obj(
        "id" -> wager.id,
        "title" -> wager.title,
        "amount" -> wager.amount,
        "clause" -> wager.clause,
        "owner" -> wager.owner
      )
    }
  }
}
class WagerResourceHandler @Inject()(wagerRepository: WagerMongoRepository)(implicit ec: ExecutionContext) {

  def findAll()= {
    wagerRepository.findAll() map { wagerData =>
      wagerData map { datum =>
        WagerResource(datum.id, datum.title, datum.amount, datum.clause, datum.owner)
      }
    }
  }
}
