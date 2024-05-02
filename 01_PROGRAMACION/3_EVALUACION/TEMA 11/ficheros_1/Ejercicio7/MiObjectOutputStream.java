package ActividadesStreams.Boletin.Ejercicio7;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOutputStream extends ObjectOutputStream {
    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    public void writeStreamHeader() {
    }
}
