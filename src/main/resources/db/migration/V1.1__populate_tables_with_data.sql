-- ---
-- Test Data
-- ---

-- INSERT INTO `rule` (`id`,`initial_day`,`final_day`) VALUES ('','','');
INSERT INTO `rule` (`id`, `initial_day`, `final_day`) VALUES(1, -9223372036854775807, 0);
INSERT INTO `rule` (`id`, `initial_day`, `final_day`) VALUES(2, 1, 3);
INSERT INTO `rule` (`id`, `initial_day`, `final_day`) VALUES(3, 4, 5);
INSERT INTO `rule` (`id`, `initial_day`, `final_day`) VALUES(4, 6, 9223372036854775807);
-- INSERT INTO `fine` (`id`,`percentage`,`interest`,`id_rule`) VALUES('','','','');
INSERT INTO `fine` (`id`,`percentage`,`interest`,`id_rule`) VALUES(1, 0, 0, 1);
INSERT INTO `fine` (`id`,`percentage`,`interest`,`id_rule`) VALUES(2, 2, 0.1, 2);
INSERT INTO `fine` (`id`,`percentage`,`interest`,`id_rule`) VALUES(3, 3, 0.2, 3);
INSERT INTO `fine` (`id`,`percentage`,`interest`,`id_rule`) VALUES(4, 5, 0.3, 4);
-- INSERT INTO `bill` (`id`,`name`,`value`,`due_date`,`payday`,`late_days`,`id_fine`) VALUES('','','','','','','');