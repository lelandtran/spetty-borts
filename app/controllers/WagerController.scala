package controllers

import javax.inject.Inject
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}
import service.WagerService

import scala.concurrent.ExecutionContext

class WagerController @Inject()(cc: ControllerComponents, service: WagerService)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  def index = Action.async { implicit request: Request[AnyContent] =>
    service.first() map {res => Ok(res.toJson())}
  }
}
