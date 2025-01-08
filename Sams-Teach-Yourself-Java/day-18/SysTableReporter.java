// Listing 18.1 The Full Text of SysTableReporter.java

import java.sql.* ;

public class SysTableReporter {

    public static void main(String[] arguments) {
        String data = "jdbc:derby:/home/dstevenson/Derby/sample;create=true";
        try (
            Connection conn = DriverManager.getConnection(data, "app", "APP");
            Statement st = conn.createStatement();
        ) {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            ResultSet rec = st.executeQuery(
                "select *" +
                "from SYS.SYSTABLES " +
                "order by TABLENAME");

            while (rec.next()) {
                System.out.println("TABLEID:\t" + rec.getString(1));
                System.out.println("TABLENAME:\t" + rec.getString(2));
                System.out.println("TABLETYPE:\t" + rec.getString(3));
                System.out.println("SCHEMAID:\t" + rec.getString(4));
                System.out.println();
            }
        } 
        catch (SQLException s) {
            System.out.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
            System.out.println(s.getStackTrace());
        }
        catch (Exception e) {
            System.out.println("Error: " + e.toString() + e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
}

// $ java SysTableReporter 
// TABLEID:        c013800d-00d7-ddbd-08ce-000a0a411400
// TABLENAME:      SYSALIASES
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900

// TABLEID:        80000056-00d0-fd77-3ed8-000a0a0b1900
// TABLENAME:      SYSCHECKS
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900

// TABLEID:        286cc01e-0103-0e39-b8e7-00000010f010
// TABLENAME:      SYSCOLPERMS
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900

// TABLEID:        8000001e-00d0-fd77-3ed8-000a0a0b1900
// TABLENAME:      SYSCOLUMNS
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900

// TABLEID:        80000010-00d0-fd77-3ed8-000a0a0b1900
// TABLENAME:      SYSCONGLOMERATES
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900

// TABLEID:        8000002f-00d0-fd77-3ed8-000a0a0b1900
// TABLENAME:      SYSCONSTRAINTS
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900

// TABLEID:        8000003e-00d0-fd77-3ed8-000a0a0b1900
// TABLENAME:      SYSDEPENDS
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900

// TABLEID:        c013800d-00f8-5b70-bea3-00000019ed88
// TABLENAME:      SYSDUMMY1
// TABLETYPE:      S
// SCHEMAID:       c013800d-00f8-5b53-28a9-00000019ed88

// TABLEID:        80000000-00d3-e222-873f-000a0a0b1900
// TABLENAME:      SYSFILES
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900

// TABLEID:        8000005b-00d0-fd77-3ed8-000a0a0b1900
// TABLENAME:      SYSFOREIGNKEYS
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900

// TABLEID:        80000039-00d0-fd77-3ed8-000a0a0b1900
// TABLENAME:      SYSKEYS
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900

// TABLEID:        9810800c-0121-c5e1-a2f5-00000043e718
// TABLENAME:      SYSPERMS
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900

// TABLEID:        e03f4017-0115-382c-08df-ffffe275b270
// TABLENAME:      SYSROLES
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900

// TABLEID:        2057c01b-0103-0e39-b8e7-00000010f010
// TABLENAME:      SYSROUTINEPERMS
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900

// TABLEID:        80000022-00d0-fd77-3ed8-000a0a0b1900
// TABLENAME:      SYSSCHEMAS
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900

// TABLEID:        9810800c-0121-c5e2-e794-00000043e718
// TABLENAME:      SYSSEQUENCES
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900

// TABLEID:        80000000-00d1-15f7-ab70-000a0a0b1500
// TABLENAME:      SYSSTATEMENTS
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900

// TABLEID:        f81e0010-00e3-6612-5a96-009e3a3b5e00
// TABLENAME:      SYSSTATISTICS
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900

// TABLEID:        b8450018-0103-0e39-b8e7-00000010f010
// TABLENAME:      SYSTABLEPERMS
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900

// TABLEID:        80000018-00d0-fd77-3ed8-000a0a0b1900
// TABLENAME:      SYSTABLES
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900

// TABLEID:        c013800d-00d7-c025-4809-000a0a411200
// TABLENAME:      SYSTRIGGERS
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900

// TABLEID:        9810800c-0134-14a5-40c1-000004f61f90
// TABLENAME:      SYSUSERS
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900

// TABLEID:        8000004d-00d0-fd77-3ed8-000a0a0b1900
// TABLENAME:      SYSVIEWS
// TABLETYPE:      S
// SCHEMAID:       8000000d-00d0-fd77-3ed8-000a0a0b1900