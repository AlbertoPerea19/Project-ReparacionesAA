class Dbconnection {
   constructor(dbHost,dbUser, dbPassword,dbName) {
     this.establishedConnection = null;
     this.dbHost=dbHost;
     this.dbName = dbName;
     this.dbUser=dbUser;
     this.dbPassword = dbPassword;
     
   }
 
  static connection() {
    var mysql=require('mysql');
     return new Promise((resolve, reject) => {
       resolve(mysql.createConnection({
         host: this.dbHost,
         user: this.dbUser,
         password: this.dbPassword,
         database: this.dbName,
       }))
     })
   }
 
   static connect() {
     if (!this.establishedConnection) {
       this.establishedConnection = this.connection().then(res => {
         res.connect(function(err) {
           if (err) {
             this.dropConnection();
             throw err;
             console.log('No conectado!');
           }
           
           console.log(res.state, "connected")
         })
       });
     }
   }

  //  query(){
  //   this.connection().then(res => {
  //     res.query('SELECT * from Administradores',(err,rows)=>{
  //          if(err)throw err
  //          console.log(rows)
  //        })});
    
  //  }
 
   static dropConnection() {
     if (this.establishedConnection) {
       this.establishedConnection.then((res) => {
         res.end();
         console.log(res.state, 'connection dropped');
       });
       
       this.establishedConnection = null;
     }
   }
   
   
   
   
}

// const database1= new Dbconnection('poo','');
// database1.connect();

 module.exports=Dbconnection;