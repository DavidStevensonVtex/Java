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

#### Examining a Database

```
dstevenson@dstevensonlinux1:/bin$ ll $DERBY_INSTALL/bin/*start*
-rwxr-xr-x 1 root root 5868 Feb  4  2020 /opt/Apache/db-derby-10.15.2.0-bin/bin/startNetworkServer*
-rwxr-xr-x 1 root root 1397 Jan  6  2019 /opt/Apache/db-derby-10.15.2.0-bin/bin/startNetworkServer.bat*
```

```
$ sudo $DERBY_INSTALL/bin/startNetworkServer
Wed Jan 08 16:21:25 EST 2025 : Security manager installed using the Basic server security policy.
Wed Jan 08 16:21:25 EST 2025 : Apache Derby Network Server - 10.15.2.0 - (1873585) started and ready to accept connections on port 1527
```

[DerbyDB Tools](https://www.baeldung.com/java-apache-derby)

Tool for performing queries:

```
$DERBY_INSTALL/bin/ij
ij version 10.15
ij> 
```

```
dstevenson@dstevensonlinux1:~$ java org.apache.derby.tools.ij
ij version 10.15
ij> connect 'jdbc:derby:sample;create=true';
ij> SELECT * FROM SYS.SYSTABLES ;
TABLEID                             |TABLENAME                                                                                                                       |&|SCHEMAID                            |&
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
80000010-00d0-fd77-3ed8-000a0a0b1900|SYSCONGLOMERATES                                                                                                                |S|8000000d-00d0-fd77-3ed8-000a0a0b1900|R
80000018-00d0-fd77-3ed8-000a0a0b1900|SYSTABLES      
```

* [DerbyDB Tutorial](https://db.apache.org/derby/papers/DerbyTut/index.html)
* [IJ Intro](https://db.apache.org/derby/papers/DerbyTut/ij_intro.html)