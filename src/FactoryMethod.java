interface LectorDeVideos {
    DecodificarVideo getVideoDecodificado();
}

class DecodificarVideo {
    private String video;

    public DecodificarVideo(String video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "Video '" + video + "' fue decodificado.";
    }
}

class LectorMkv implements LectorDeVideos {
    private DecodificarVideo DecodificarVideo;

    public LectorMkv(String video) {
        this.DecodificarVideo = new DecodificarVideo(video);
    }

    @Override
    public DecodificarVideo getVideoDecodificado() {
        return DecodificarVideo;
    }
}

class LectorMp4 implements LectorDeVideos {
    private DecodificarVideo DecodificarVideo;

    public LectorMp4(String video) {
        DecodificarVideo = new DecodificarVideo(video);
    }

    @Override
    public DecodificarVideo getVideoDecodificado() {
        return DecodificarVideo;
    }
}

class LectorMov implements LectorDeVideos {
    private DecodificarVideo DecodificarVideo;

    public LectorMov(String video) {
        DecodificarVideo = new DecodificarVideo(video);
    }

    @Override
    public DecodificarVideo getVideoDecodificado() {
        return DecodificarVideo;
    }
}

class ProcesarVideo {
    private String video;
    private DecodificarVideo DecodificarVideo;
    private LectorDeVideos lector = null;
    private String formato;
    
	public ProcesarVideo(String parametroVideo) {
		this.video = parametroVideo;
	}

	public DecodificarVideo procesar () {
	    formato = video.substring(video.indexOf('.') + 1, video.length());
	    
	    if (formato.equals("mkv")) {
	        lector = new LectorMkv(video);
	    } 
	    if (formato.equals("mp4")) {
	        lector = new LectorMp4(video);
	    }
	    if (formato.equals("mov")) {
	        lector = new LectorMov(video);
	    }
	    assert lector != null;
	    DecodificarVideo = lector.getVideoDecodificado();
	    
	    return DecodificarVideo;
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
            	ProcesarVideo ProcesarVideo = new ProcesarVideo(args[0]);
    	    	System.out.println(ProcesarVideo.procesar());        		
        	}
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        	System.out.println("No se tiene nada que procesar. "
        			+ "\nDebe introducir un nombre de archivo de video como parámetro.");
        } catch (java.lang.NullPointerException e) {
        	System.out.println("No se pudo reconocer el tipo de archivo.");
        }
    }
}