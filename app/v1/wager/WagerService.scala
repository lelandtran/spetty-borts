package v1.wager

import javax.inject.Inject
import org.mongodb.scala.Document

import scala.concurrent.{ExecutionContext, Future}

class WagerService @Inject()(dao: WagerDao)(implicit ec: ExecutionContext) {

  def findAll(): Future[Seq[Document]] = {
    dao.findAll()
  }
}
