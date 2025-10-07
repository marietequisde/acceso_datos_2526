package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import util.modelo.Fecha;


public class MiRandomAccessFile extends RandomAccessFile {

    public MiRandomAccessFile(File file, String mode) throws FileNotFoundException {
        super(file, mode);
    }
    
    public final void writeFecha(Fecha fecha) throws IOException {
        writeInt(fecha.getDia());
        writeInt(fecha.getMes());
        writeInt(fecha.getAnio());
    }
    
    public final Fecha readFecha() throws IOException {
        return new Fecha(readInt(), readInt(), readInt());
    }

}
