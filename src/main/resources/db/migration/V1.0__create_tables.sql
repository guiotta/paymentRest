-- ---
-- Globals
-- ---

-- SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
-- SET FOREIGN_KEY_CHECKS=0;

-- ---
-- Table 'bill'
-- 
-- ---

DROP TABLE IF EXISTS `bill`;
        
CREATE TABLE `bill` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  `value` DECIMAL NOT NULL,
  `due_date` DATE NOT NULL,
  `payday` DATE NOT NULL,
  `late_days` INTEGER NOT NULL,
  `id_fine` INTEGER NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'fine'
-- 
-- ---

DROP TABLE IF EXISTS `fine`;
        
CREATE TABLE `fine` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `percentage` INTEGER NOT NULL,
  `interest` DECIMAL NOT NULL,
  `id_rule` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'rule'
-- 
-- ---

DROP TABLE IF EXISTS `rule`;
        
CREATE TABLE `rule` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `initial_day` INTEGER NULL,
  `final_day` INTEGER NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Foreign Keys 
-- ---

ALTER TABLE `bill` ADD FOREIGN KEY (id_fine) REFERENCES `fine` (`id`);
ALTER TABLE `fine` ADD FOREIGN KEY (id_rule) REFERENCES `rule` (`id`);

-- ---
-- Table Properties
-- ---

-- ALTER TABLE `bill` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `fine` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `rule` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;