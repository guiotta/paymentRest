-- ---
-- Test Data
-- ---

-- INSERT INTO `rule` (`id`,`initial_day`,`final_day`) VALUES ('','','');
INSERT INTO `rule` (`id`, `initial_day`, `final_day`) VALUES(1, 1, 3);
INSERT INTO `rule` (`id`, `initial_day`, `final_day`) VALUES(2, 4, 5);
INSERT INTO `rule` (`id`, `initial_day`, `final_day`) VALUES(3, 5, 2147483647);
-- INSERT INTO `fine` (`id`,`percentage`,`interest`,`id_rule`) VALUES('','','','');
INSERT INTO `fine` (`id`,`percentage`,`interest`,`id_rule`) VALUES(1, 2, 0.1, 1);
INSERT INTO `fine` (`id`,`percentage`,`interest`,`id_rule`) VALUES(2, 3, 0.2, 2);
INSERT INTO `fine` (`id`,`percentage`,`interest`,`id_rule`) VALUES(3, 5, 0.3, 3);
-- INSERT INTO `bill` (`id`,`name`,`value`,`due_date`,`payday`,`late_days`,`id_fine`) VALUES('','','','','','','');