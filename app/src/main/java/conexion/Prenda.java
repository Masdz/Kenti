package conexion;

import kenti.kaktia.com.kenti.adaptadores.CuadriculaItem;

public class Prenda {
    int id;
    String tipo;
    String codigo;
    String marca;
    String puntaje;
    PrendaColor color[];
    Talla talla[];
    String etiquetas[];

    public Prenda() {
        this.id = 0;
        this.tipo = "No especificado";
        this.codigo = "No especificado";
        this.marca = "No especificada";
        this.puntaje = "0";
        this.color = null;
        this.talla = null;
        this.etiquetas = null;
    }

    public Prenda(int id, String tipo, String codigo, String marca, String puntaje, PrendaColor[] color, Talla[] talla, String[] etiquetas) {
        this.id = id;
        this.tipo = tipo;
        this.codigo = codigo;
        this.marca = marca;
        this.puntaje = puntaje;
        this.color = color;
        this.talla = talla;
        this.etiquetas = etiquetas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }

    public PrendaColor[] getColor() {
        return color;
    }

    public void setColor(PrendaColor[] color) {
        this.color = color;
    }

    public Talla[] getTalla() {
        return talla;
    }

    public void setTalla(Talla[] talla) {
        this.talla = talla;
    }

    public String[] getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String[] etiquetas) {
        this.etiquetas = etiquetas;
    }

    public  CuadriculaItem getItem(){
        CuadriculaItem item=new CuadriculaItem();
        item.setTitulo(tipo+" "+marca);
        item.setDescripcion(despEtiquetas());
        return item;
    }

    public String despEtiquetas(){
        String s="";
        if(etiquetas!=null) {
            s=etiquetas[0];
            int i=1;
            for (;i < etiquetas.length&&s.length()>100; i++) {
                s+=", "+etiquetas[i];
            }
            if(i<etiquetas.length) s+="...";
        }
        return s;
    }
    public class Talla{
        private char codigo;
        private String talla;

        public Talla(char codigo, String talla) {
            this.codigo = codigo;
            this.talla = talla;
        }

        public Talla() {
            this.codigo = 'N';
            this.talla = "No especificada";
        }

        public char getCodigo() {
            return codigo;
        }

        public void setCodigo(char codigo) {
            this.codigo = codigo;
        }

        public String getTalla() {
            return talla;
        }

        public void setTalla(String talla) {
            this.talla = talla;
        }
    }

    public class PrendaColor{
        private String color;
        private String ruta;

        public PrendaColor() {
            this.color = null;
            this.ruta = null;
        }

        public PrendaColor(String color, String ruta) {
            this.color = color;
            this.ruta = ruta;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getRuta() {
            return ruta;
        }

        public void setRuta(String ruta) {
            this.ruta = ruta;
        }
    }
}
