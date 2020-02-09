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
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  `value` DECIMAL(11,2) NOT NULL,
  `updated_value` DECIMAL(11,2) NOT NULL,
  `due_date` DATE NOT NULL,
  `payday` DATE NOT NULL,
  `late_days` BIGINT NOT NULL,
  `id_fine` BIGINT NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'fine'
-- 
-- ---

DROP TABLE IF EXISTS `fine`;
        
CREATE TABLE `fine` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `percentage` INTEGER NOT NULL,
  `interest` DECIMAL(11,1) NOT NULL,
  `id_rule` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'rule'
-- 
-- ---

DROP TABLE IF EXISTS `rule`;
        
CREATE TABLE `rule` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `initial_day` BIGINT NULL,
  `final_day` BIGINT NULL,
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