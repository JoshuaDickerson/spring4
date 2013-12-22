###Setup###

* 
####Adding a new data model:####
 1. Create a table in the database, and any additional tables (mapping) to construct the object
 2. Create a model class with fields (along with getters nd setters) corresponding to the DB table(s)
 3. Create a modelname.hbm.xml file in the resources/ folder
 4. Add a reference to modelname.hbm.xml in hibernate.cfg.xml

###FAQ###

Question: Where's the 'entry point?
<br />Answer: mvc-dispatcher-servlet.xml defines which controllers to look for:<br /> `<context:component-scan base-package="com.springapp4.mvc.controller"/>`
<br /><br />

Error : `org.hibernate.hql.ast.QuerySyntaxException: Team is not mapped [FROM Team]`<br/>
resolution: Make sure you've added a mapping entry for the team.hbm.xml in hibernate.cfg.xml

