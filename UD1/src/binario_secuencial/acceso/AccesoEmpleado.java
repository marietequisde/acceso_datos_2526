package binario_secuencial.acceso;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import binario_secuencial.modelo.Empleado;
import util.MyObjectOutputStream;
import util.modelo.Fecha;

public class AccesoEmpleado {

    private final static String FICHERO = "data/empleados.dat";
    private final static String FICHERO_TMP = "data/empleados.dat.tmp";

    public static void escribirEmpleado(Empleado empleado)
            throws ClassNotFoundException, FileNotFoundException, IOException {
        ObjectOutputStream oos = null;
        try {
            File file = new File(FICHERO);
            if (file.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(file, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }
            oos.writeObject(empleado);

        } finally {
            cerrarFlujo(oos);
        }
    }

    public static List<Empleado> leerEmpleados() throws FileNotFoundException, ClassNotFoundException, IOException {
        List<Empleado> empleados = new ArrayList<>();

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(FICHERO));

            File fichero = new File(FICHERO);
            if (!fichero.exists()) {
                return null;
            }
            boolean finFichero = false;
            try {
                while (!finFichero) {
                    Empleado empleado = (Empleado) ois.readObject();
                    empleados.add(empleado);
                }
            } catch (EOFException e) {
                finFichero = true;
            }

        } finally {
            cerrarFlujo(ois);
        }

        return empleados;
    }

    public static Empleado leerEmpleado(int idEmpleado) throws ClassNotFoundException, IOException {
        ObjectInputStream ois = null;
        Empleado empleadoBuscado = null;
        try {
            File file = new File(FICHERO);
            FileInputStream fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            boolean encontrado = false;
            boolean finFichero = false;
            try {
                while (!finFichero && !encontrado) {
                    Empleado empleado = (Empleado) ois.readObject();
                    if (empleado.getCodigo() == idEmpleado) {
                        empleadoBuscado = empleado;
                        encontrado = true;
                    }
                }
            } catch (EOFException e) {
                finFichero = true;
            }

        } finally {
            cerrarFlujo(ois);

        }

        return empleadoBuscado;
    }

    public static boolean actualizarEmpleado(int idEmpleado, String nombre, String apellido, Fecha fechaAlta)
            throws ClassNotFoundException, IOException {
        boolean actualizado = false;
        ObjectInputStream streamInputEmpleados = null;
        ObjectOutputStream streamOutputEmpleadosTmp = null;

        try {
            streamInputEmpleados = new ObjectInputStream(new FileInputStream(FICHERO));
            streamOutputEmpleadosTmp = new ObjectOutputStream(new FileOutputStream(FICHERO_TMP));

            boolean finalFichero = false;
            while (!finalFichero) {
                try {
                    Empleado empleado = (Empleado) streamInputEmpleados.readObject();
                    if (empleado.getCodigo() == idEmpleado) {
                        empleado.setNombre(nombre);
                        empleado.setApellido(apellido);
                        empleado.setFechaAlta(fechaAlta);
                        actualizado = true;
                    }
                    streamOutputEmpleadosTmp.writeObject(empleado);

                } catch (EOFException e) {
                    finalFichero = true;
                }
            }
        } finally {
            cerrarFlujo(streamInputEmpleados);
            cerrarFlujo(streamOutputEmpleadosTmp);
        }
        actualizarFicheroOriginal(FICHERO, FICHERO_TMP);
        return actualizado;
    }

    public static boolean eliminarEmpleado(int idEmpleado) throws ClassNotFoundException, IOException {
        boolean eliminado = false;
        ObjectInputStream streamInputEmpleados = null;
        ObjectOutputStream streamOutputEmpleadosTmp = null;

        try {
            streamInputEmpleados = new ObjectInputStream(new FileInputStream(FICHERO));
            streamOutputEmpleadosTmp = new ObjectOutputStream(new FileOutputStream(FICHERO_TMP));

            boolean finalFichero = false;
            while (!finalFichero) {
                try {
                    Empleado empleado = (Empleado) streamInputEmpleados.readObject();
                    if (empleado.getCodigo() != idEmpleado) {
                        streamOutputEmpleadosTmp.writeObject(empleado);
                    } else {
                        eliminado = true;
                    }

                } catch (EOFException e) {
                    finalFichero = true;
                }
            }

        } finally {
            cerrarFlujo(streamInputEmpleados);
            cerrarFlujo(streamOutputEmpleadosTmp);

        }
        actualizarFicheroOriginal(FICHERO, FICHERO_TMP);
        return eliminado;
    }

    private static void actualizarFicheroOriginal(String ogFile, String tmpFile) {
        File newEmpleados = new File(tmpFile);
        File oldEmpleados = new File(ogFile);
        oldEmpleados.delete();
        newEmpleados.renameTo(oldEmpleados);
    }

    private static void cerrarFlujo(ObjectInputStream ois) throws IOException {
        if (ois != null) {
            ois.close();
        }
    }

    private static void cerrarFlujo(ObjectOutputStream oos) throws IOException {
        if (oos != null) {
            oos.close();
        }
    }
}
