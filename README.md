# **PROJETO CRUD JSF**

Tecnologias utilizadas:

 - JAVA 8;
 - Hibernate;
 - Primefaces;
 - JSF;
 - PostgreSQL.

Softwares necessários para rodar projeto na localmente:

 - EclipseJEE (qualquer versão compatível com JAVA 8 ou superior);
 - PostgreSQL;
 -  JAVA 8 ou superior;
 - Apache Tomcat 9 ou superior.

Como rodar o projeto na máquina?

 1. Com o servidor do PostgreSQL instalado, criar um *database* utilizando o script abaixo: 

    CREATE DATABASE crudjsf    
    WITH    OWNER = postgres    
    ENCODING = 'UTF8'    
    LC_COLLATE = 'Portuguese_Brazil.1252'    
    LC_CTYPE = 'Portuguese_Brazil.1252'    
    TABLESPACE = pg_default    
    CONNECTION LIMIT = -1    
    IS_TEMPLATE = False;

 2. Com o projeto clonado deste repositório, importá-lo na IDE *Eclipse*. 
 3. Rodar a aplicação no server  *Apache Tomcat 9* ou superior.
