DELIMITER $$
CREATE TRIGGER log_user_manager_delete before DELETE on user_manager
FOR EACH ROW
BEGIN
Insert into user_manager_archieve(user_id,manager_id,start_date,end_date) 
values(old.user_id,old.manager_id,old.assigned_date,curdate());
END