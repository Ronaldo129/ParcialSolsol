// Seleccionamos la base de datos

//use bd_seguridad;

// Insertamos usuarios de prueba
db.seguridad.insertMany([
  {
    username: "admin",
    password: "admin123",
    role: "ADMIN",
  },
  {
    username: "juan",
    password: "123456",
    role: "USER",
  },
]);
