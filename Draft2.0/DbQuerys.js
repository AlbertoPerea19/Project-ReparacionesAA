const Dbconnection=require('./DbConnection');
class DbQuerys {

constructor(dbHost,dbUser,dbPassword,dbName){
   Dbconnection.dbHost=dbHost;
   Dbconnection.dbUser=dbUser;
   Dbconnection.dbName=dbName;
   Dbconnection.dbPassword=dbPassword;
}

   query(){
      Dbconnection.connection().then(res => {
           res.query('SELECT * from Administradores',(err,rows)=>{
                if(err)throw err
                console.log(rows)
              })});
         
        
}

}

let b= new DbQuerys('localhost','root','','poo');
b.query();
