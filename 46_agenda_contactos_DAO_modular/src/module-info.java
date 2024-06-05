module modulo_agenda {
	exports view;
	exports dao;
	exports service;
	exports model;
	exports locator;

	requires java.sql;
	requires lombok;
	requires mysql.connector.j;
}