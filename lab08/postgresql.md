# Setup postgresql

In the following tutorial you will setup PostgreSQL with pgAdmin. PostgreSQL is a DB like MySQL, MariaDB, DB2, etc. PgAdmin will help you to connect to your DB instance and execute scripts (This can be done by other services like DBeaver, HeidiSQL, etc).

# Disclaimer 
The following tutorial was created on Mac Monterey but it's the same for Windows OS. You can use either terminal or GUI for the whole instalation.

# Steps
1. Download PostgreSQL from **[here](https://www.postgresql.org/download/)**
    ![](images/download_link.png)
    ![](images/download_link_1.png)
    ![](images/download_link_2.png)

2. Start the installation - exe/msi file for windows, pkg for mac
    ![](images/start_installation.png)
3. Wizard (next > next > next)
   1. Next ![](images/installation.png)
   2. Next
   ![](images/installation_1.png)
   3. We want all options ticked
   ![](images/installation_2.png)
   4. Next
   ![](images/installation_3.png)
   5. Save your default password
   ![](images/installation_4.png)
   6. Use the default port (for you 5432)
   ![](images/installation_5.png)
   7. Next
   ![](images/installation_6.png)
   8. Next
   ![](images/installation_7.png)
   9. Next
   ![](images/installation_8.png)
   10.  StackBuilder is used for adding addition services (like different version of PostgreSQL, adds-on, etc)
   ![](images/installation_9.png)
   11. Builder view
   ![](images/builder.png)
   ![](images/builder_1.png)

```
Now you have installed PostgreSQL instance with pgAdmin access point
```
# Access DB
1. Open pgAdmin and enter your password from step 3.5
   ![](images/pgadmin.png)
2. By default you have your installed PostgreSQL veriosn with one default DB
   ![](images/pgadmin_1.png)
3. You can add more DB, but the structure is the same
   ![](images/pgadmin_2.png)
