DROP TABLE IF EXISTS `new_schemasss`.`checkingoutroomdamaged`, `new_schemasss`.`dailyworking`, `new_schemasss`.`datework`, `new_schemasss`.`detailservices`, `new_schemasss`.`production`, `new_schemasss`.`room`, `new_schemasss`.`staff`, `new_schemasss`.`ticketbooking`, `new_schemasss`.`ticketcheckoutroom`, `new_schemasss`.`typeofroom`;
CREATE TABLE `staff` (
  `idstaff` varchar(50)  NOT NULL,
  `username` varchar(255)  NOT NULL,
  `pass` varchar(500)  NOT NULL,
  `role` varchar(45)  NOT NULL,
  `datework` date NOT NULL,
  `salarymonth` decimal(18,0) NOT NULL,
  `bonussalary` decimal(18,0) DEFAULT NULL,
  `status` varchar(45)  DEFAULT NULL,
  PRIMARY KEY (`idstaff`)
);

CREATE TABLE `typeofroom` (
  `nametypeofroom` varchar(50)  NOT NULL,
  `roomrateshours` decimal(18,0) NOT NULL,
  `roomratesdates` decimal(18,0) NOT NULL,
  `numberinroom` int NOT NULL,
  `roomratescharge` decimal(18,0) NOT NULL,
  PRIMARY KEY (`nametypeofroom`)
);

CREATE TABLE `room` (
  `idroom` int NOT NULL,
  `status` varchar(45)  DEFAULT NULL,
  `nametyperoom` varchar(50)  DEFAULT NULL,
  PRIMARY KEY (`idroom`),
  KEY `f_room_typeofroom` (`nametyperoom`),
  CONSTRAINT `f_room_typeofroom` FOREIGN KEY (`nametyperoom`) REFERENCES `typeofroom` (`nametypeofroom`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `production` (
  `idproduction` varchar(50)  NOT NULL,
  `nameproduct` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `extention` varchar(455)  DEFAULT NULL,
  `productrates` decimal(18,0) NOT NULL,
  `img` varchar(2024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` varchar(45)  DEFAULT NULL,
  `status` varchar(45)  DEFAULT NULL,
  PRIMARY KEY (`idproduction`)
);


CREATE TABLE `datework` (
  `iddatework` date NOT NULL,
  `listuserworkfullday` varchar(5000)  DEFAULT NULL,
  `listuserhalfday` varchar(5000)  DEFAULT NULL,
  `regulation` int NOT NULL,
  PRIMARY KEY (`iddatework`)
);


CREATE TABLE `dailyworking` (
  `idtoday` date NOT NULL,
  `idstaffwork` varchar(50)  NOT NULL,
  `timestart` time DEFAULT NULL,
  `timeend` time DEFAULT NULL,
  `note` varchar(255)  DEFAULT NULL,
  `idstaffmanagement` varchar(50)  DEFAULT NULL,
  `usernamestaff` varchar(255)  DEFAULT NULL,
  PRIMARY KEY (`idtoday`,`idstaffwork`),
  KEY `f_work_staff` (`idstaffwork`),
  KEY `f_work_today_staffmanagemenmt` (`idstaffmanagement`),
  CONSTRAINT `f_work_staff` FOREIGN KEY (`idstaffwork`) REFERENCES `staff` (`idstaff`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `f_work_today` FOREIGN KEY (`idtoday`) REFERENCES `datework` (`iddatework`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `f_work_today_staffmanagemenmt` FOREIGN KEY (`idstaffmanagement`) REFERENCES `staff` (`idstaff`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `ticketbooking` (
  `idticketbooking` varchar(50)  NOT NULL,
  `iduserrentroom` varchar(50)  NOT NULL,
  `usernamerentroom` varchar(255)  NOT NULL,
  `timestamprent` timestamp NOT NULL,
  `idstaffreception` varchar(50)  NOT NULL,
  `numberroom` int NOT NULL,
  `numberinroom` int DEFAULT NULL,
  `status` varchar(45)  DEFAULT NULL,
  PRIMARY KEY (`idticketbooking`),
  KEY `f_room_staffreception` (`idstaffreception`),
  KEY `f_room_ticketbooking` (`numberroom`),
  CONSTRAINT `f_room_staffreception` FOREIGN KEY (`idstaffreception`) REFERENCES `staff` (`idstaff`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `f_room_ticketbooking` FOREIGN KEY (`numberroom`) REFERENCES `room` (`idroom`) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE `detailservices` (
  `idticketbooking` varchar(50)  NOT NULL,
  `idproduct` varchar(50)  NOT NULL,
  `idstaffservicesrepo` varchar(50)  DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `startrent` timestamp NULL DEFAULT NULL,
  `endrent` timestamp NULL DEFAULT NULL,
  `status` varchar(45)  NOT NULL,
  `sumaryservices` decimal(18,0) DEFAULT NULL,
  PRIMARY KEY (`idticketbooking`,`idproduct`),
  KEY `f_detail_product` (`idproduct`),
  KEY `f_detailservice_staffsupport` (`idstaffservicesrepo`),
  CONSTRAINT `f_detail_product` FOREIGN KEY (`idproduct`) REFERENCES `production` (`idproduction`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `f_detailservice_staffsupport` FOREIGN KEY (`idstaffservicesrepo`) REFERENCES `staff` (`idstaff`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `f_ticket_detail` FOREIGN KEY (`idticketbooking`) REFERENCES `ticketbooking` (`idticketbooking`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `ticketcheckoutroom` (
  `idticketcheckoutroom` varchar(50)  NOT NULL,
  `idticketbooking` varchar(50)  NOT NULL,
  `timeendrent` timestamp NULL DEFAULT NULL,
  `idstaffreceptionsupport` varchar(50)  NOT NULL,
  `numberroomrent` int DEFAULT NULL,
  `sumaryratesandservices` decimal(18,0) DEFAULT NULL,
  `status` varchar(45)  DEFAULT NULL,
  `raterentroom` decimal(18,0) DEFAULT NULL,
  `rateservices` decimal(18,0) DEFAULT NULL,
  `roomsubcharge` decimal(18,0) DEFAULT NULL,
  `roomdamaged` decimal(18,0) DEFAULT NULL,
  `timerent` varchar(205)  DEFAULT NULL,
  PRIMARY KEY (`idticketcheckoutroom`),
  KEY `f_out_inroom` (`idticketbooking`),
  KEY `f_outroom_staffsupport` (`idstaffreceptionsupport`),
  CONSTRAINT `f_out_inroom` FOREIGN KEY (`idticketbooking`) REFERENCES `ticketbooking` (`idticketbooking`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `f_outroom_staffsupport` FOREIGN KEY (`idstaffreceptionsupport`) REFERENCES `staff` (`idstaff`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `checkingoutroomdamaged` (
  `idcheckingoutroomdamaded` varchar(50)  NOT NULL,
  `idcheckoutroom` varchar(50)  DEFAULT NULL,
  `listproductdamaded` varchar(1000)  DEFAULT NULL,
  `sumaryindemnify` decimal(18,0) NOT NULL,
  `idstaffchecking` varchar(50)  DEFAULT NULL,
  `idticketbooking` varchar(50)  DEFAULT NULL,
  `status` varchar(45)  DEFAULT NULL,
  PRIMARY KEY (`idcheckingoutroomdamaded`),
  KEY `f_damaded_outroom` (`idcheckoutroom`),
  KEY `f_damaded_staff` (`idstaffchecking`),
  CONSTRAINT `f_damaded_outroom` FOREIGN KEY (`idcheckoutroom`) REFERENCES `ticketcheckoutroom` (`idticketcheckoutroom`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `f_damaded_staff` FOREIGN KEY (`idstaffchecking`) REFERENCES `staff` (`idstaff`) ON DELETE CASCADE ON UPDATE CASCADE
);

