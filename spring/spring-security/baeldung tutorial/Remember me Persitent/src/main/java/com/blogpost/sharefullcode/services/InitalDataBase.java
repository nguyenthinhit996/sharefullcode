package com.blogpost.sharefullcode.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogpost.sharefullcode.PersistenceConfigJDBC;

@Service
public class InitalDataBase {
	
	@Autowired
	PersistenceConfigJDBC persistenceConfigJDBC;
	
	@PostConstruct
	public void initalTableDataBase() throws SQLException, FileNotFoundException, IOException {
		Connection con = persistenceConfigJDBC.dataSource().getConnection();
		String query = IOUtils.toString(getFileFromResourceAsStream("sql/sqlcreatetable.sql"),Charset.forName("UTF-8"));
		Statement stament = con.createStatement();
		
		String[] queryArray = query.split(";");
		
		for(String in : queryArray) {
			if(!in.trim().equals(""))
			{
				stament.execute(in);
			}
		}
		
		stament.close();
		con.close();
	}
	
	// https://mkyong.com/java/java-read-a-file-from-resources-folder/
	// get a file from the resources folder
    // works everywhere, IDEA, unit test and JAR file.
    private InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }
}
