<Resource name="jdbc/myoracle" auth="Container"
						type="javax.sql.DataSource"
						driverClassName="oracle.jdbc.OracleDriver"
						url="jdbc:oracle:thin:@192.168.0.56:1521:xe" username="scott"
						password="tiger" maxTotal="20" maxIdle="10" maxWaitMillis="-1" />