package v1.wager

import scala.concurrent.Future


case class WagerData(id: String, title: String, clause: String, amount: Int, owner: String)

trait WagerRepository {
  def findAll(): Future[Seq[WagerData]];
}