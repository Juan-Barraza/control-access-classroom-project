import java.util.*;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;


public class Main{
  static Scanner scan = new Scanner(System.in);
  public static void main(String[] args) throws Exception {
    Workbook wb = new Workbook("workbook1.xlsx");
    
      WorksheetCollection collection = wb.getWorksheets();
      List<Estudiante> lista = new ArrayList<>();
      List<Visitante> lista2 = new ArrayList<>();
      
      Worksheet worksheet = collection.get(0);
      int rows = worksheet.getCells().getMaxDataRow();
      int cols = worksheet.getCells().getMaxDataColumn();
      
      for (int i = 0; i <= rows; i++) {
         Estudiante estudiante = new Estudiante();
          for (int j = 0; j <= cols; j++) {
            String record =  (String) worksheet.getCells().get(i, j).getValue();
              if (j == 0 && i > 0) {
                long record2 = Long.parseLong(record);
                estudiante.setNumDocumento(record2);
                continue;
                }
                if (j == 1 && i > 0) estudiante.setNombre(record);
                if (j == 2 && i > 0) estudiante.setApellido(record);
                if (j == 3 && i > 0) estudiante.setProgramaAcademico(record);

              }
              lista.add(estudiante);
            }

            RegistroEntradaYSalida registroentradaysalida = new RegistroEntradaYSalida();
            do {
              limpiarPantalla();
              ingresoSalida();
              byte option = scan.nextByte();
              switch (option) {
                case 1:
                limpiarPantalla();
                menuOpcion();
                byte opcion = scan.nextByte();
      
                switch (opcion) {
                  case 1:
                    System.out.println("Ingresar el documento del estudiante: ");
                    long documento = scan.nextLong();
                    Estudiante estudianteSeleccionado = null;
                    for (Estudiante estudiante : lista) {
                      if (documento == estudiante.getNumDocumento()) {
                        estudianteSeleccionado = estudiante;
                      }
                      
                    }
                    if (estudianteSeleccionado == null) {
                      throw new Exception("No esta registrado!!"); 
                    } 
                    System.out.println("Estudiante: " + estudianteSeleccionado.getNombre() + " " + estudianteSeleccionado.getApellido());
                    System.out.println("Su hora de ingreso es: " + registroentradaysalida.formatDate(registroentradaysalida.getHoraEntrada()));
                    pausa();
                   
                  break;
                  case 2:
                  System.out.println("Cantidad de Visitantes: ");
                  int cantidad = scan.nextInt();
                  for (int i = 0; i < cantidad; i++) {
                    System.out.println("Ingresar el nombre del visitante: ");
                    String nombre = scan.next();
                    System.out.println("Ingresar el apellido del visitante: ");
                    String apellido = scan.next();
                    System.out.println("Ingresar documento: ");
                    long document = scan.nextLong();
                    System.out.println("Ingresar evento al que viene: ");
                    String evento = scan.next();
                    lista2.add(new Visitante(
                      nombre,
                      apellido,
                      document,
                      evento
                      ));
                      System.out.println(" La hora de entrada es: " + registroentradaysalida.formatDate(registroentradaysalida.getHoraEntrada()));
                      pausa();
                    
                  }
                   default:
                  break;
                }
                break;
            
                case 2:
                limpiarPantalla();
                menuOpcion();
                byte opcion2 = scan.nextByte();
                switch (opcion2) {
                  case 1:
                   System.out.println("Ingresar el documento del estudiante: ");
                    long documento = scan.nextLong();
                    Estudiante estudianteSeleccionado = null;
                    for (Estudiante estudiante : lista) {
                      registroentradaysalida.setHoraSalidaDefault();
                      if (documento == estudiante.getNumDocumento() ) {
                        estudianteSeleccionado = estudiante;
                      } 
                    }
                    if (estudianteSeleccionado == null) {
                      throw new Exception("No esta registrado!!");
                    }
                    System.out.println("El estudiante " + estudianteSeleccionado.getNombre() + " " + estudianteSeleccionado.getApellido());
                    System.out.println("  Su hora de salida es: " + registroentradaysalida.formatDate(registroentradaysalida.getHoraSalida()));
                    pausa();
                    break;

                  case 2: 
                    System.out.println("Ingresar documento del visitante: ");
                    long document = scan.nextLong();
                    for (Visitante visitante : lista2) {
                      registroentradaysalida.setHoraSalidaDefault();
                      if (visitante.getNumDoc() == document) {
                        System.out.println("El visitante " + visitante.getNombre() + "  " + visitante.getApellido());
                        System.out.println("Su hora de salida es: " +  registroentradaysalida.formatDate(registroentradaysalida.getHoraSalida()));
                        
                        
                      } else if (visitante.getNumDoc() != document) {
                        System.out.println(" Nunca ingreso ese visitante");
                      }
                      pausa();
                    }
                  default:
                  break;
                }
                break;
      
              default:
                break;
            }
            } while (true);
    }


    public static void limpiarPantalla(){
        try{
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
            Process startProcess = pb.inheritIO().start();
            startProcess.waitFor();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void pausa(){
      scan.nextLine(); //Limpiamos buffer del System.in
      System.out.println("\t\nPresione enter para continuar...");
      scan.nextLine(); //Ahora el programa se detiene hasta que se pulse ENTER
  }
    public static void ingresoSalida(){
    System.out.println("Ingresar una opción");
    System.out.println("1. Entrada");
    System.out.println("2. Salida");
  }
    public static void menuOpcion(){
    System.out.println("Ingresar una opción");
    System.out.println("1. Estudiantes");
    System.out.println("2. Visitantes");
  }
}