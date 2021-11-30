October 21, 2021

We were not able to meet with the senior management (Cambranes) today, but we met as a team to discuss the progress of the project.
Background:
The team had been divided in 2, the first group formed by Ruth and Enrique would focus on the database structure and the second group formed by Omar and Rafael would focus on the implementation in python code.
*We first started designing and then we were able to create the program (code).

According to the research of both groups, the implementation of the program in API WhatsApp Business will be impossible, because the requirements to have access to it we must pay a certain amount, besides being an SME (Small and Medium Enterprise).
So the project will be migrated to Telegram (still under discussion, also the opinion of senior management is needed).
The database structure was also discussed, it was decided to remove a counter and add an ID of each xbox control.

For the next meeting we hope to deliver the first preview of the implementation in code (as we are still learning this new language) and connect the Python MySQL database connection using the MySQL Connector.
As well as being able to pass the MySQL from localhost to remote access.



Proof of progress:
 
 Diagrama de implementación de la base de datos. Ruth y afinación de detalles con Enrique, Rafael y Omar 

EJEMPLOS (Ruth)
 USUARIO						REPARACIÓN
No. Teléfono	Nombre
  9992584998	Alberto Perea
	
	
N° global	Piezas	Fecha	ID control
2	Joystick	21/10/21	123
			





USUARIO-REPARACIÓN
No. teléfono	N° global	Precio
  9992584998	204	$500
		


Vinculación de la Base de Datos con MySQL Enrique
import mysql.connector

conexion = mysql.connector.connect(user='root', password='123qwe456',
                                    host='localhost',
                                    database='salvadora',
                                    port='3306')
print(conexion)

