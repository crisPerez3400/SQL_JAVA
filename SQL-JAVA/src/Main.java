package SqlJava;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        OperacionesCRUD contacto = new OperacionesCRUD();
        OperacionesCRUDCategoria categoria = new OperacionesCRUDCategoria();
        OperacionesCRUD_Provincia provincia = new OperacionesCRUD_Provincia();
        
        int eleccion;
        System.out.println("--CONTACTOS--\n" +
                "1. Insertar Contacto\n" +
                "2. Lectura de contactos\n" +
                "3. Actualizar Contacto\n" +
                "4. Borrar Contacto");

        System.out.println("--Categoria--\n" +
                "5. Insertar Categoria\n" +
                "6. Leer Categoria\n" +
                "7. Actualizar Categoria\n" +
                "8. Borrar Categoria");

        System.out.println("--Provincias--\n" +
                "9. Insertar Provincia\n" +
                "10. Leer Provincia\n" +
                "11. Actualizar Provincia\n" +
                "12. Borrar Provincia");

        System.out.println("13. Salir\n" +
                "Seleccione una opción: ");

        eleccion = scanner.nextInt();
        scanner.nextLine(); 

        switch (eleccion) {
            case 1:
                insertarContacto(contacto);
                break;
            case 2:
                contacto.leerContactos();
                break;
            case 3:
                actualizarContacto(contacto);
                break;
            case 4:
                borrarContacto(contacto);
                break;
            case 5:
                insertarCategoria(categoria);
                break;
            case 6:
                categoria.leerCategorias();
                break;
            case 7:
                actualizarCategoria(categoria);
                break;
            case 8:
                borrarCategoria(categoria);
                break;   
            case 9:
                insertarProvincia(provincia);
                break;
            case 10:
                provincia.leerProvincias();
                break;
            case 11:
                actualizarProvincia(provincia);
                break;
            case 12:
                borrarProvincia(provincia);
                break;         
            case 13:
                System.out.println("Hasta la proxima!");
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + eleccion);
        }

        DatabaseConnection.cerrarConexion();
        scanner.close();
    }

    private static void insertarContacto(OperacionesCRUD contacto) {
        System.out.print("Inserte Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Inserte Apellidos: ");
        String apellidos = scanner.nextLine();

        System.out.print("Inserte DNI: ");
        String dni = scanner.nextLine();

        System.out.print("Inserte Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Inserte correo electronico: ");
        String ecorreo = scanner.nextLine();

        System.out.print("Inserte fecha de cumpleaños (YYYY-MM-DD): ");
        String fechacumple = scanner.nextLine();

        System.out.print("Inserte dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Inserte población: ");
        String poblacion = scanner.nextLine();

        System.out.print("Inserte ID de Provincia: ");
        int idProvincia = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Inserte Código Postal: ");
        String codigoPostal = scanner.nextLine();

        System.out.print("Inserte Categoría: ");
        String categoria = scanner.nextLine();

        System.out.print("Ingrese Deuda: ");
        int deuda = scanner.nextInt();
        scanner.nextLine(); 

        Contacto contacto1 = new Contacto(0, nombre, apellidos, dni, telefono, ecorreo, fechacumple, direccion, poblacion, idProvincia, codigoPostal, categoria, deuda);
        contacto.insertarContacto(contacto1);
    }

    private static void actualizarContacto(OperacionesCRUD contacto) {
        System.out.print("Ingrese ID del contacto: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Inserte teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Inserte Correo: ");
        String ecorreo = scanner.nextLine();

        Contacto contacto1 = new Contacto(id, null, null, null, telefono, ecorreo, null, null, null, 0, null, null, 0);
        contacto.actualizarContacto(contacto1);
    }

    
    //CONTACTOS
    private static void borrarContacto(OperacionesCRUD contacto) {
        System.out.print("Ingrese ID del contacto a borrar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        contacto.borrarContacto(id);
    }

    private static void insertarCategoria(OperacionesCRUDCategoria categoria) {
        System.out.print("Inserte el id de la categoria: ");
        String id_categoria = scanner.nextLine();

        System.out.print("Inserte descripcion: ");
        String descripcion = scanner.nextLine();

        Categoria categoria1 = new Categoria(id_categoria, descripcion);
        categoria.insertarCategoria(categoria1);
    }

    
    //CATEGORIAS
    private static void actualizarCategoria(OperacionesCRUDCategoria categoria) {
        System.out.print("Ingrese Id de la categoria: ");
        String id_categoria = scanner.nextLine();
        
        System.out.print("Ingrese nueva descripción: ");
        String descripcion = scanner.nextLine();

        Categoria categoria1 = new Categoria(id_categoria, descripcion);
        categoria.actualizarCategoria(categoria1);
    }

    private static void borrarCategoria(OperacionesCRUDCategoria categoria) {
        System.out.print("Ingrese ID de la categoria a borrar: ");
        String id_categoria = scanner.nextLine();

        categoria.borrarCategoria(id_categoria);
    }

    	///PROVINCIAS
    private static void insertarProvincia(OperacionesCRUD_Provincia provincia) {
        System.out.print("Ingrese la provincia: ");
        String nom_provincia = scanner.nextLine();

        Provincia provincia1 = new Provincia(0, nom_provincia);
        provincia.insertarProvincia(provincia1);
    }

    private static void actualizarProvincia(OperacionesCRUD_Provincia provincia) {
        System.out.print("Ingrese Id de la provincia: ");
        int id_provincia = scanner.nextInt();
        scanner.nextLine();         
        System.out.print("Ingrese la nueva provincia: ");
        String nom_provincia = scanner.nextLine();
        Provincia provincia_ = new Provincia(id_provincia, nom_provincia);
        provincia.actualizarProvincia(provincia_);
    }

    private static void borrarProvincia(OperacionesCRUD_Provincia provincia) {
        System.out.print("Ingrese Id de la provincia: ");
        int id_provincia = scanner.nextInt();
        scanner.nextLine(); 
        
        provincia.borrarProvincia(id_provincia);
    }
}
