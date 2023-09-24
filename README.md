## 1. Ejecuta el Script SQL

1. Ejecuta el script SQL proporcionado en el archivo `SQL_Script_CalvoPablo.sql`. Este script creará la base de datos y la tabla necesaria.

   ```bash
   mysql -u tu_usuario -p < SQL_Script_CalvoPablo.sql
   ```

   Reemplaza `tu_usuario` con tu nombre de usuario de MySQL. Se te pedirá ingresar la contraseña correspondiente.

## 2. Modifica las Credenciales en `PokemonDAO.java`

1. Abre el archivo `PokemonDAO.java` ubicado en `src/com/dao`.

2. Busca las siguientes líneas de código:

   ```java
   static String url = "jdbc:mysql://localhost:3306/pokemon";
   static String usuario = "tu_usuario";
   static String contraseña = "tu_contraseña";
   ```

3. Cambia `"tu_usuario"` y `"tu_contraseña"` por tus propias credenciales de MySQL.

## 3. Ejecutar la Aplicación

Ahora que has configurado la base de datos y modificado las credenciales en `PokemonDAO.java`, puedes ejecutar la aplicación.

¡Listo! La aplicación debería estar configurada para funcionar con tu base de datos local.

[Enlace al Repositorio](https://github.com/tu_usuario/tu_proyecto)
