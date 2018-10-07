package service

import dao.WagerDao
import javax.inject.Inject

import scala.concurrent.{ExecutionContext, Future}

class WagerService @Inject()(dao: WagerDao)(implicit ec: ExecutionContext) {

  def first() = {
    dao.first()
  }
}
