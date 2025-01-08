# Sams Teach Yourself Java in 21 Days

## Day 18: Accessing Databases with JDBC 4.1 and Derby

Java Database Connectivity (JDBC)

Apache Derby, an open source dataabase maintained by the Apache Software Foundation.

### Java Database Connectivity

A class called a _driver_ acts as a bridge to the database source.

SQL is the industry-standard approach to accessing relational databases.

The JDBC library includes classes for each of the tasks commonly associated with database usage:

* Making a connection to the database
* Creating a statement using SQL
* Executing that SQL query in the database
* Viewing the resulting records

#### Database Drivers

[Install DerbyDB in Ubuntu](https://stackoverflow.com/questions/70213994/install-derby-datebase-in-linux-ubuntu)

```
mkdir /opt/Apache
cp db-derby-10.15.2.0-bin.tar.gz /opt/Apache
cd /opt/Apache
tar xzvf db-derby-10.15.2.0-bin.tar.gz
```

You can put in your shell startup script (.bashrc or .zshrc, etc.):

```
export DERBY_INSTALL=/opt/Apache/db-derby-10.15.2.0-bin
export CLASSPATH=$DERBY_INSTALL/lib/derby.jar:$DERBY_INSTALL/lib/derbytools.jar:$DERBY_INSTALL/lib/derbyoptionaltools.jar:$DERBY_INSTALL/lib/derbyshared.jar:.
```

java org.apache.derby.tools.sysinfo