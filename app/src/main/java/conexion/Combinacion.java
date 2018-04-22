package conexion;

public class Combinacion {
    private int id;
    private String ocasion;
    private Prenda prendas[];
    private Puntuacion puntuaciones[];

    public Combinacion() {
        this.id = 0;
        this.ocasion = "Desconocido";
        this.prendas = null;
        this.puntuaciones = null;
    }

    public Combinacion(int id, String ocasion, Prenda[] prendas, Puntuacion[] puntuaciones) {
        this.id = id;
        this.ocasion = ocasion;
        this.prendas = prendas;
        this.puntuaciones = puntuaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOcasion() {
        return ocasion;
    }

    public void setOcasion(String ocasion) {
        this.ocasion = ocasion;
    }

    public Prenda[] getPrendas() {
        return prendas;
    }

    public void setPrendas(Prenda[] prendas) {
        this.prendas = prendas;
    }

    public Puntuacion[] getPuntuaciones() {
        return puntuaciones;
    }

    public void setPuntuaciones(Puntuacion[] puntuaciones) {
        this.puntuaciones = puntuaciones;
    }

    public class Puntuacion{
        int puntos;
        String autor;
        String etiqueta;

        public Puntuacion() {
        }

        public Puntuacion(int puntos, String autor, String etiqueta) {
            this.puntos = puntos;
            this.autor = autor;
            this.etiqueta = etiqueta;
        }

        public int getPuntos() {
            return puntos;
        }

        public void setPuntos(int puntos) {
            this.puntos = puntos;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public String getEtiqueta() {
            return etiqueta;
        }

        public void setEtiqueta(String etiqueta) {
            this.etiqueta = etiqueta;
        }
    }
}
