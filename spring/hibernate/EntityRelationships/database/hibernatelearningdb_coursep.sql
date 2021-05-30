-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: hibernatelearningdb
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `coursep`
--

DROP TABLE IF EXISTS `coursep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coursep` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=537 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursep`
--

LOCK TABLES `coursep` WRITE;
/*!40000 ALTER TABLE `coursep` DISABLE KEYS */;
INSERT INTO `coursep` VALUES (44,'4343'),(55,'fgdfg'),(56,'	name56'),(57,'	name57'),(58,'	name58'),(59,'	name59'),(60,'	name60'),(61,'	name61'),(62,'	name62'),(63,'	name63'),(64,'	name64'),(65,'	name65'),(66,'	name66'),(67,'	name67'),(68,'	name68'),(69,'	name69'),(70,'	name70'),(71,'	name71'),(72,'	name72'),(73,'	name73'),(74,'	name74'),(75,'	name75'),(76,'	name76'),(77,'	name77'),(78,'	name78'),(79,'	name79'),(80,'	name80'),(81,'	name81'),(82,'	name82'),(83,'	name83'),(84,'	name84'),(85,'	name85'),(86,'	name86'),(87,'	name87'),(88,'	name88'),(89,'	name89'),(90,'	name90'),(91,'	name91'),(92,'	name92'),(93,'	name93'),(94,'	name94'),(95,'	name95'),(96,'	name96'),(97,'	name97'),(98,'	name98'),(99,'	name99'),(100,'	name100'),(101,'	name101'),(102,'	name102'),(103,'	name103'),(104,'	name104'),(105,'	name105'),(106,'	name106'),(107,'	name107'),(108,'	name108'),(109,'	name109'),(110,'	name110'),(111,'	name111'),(112,'	name112'),(113,'	name113'),(114,'	name114'),(115,'	name115'),(116,'	name116'),(117,'	name117'),(118,'	name118'),(119,'	name119'),(120,'	name120'),(121,'	name121'),(122,'	name122'),(123,'	name123'),(124,'	name124'),(125,'	name125'),(126,'	name126'),(127,'	name127'),(128,'	name128'),(129,'	name129'),(130,'	name130'),(131,'	name131'),(132,'	name132'),(133,'	name133'),(134,'	name134'),(135,'	name135'),(136,'	name136'),(137,'	name137'),(138,'	name138'),(139,'	name139'),(140,'	name140'),(141,'	name141'),(142,'	name142'),(143,'	name143'),(144,'	name144'),(145,'	name145'),(146,'	name146'),(147,'	name147'),(148,'	name148'),(149,'	name149'),(150,'	name150'),(151,'	name151'),(152,'	name152'),(153,'	name153'),(154,'	name154'),(155,'	name155'),(156,'	name156'),(157,'	name157'),(158,'	name158'),(159,'	name159'),(160,'	name160'),(161,'	name161'),(162,'	name162'),(163,'	name163'),(164,'	name164'),(165,'	name165'),(166,'	name166'),(167,'	name167'),(168,'	name168'),(169,'	name169'),(170,'	name170'),(171,'	name171'),(172,'	name172'),(173,'	name173'),(174,'	name174'),(175,'	name175'),(176,'	name176'),(177,'	name177'),(178,'	name178'),(179,'	name179'),(180,'	name180'),(181,'	name181'),(182,'	name182'),(183,'	name183'),(184,'	name184'),(185,'	name185'),(186,'	name186'),(187,'	name187'),(188,'	name188'),(189,'	name189'),(190,'	name190'),(191,'	name191'),(192,'	name192'),(193,'	name193'),(194,'	name194'),(195,'	name195'),(196,'	name196'),(197,'	name197'),(198,'	name198'),(199,'	name199'),(200,'	name200'),(201,'	name201'),(202,'	name202'),(203,'	name203'),(204,'	name204'),(205,'	name205'),(206,'	name206'),(207,'	name207'),(208,'	name208'),(209,'	name209'),(210,'	name210'),(211,'	name211'),(212,'	name212'),(213,'	name213'),(214,'	name214'),(215,'	name215'),(216,'	name216'),(217,'	name217'),(218,'	name218'),(219,'	name219'),(220,'	name220'),(221,'	name221'),(222,'	name222'),(223,'	name223'),(224,'	name224'),(225,'	name225'),(226,'	name226'),(227,'	name227'),(228,'	name228'),(229,'	name229'),(230,'	name230'),(231,'	name231'),(232,'	name232'),(233,'	name233'),(234,'	name234'),(235,'	name235'),(236,'	name236'),(237,'	name237'),(238,'	name238'),(239,'	name239'),(240,'	name240'),(241,'	name241'),(242,'	name242'),(243,'	name243'),(244,'	name244'),(245,'	name245'),(246,'	name246'),(247,'	name247'),(248,'	name248'),(249,'	name249'),(250,'	name250'),(251,'	name251'),(252,'	name252'),(253,'	name253'),(254,'	name254'),(255,'	name255'),(256,'	name256'),(257,'	name257'),(258,'	name258'),(259,'	name259'),(260,'	name260'),(261,'	name261'),(262,'	name262'),(263,'	name263'),(264,'	name264'),(265,'	name265'),(266,'	name266'),(267,'	name267'),(268,'	name268'),(269,'	name269'),(270,'	name270'),(271,'	name271'),(272,'	name272'),(273,'	name273'),(274,'	name274'),(275,'	name275'),(276,'	name276'),(277,'	name277'),(278,'	name278'),(279,'	name279'),(280,'	name280'),(281,'	name281'),(282,'	name282'),(283,'	name283'),(284,'	name284'),(285,'	name285'),(286,'	name286'),(287,'	name287'),(288,'	name288'),(289,'	name289'),(290,'	name290'),(291,'	name291'),(292,'	name292'),(293,'	name293'),(294,'	name294'),(295,'	name295'),(296,'	name296'),(297,'	name297'),(298,'	name298'),(299,'	name299'),(300,'	name300'),(301,'	name301'),(302,'	name302'),(303,'	name303'),(304,'	name304'),(305,'	name305'),(306,'	name306'),(307,'	name307'),(308,'	name308'),(309,'	name309'),(310,'	name310'),(311,'	name311'),(312,'	name312'),(313,'	name313'),(314,'	name314'),(315,'	name315'),(316,'	name316'),(317,'	name317'),(318,'	name318'),(319,'	name319'),(320,'	name320'),(321,'	name321'),(322,'	name322'),(323,'	name323'),(324,'	name324'),(325,'	name325'),(326,'	name326'),(327,'	name327'),(328,'	name328'),(329,'	name329'),(330,'	name330'),(331,'	name331'),(332,'	name332'),(333,'	name333'),(334,'	name334'),(335,'	name335'),(336,'	name336'),(337,'	name337'),(338,'	name338'),(339,'	name339'),(340,'	name340'),(341,'	name341'),(342,'	name342'),(343,'	name343'),(344,'	name344'),(345,'	name345'),(346,'	name346'),(347,'	name347'),(348,'	name348'),(349,'	name349'),(350,'	name350'),(351,'	name351'),(352,'	name352'),(353,'	name353'),(354,'	name354'),(355,'	name355'),(356,'	name356'),(357,'	name357'),(358,'	name358'),(359,'	name359'),(360,'	name360'),(361,'	name361'),(362,'	name362'),(363,'	name363'),(364,'	name364'),(365,'	name365'),(366,'	name366'),(367,'	name367'),(368,'	name368'),(369,'	name369'),(370,'	name370'),(371,'	name371'),(372,'	name372'),(373,'	name373'),(374,'	name374'),(375,'	name375'),(376,'	name376'),(377,'	name377'),(378,'	name378'),(379,'	name379'),(380,'	name380'),(381,'	name381'),(382,'	name382'),(383,'	name383'),(384,'	name384'),(385,'	name385'),(386,'	name386'),(387,'	name387'),(388,'	name388'),(389,'	name389'),(390,'	name390'),(391,'	name391'),(392,'	name392'),(393,'	name393'),(394,'	name394'),(395,'	name395'),(396,'	name396'),(397,'	name397'),(398,'	name398'),(399,'	name399'),(400,'	name400'),(401,'	name401'),(402,'	name402'),(403,'	name403'),(404,'	name404'),(405,'	name405'),(406,'	name406'),(407,'	name407'),(408,'	name408'),(409,'	name409'),(410,'	name410'),(411,'	name411'),(412,'	name412'),(413,'	name413'),(414,'	name414'),(415,'	name415'),(416,'	name416'),(417,'	name417'),(418,'	name418'),(419,'	name419'),(420,'	name420'),(421,'	name421'),(422,'	name422'),(423,'	name423'),(424,'	name424'),(425,'	name425'),(426,'	name426'),(427,'	name427'),(428,'	name428'),(429,'	name429'),(430,'	name430'),(431,'	name431'),(432,'	name432'),(433,'	name433'),(434,'	name434'),(435,'	name435'),(436,'	name436'),(437,'	name437'),(438,'	name438'),(439,'	name439'),(440,'	name440'),(441,'	name441'),(442,'	name442'),(443,'	name443'),(444,'	name444'),(445,'	name445'),(446,'	name446'),(447,'	name447'),(448,'	name448'),(449,'	name449'),(450,'	name450'),(451,'	name451'),(452,'	name452'),(453,'	name453'),(454,'	name454'),(455,'	name455'),(456,'	name456'),(457,'	name457'),(458,'	name458'),(459,'	name459'),(460,'	name460'),(461,'	name461'),(462,'	name462'),(463,'	name463'),(464,'	name464'),(465,'	name465'),(466,'	name466'),(467,'	name467'),(468,'	name468'),(469,'	name469'),(470,'	name470'),(471,'	name471'),(472,'	name472'),(473,'	name473'),(474,'	name474'),(475,'	name475'),(476,'	name476'),(477,'	name477'),(478,'	name478'),(479,'	name479'),(480,'	name480'),(481,'	name481'),(482,'	name482'),(483,'	name483'),(484,'	name484'),(485,'	name485'),(486,'	name486'),(487,'	name487'),(488,'	name488'),(489,'	name489'),(490,'	name490'),(491,'	name491'),(492,'	name492'),(493,'	name493'),(494,'	name494'),(495,'	name495'),(496,'	name496'),(497,'	name497'),(498,'	name498'),(499,'	name499'),(500,'	name500'),(501,'	name501'),(502,'	name502'),(503,'	name503'),(504,'	name504'),(505,'	name505'),(506,'	name506'),(507,'	name507'),(508,'	name508'),(509,'	name509'),(510,'	name510'),(511,'	name511'),(512,'	name512'),(513,'	name513'),(514,'	name514'),(515,'	name515'),(516,'	name516'),(517,'	name517'),(518,'	name518'),(519,'	name519'),(520,'	name520'),(521,'	name521'),(522,'	name522'),(523,'	name523'),(524,'	name524'),(525,'	name525'),(526,'	name526'),(527,'	name527'),(528,'	name528'),(529,'	name529'),(530,'	name530'),(531,'	name531'),(532,'	name532'),(533,'	name533'),(534,'	name534'),(535,'	name535'),(536,'	name536');
/*!40000 ALTER TABLE `coursep` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-30 14:33:10
