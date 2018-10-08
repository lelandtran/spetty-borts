package v1.wager

import javax.inject.Inject
import org.mongodb.scala._

import scala.concurrent.{ExecutionContext, Future}

class WagerMongoRepository @Inject()()(implicit ec: ExecutionContext) extends WagerRepository {

  // Use a Connection String
  val mongoClient: MongoClient = MongoClient("mongodb://localhost:27017")

  val database: MongoDatabase = mongoClient.getDatabase("bortsdb")

  def findAll(): Future[Seq[WagerData]] = {
    database.getCollection("wager")
      .find().toFuture()
      .map { docSeq =>
        docSeq map { doc =>
          WagerData(doc.getObjectId("_id").toHexString, doc.getString("title"),
            doc.getString("clause"), doc.getInteger("amount"), doc.getObjectId("owner").toHexString)
        }
      }
  }
}
