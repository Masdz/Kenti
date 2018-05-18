package conexion;

import kenti.kaktia.com.kenti.adaptadores.CuadriculaItem;

public class Prenda {
    private int id;
    private int idEmpresa;
    private int idTipo;
    private String destacado;
    private int compartido;
    private String codigo;
    private String tipo;// (obligatorio, solo un valor)
    private String marca; //(opcional, valores separados por comas)
    private String tallas;// (opcional, valores separados por comas)
    private String etiquetas;// (opcional, valores separados por comas)
    private String urls;
    private String colores;// (opcional, valores separados por comas)
    private String estilo;// (obligatorio, solo un valor)
    private String poblacion;// (opcional, valores separados por comas) *
    private String genero;// (opcional, valores separados por comas) *

    public Prenda() {
    }

    public Prenda(int id, int idEmpresa, int idTipo, String destacado, int compartido, String codigo, String tipo, String marca, String tallas, String etiquetas, String urls, String colores, String estilo, String poblacion, String genero) {
        this.id = id;
        this.idEmpresa = idEmpresa;
        this.idTipo = idTipo;
        this.destacado = destacado;
        this.compartido = compartido;
        this.codigo = codigo;
        this.tipo = tipo;
        this.marca = marca;
        this.tallas = tallas;
        this.etiquetas = etiquetas;
        this.urls = urls;
        this.colores = colores;
        this.estilo = estilo;
        this.poblacion = poblacion;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getDestacado() {
        return destacado;
    }

    public void setDestacado(String destacado) {
        this.destacado = destacado;
    }

    public int getCompartido() {
        return compartido;
    }

    public void setCompartido(int compartido) {
        this.compartido = compartido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTallas() {
        return tallas;
    }

    public void setTallas(String tallas) {
        this.tallas = tallas;
    }

    public String getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public String getColores() {
        return colores;
    }

    public void setColores(String colores) {
        this.colores = colores;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public  CuadriculaItem getItem(){
        CuadriculaItem item=new CuadriculaItem();
        item.setTitulo(tipo+" "+marca);
        item.setDescripcion(etiquetas);
        return item;
    }

}
