package src.utils;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DataUtil {
    //nmetodos estaticos nao armazenam ou alteram o estado do objeto, apenas fazem converção ou executam algo
    public static String converterDateParaDataEHora(Date data) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatador.format(data);
    }

    public static String converterDateParaData(Date data) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(data);
    }

    public static String converterHora(Date data) {
        SimpleDateFormat formatador = new SimpleDateFormat("HH:mm:ss");
        return formatador.format(data);
    }
}
