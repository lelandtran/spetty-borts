package v1.wager

import javax.inject.Inject
import play.api.data.Form
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

case class WagerFormInput(title: String, amount: Int, clause: String)

class WagerController @Inject()(cc: ControllerComponents, service: WagerService)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  private val form: Form[WagerFormInput] = {
    import play.api.data.Forms._
    Form (
      mapping(
        "title" -> nonEmptyText,
        "amount" -> number,
        "clause" -> text
      )(WagerFormInput.apply)(WagerFormInput.unapply)
    )
  }

  def index: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    service.findAll().map {res =>
      val jsonDocSeq = res map { doc => doc };
      Ok(Json.toJson(jsonDocSeq))
    }
  }

  def process: Action[AnyContent] = Action.async { implicit request =>
    processJsonWager()
  }

  private def processJsonWager[A]()(implicit request: Request[A]): Future[Result] = {
    def failure(badForm: Form[WagerFormInput]) = {
//      Future.successful(BadRequest(badForm.errorsAsJson))
      Future.successful(BadRequest)
    }

    def success(input: WagerFormInput) = {
      Future {
        Created
      }
    }

    form.bindFromRequest().fold(failure, success)
  }
}
