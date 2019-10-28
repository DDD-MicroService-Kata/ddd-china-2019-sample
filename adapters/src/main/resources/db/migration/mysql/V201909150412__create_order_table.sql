CREATE TABLE t_purchase_order
(
	`id` INT auto_increment,
	code VARCHAR(200) NOT NULL,
	CONSTRAINT t_purchase_order_pk
		PRIMARY KEY (`id`)
);