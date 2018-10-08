package v1.wager

import javax.inject.Inject
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.ExecutionContext

class WagerController @Inject()(cc: ControllerComponents, service: WagerService)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  def index: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    service.findAll().map {res =>
      val jsonDocSeq = res map { doc => doc.toJson() };
      Ok(Json.toJson(jsonDocSeq))
    }
  }
}
