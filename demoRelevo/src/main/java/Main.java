import model.UsuarioAdministrativo;
import service.ImpIDAO;

public class Main {
    //DAO generico asociado a la entidad
    private static final ImpIDAO<UsuarioAdministrativo> usuarioDAO = new ImpIDAO<>(UsuarioAdministrativo.class);
    public static void main(String[] args) {
        insertar3Usuarios();
    }
    public static void insertar3Usuarios(){
        System.out.print("=== INSERTANDO USUARIOS ADMINISTRATIVOS ===");

        //Usuario1
        UsuarioAdministrativo u1 = new UsuarioAdministrativo();
        u1.setNombre("Madz");
        u1.setApellido("Mikkelsen");
        u1.setActivo(true);

        //Usuario2
        UsuarioAdministrativo u2 = new UsuarioAdministrativo();
        u2.setNombre("Pedro");
        u2.setApellido("Pascal");
        u2.setActivo(true);

        //Usuario3
        UsuarioAdministrativo u3 = new UsuarioAdministrativo();
        u3.setNombre("Will");
        u3.setApellido("Graham");
        u3.setActivo(true);

        //Insertar en la base de datos
        usuarioDAO.insertar(u1);
        usuarioDAO.insertar(u2);
        usuarioDAO.insertar(u3);

        //Se verifica que se insertaron:
        System.out.println("=== Usuarios insertados ===");
        usuarioDAO.findAll("UsuarioAdministrativo.findAll").forEach(System.out::println);

    }
}
