interface LectorDeImagennes {
    DecodificarImagen getImagenDecodificada();
}

class DecodificarImagen {
    private String imagen;

    public DecodificarImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Imagen '" + imagen + "' fue decodificada.";
    }
}

class LectorMkv implements LectorDeImagennes {
    private DecodificarImagen DecodificarImagen;

    public LectorMkv(String imagen) {
        this.DecodificarImagen = new DecodificarImagen(imagen);
    }

    @Override
    public DecodificarImagen getImagenDecodificada() {
        return DecodificarImagen;
    }
}

class LectorMp4 implements LectorDeImagennes {
    private DecodificarImagen DecodificarImagen;

    public LectorMp4(String imagen) {
        DecodificarImagen = new DecodificarImagen(imagen);
    }

    @Override
    public DecodificarImagen getImagenDecodificada() {
        return DecodificarImagen;
    }
}

class LectorMov implements LectorDeImagennes {
    private DecodificarImagen DecodificarImagen;

    public LectorMov(String imagen) {
        DecodificarImagen = new DecodificarImagen(imagen);
    }

    @Override
    public DecodificarImagen getImagenDecodificada() {
        return DecodificarImagen;
    }
}

class ProcesarImagen {
    private String imagen;
    private DecodificarImagen DecodificarImagen;
    private LectorDeImagennes lector = null;
    private String formato;
    
	public ProcesarImagen(String parametroImagen) {
		this.imagen = parametroImagen;
	}

	public DecodificarImagen procesar () {
	    formato = imagen.substring(imagen.indexOf('.') + 1, imagen.length());
	    
	    if (formato.equals("mkv")) {
	        lector = new LectorMkv(imagen);
	    } 
	    if (formato.equals("mp4")) {
	        lector = new LectorMp4(imagen);
	    }
	    if (formato.equals("mov")) {
	        lector = new LectorMov(imagen);
	    }
	    assert lector != null;
	    DecodificarImagen = lector.getImagenDecodificada();
	    
	    return DecodificarImagen;
	}
}

class ProcesarArgumentos {
	private String mensaje;
	private String[] argumentos;
	
	public ProcesarArgumentos(String[] args) {
		argumentos = args;	
	}
	
	public String getMensaje() {
    	for (String s: argumentos) {
            // Procesar el pedido de ayuda.
            if ("-h".equals(s)) {
            	mensaje = "Formatos de archivos reconocidos: mkv, mp4, mov";
            	break;
            }
        }
    	return mensaje;
	}
}

public class FactoryMethod {
    public static void main(String[] args) {
        try {
        	ProcesarArgumentos procesarArgumentos = new ProcesarArgumentos(args);
        	if (procesarArgumentos.getMensaje() != null) {
        		System.out.println(procesarArgumentos.getMensaje());
        	} else {
            	ProcesarImagen procesarImagen = new ProcesarImagen(args[0]);
    	    	System.out.println(procesarImagen.procesar());        		
        	}
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        	System.out.println("No se tiene nada que procesar. "
        			+ "\nDebe introducir un nombre de archivo de video como parámetro.");
        } catch (java.lang.NullPointerException e) {
        	System.out.println("No se pudo reconocer el tipo de archivo.");
        }
    }
}