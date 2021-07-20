package dev.support;

import qio.annotate.Config;
import qio.annotate.Dependency;
import qio.annotate.Property;
import qio.jdbc.BasicDataSource;

import javax.sql.DataSource;

@Config
public class DbConfig {

    @Property("db.url")
    String dbUrl;

    @Property("db.user")
    String dbUser;

    @Property("db.pass")
    String dbPass;

    @Property("db.driver")
    String dbDriver;

    @Dependency
    public DataSource dataSource(){
        DataSource dataSource = new BasicDataSource.Builder()
                .driver(dbDriver)
                .url(dbUrl)
                .username(dbUser)
                .password(dbPass)
                .build();
        return dataSource;
    }

}
