package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class ImplementacionBD implements UsuarioDAO{
	// Atributos
		private Connection con;
		private PreparedStatement stmt;

		// Los siguientes atributos se utilizan para recoger los valores del fich de
		// configuraci n
		private ResourceBundle configFile;
		private String driverBD;
		private String urlBD;
		private String userBD;
		private String passwordBD;

		// Sentencias SQL
		
		final String sql = "SELECT * FROM usuario WHERE usuario = ? AND contrasena = ?";
		final String sqlInsert = "INSERT INTO usuario VALUES ( ?,?)";
		final String SQLCONSULTA = "SELECT * FROM ALUMNO";
		final String sql1 = "SELECT * FROM usuario WHERE usuario = ?";
		final String SQLBORRAR = "DELETE FROM usuario WHERE usuario=?";
		final String SQLMODIFICAR = "UPDATE usuario SET usuario=?, contrasena=? WHERE usuario=?";

		// Para la conexi n utilizamos un fichero de configuaraci n, config que
		// guardamos en el paquete control:
		public ImplementacionBD() {
			this.configFile = ResourceBundle.getBundle("modelo.configClase");
			this.driverBD = this.configFile.getString("Driver");
			this.urlBD = this.configFile.getString("Conn");
			this.userBD = this.configFile.getString("DBUser");
			this.passwordBD = this.configFile.getString("DBPass");
		}

		private void openConnection() {
			try {
				con = DriverManager.getConnection(urlBD, this.userBD, this.passwordBD);
			} catch (SQLException e) {
				System.out.println("Error al intentar abrir la BD");
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		

		@Override
		/*public boolean comprobarUsuario(Usuario usuario){
			// Abrimos la conexion
			boolean existe=false;
			this.openConnection();

			
			try {
				stmt = con.prepareStatement(sql);
	            stmt.setString(1, usuario.getNombre());
	            stmt.setString(2, usuario.getContrasena());
	            ResultSet resultado = stmt.executeQuery();

	            //Si hay un resultado, el usuario existe
	            if (resultado.next()) {
	                existe = true;
	            }

	            
	            resultado.close();
	            stmt.close();
	            con.close();

	        } catch (SQLException e) {
	            System.out.println("Error al verificar credenciales: " + e.getMessage());
	        }

	        return existe;
	    }
		public boolean comprobarUsuario1(Usuario usuario){
			// Abrimos la conexion
			boolean existe=false;
			this.openConnection();

			
			try {
				stmt = con.prepareStatement(sql1);
	            stmt.setString(1, usuario.getNombre());
	            ResultSet resultado = stmt.executeQuery();

	            //Si hay un resultado, el usuario existe
	            if (resultado.next()) {
	                existe = true;
	            }

	            
	            resultado.close();
	            stmt.close();
	            con.close();

	        } catch (SQLException e) {
	            System.out.println("Error al verificar credenciales: " + e.getMessage());
	        }

	        return existe;
	    }*/

		
		public Map<String, Alumno> mostrarAlumnos() {
			// TODO Auto-generated method stub
			
			ResultSet rs = null;
			Alumno alumno;
			Map<String, Alumno> equipos = new TreeMap<>();

			// Abrimos la conexi n
			this.openConnection();

			try {
				stmt = con.prepareStatement(SQLCONSULTA);

				rs = stmt.executeQuery();

				// Leemos de uno en uno
				while (rs.next()) {
					alumno = new Alumno();
					alumno.setNombre(rs.getString("nombre"));
					alumno.setDni(rs.getString("dni"));
					alumno.setEdad(rs.getInt("edad"));
					equipos.put(alumno.getNombre(), alumno);
				}
				rs.close();
	            stmt.close();
	            con.close();
			} catch (SQLException e) {
				System.out.println("Error de SQL");
				e.printStackTrace();
			}
			return equipos;

		}
		/*public boolean insertarUsuario(Usuario usuario) {
			// TODO Auto-generated method stub
			boolean ok=false;
			if (!comprobarUsuario1(usuario))
			{
				this.openConnection();
				try {
					// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente

					stmt = con.prepareStatement(sqlInsert);
					stmt.setString(1, usuario.getNombre());
					stmt.setString(2, usuario.getContrasena());
					if (stmt.executeUpdate()>0) {
						ok=true;
					}
					
		            stmt.close();
		            con.close();
				  } catch (SQLException e) {
		             System.out.println("Error al verificar credenciales: " + e.getMessage());
		        }
			}
				return ok;	
		}*/
		
		/*public boolean actualizarUsuario(String nombreActual,Usuario usuarioNuevo) {
			// TODO Auto-generated method stub
			boolean ok=false;
			
				this.openConnection();
				try {
					// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente

					stmt = con.prepareStatement(SQLMODIFICAR);
					stmt.setString(1, usuarioNuevo.getNombre()); // Nuevo nombre
					stmt.setString(2, usuarioNuevo.getContrasena());
					stmt.setString(3, nombreActual); // Nombre anterior
					if (stmt.executeUpdate()>0) {
						ok=true;
					}
					
		            stmt.close();
		            con.close();
				  } catch (SQLException e) {
		             System.out.println("Error al verificar credenciales: " + e.getMessage());
		        }
			
				return ok;
			
			
		}*/
		public boolean borrarUsuario(String nombre) {
			// TODO Auto-generated method stub
			boolean ok=false;
			
				this.openConnection();
				try {
					// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente

					stmt = con.prepareStatement(SQLBORRAR);
					stmt.setString(1, nombre);
					if (stmt.executeUpdate()>0) {
						ok=true;
					}
					
		            stmt.close();
		            con.close();
				  } catch (SQLException e) {
		             System.out.println("Error al verificar credenciales: " + e.getMessage());
		        }
			
				return ok;
			
			
		}

		
}

	
		
	


