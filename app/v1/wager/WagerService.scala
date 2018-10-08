package v1.wager

import javax.inject.Inject

import scala.concurrent.{ExecutionContext, Future}

class WagerService @Inject()(resourceHandler: WagerResourceHandler)(implicit ec: ExecutionContext) {

  def findAll(): Future[Seq[WagerResource]] = {
    resourceHandler.findAll()
  }
}
