public class TestingTabla {
    // Empezamos con la construcción de un main
    public static void main(String[] args) {
        // nombre del arcihvo de entrada
        String archivoLectura = "nombresTablaHash.txt";
        // nombre del archivo de salida
        String archivoEscritura = "nombresTablaHashOrdenados.txt";
        
        // Llamamos a la clase TablaHash para ejecutar el programa
        TablaHash.procesarArchivo(archivoLectura, archivoEscritura);
    }
}
