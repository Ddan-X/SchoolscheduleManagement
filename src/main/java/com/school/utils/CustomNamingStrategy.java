package com.school.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomNamingStrategy extends PhysicalNamingStrategyStandardImpl{
	private static final long serialVersionUID = 1L;
	
	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
		// TODO Auto-generated method stub
		String newTableNameString = name.getText().concat("_tbl");
		return Identifier.toIdentifier(newTableNameString);
	}
}
