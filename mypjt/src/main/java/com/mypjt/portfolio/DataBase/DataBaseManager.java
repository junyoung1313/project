package com.mypjt.portfolio.DataBase;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//DAO객체에서 dataBase접근을위해 db정보를 반복적인 생성할경우 메모리를 많이 사용하게 되어 서버가 구동될때 db정보를 static객체로 만들어 dao객체를 사용할때 주입시켜주었습니다.

public class DataBaseManager
{

	public static SqlSessionFactory sqlmapper = null;
	

	//
	public static SqlSessionFactory getInstance()
	{
		if(sqlmapper == null)
		{
			try
			{
				Reader reader = Resources.getResourceAsReader("com/mypjt/portfolio/DataBase/SqlMapConfig.xml");//sqlmapper객체를 만들때 사용되어지는 정보를 외부에서 읽어드립니다.
				sqlmapper = new SqlSessionFactoryBuilder().build(reader);//reader객체에 읽어들인 db정보로 sqlsession객체를 생성합니다.
				reader.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return sqlmapper;
	}
}
