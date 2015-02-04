
DELIMITER $$
CREATE TRIGGER insert_date_user_manager_delete BEFORE Insert on user_manager
FOR EACH ROW BEGIN
set new.assigned_date = now();
END;
