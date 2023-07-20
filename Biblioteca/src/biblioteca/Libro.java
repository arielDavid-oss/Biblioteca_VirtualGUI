package biblioteca;

public class Libro {
    private String Fecha_adquisicion; // 20 bytes
    private String Titulo; // 50 bytes
    private String Autor; // 50 bytes
    private String ISDN; // 30 bytes
    private int N_Paginas; // 4 bytes
    private int precio; // 8 bytes
    private boolean leido; // 1 byte
    private boolean prestado; // 1 byte
    private String F_Prestamo; // 20 bytes
    private String NombrePrestamo; // 100 bytes
    private  int Copias=1;
   private static final int NAME_LIMIT = 20;
    private static final int titulo = 50;
    private static final int autor = 50;
    private static final int isbn = 30;
    private static final int nombre_p = 50;
    public static final int SIZE = NAME_LIMIT + 2 * titulo + 2 * autor + isbn + 4 + 8 + 1 + 1 + 20 + 2 * nombre_p; // 332 bytes

    public Libro(String Fecha_adquisicion, String Titulo, String Autor, String ISDN, int N_Paginas, int precio,
            boolean leido, boolean prestado, String F_Prestamo, String NombrePrestamo) {
        this.Fecha_adquisicion = Fecha_adquisicion;
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.ISDN = ISDN;
        this.N_Paginas = N_Paginas;
        this.precio = precio;
        this.leido = leido;
        this.prestado = prestado;
        this.F_Prestamo = F_Prestamo;
        this.NombrePrestamo = NombrePrestamo;
    }
     public Libro(String Fecha_adquisicion, String Titulo, String Autor, String ISDN, int N_Paginas, int precio,boolean prestado) {
        this.Fecha_adquisicion = Fecha_adquisicion;
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.ISDN = ISDN;
        this.N_Paginas = N_Paginas;
        this.precio = precio;
        this.prestado=prestado;
        this.leido = leido;
    }
    public Libro( boolean prestado, String F_Prestamo, String NombrePrestamo) {
        prestado=true;
        this.prestado=prestado;
        this.F_Prestamo = F_Prestamo;
        this.NombrePrestamo = NombrePrestamo;
    }

    public void setFecha_adquisicion(String Fecha_adquisicion) {
        this.Fecha_adquisicion = Fecha_adquisicion;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public void setISDN(String ISDN) {
        this.ISDN = ISDN;
    }

    public void setN_Paginas(int N_Paginas) {
        this.N_Paginas = N_Paginas;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public void setF_Prestamo(String F_Prestamo) {
        this.F_Prestamo = F_Prestamo;
    }

    public void setNombrePrestamo(String NombrePrestamo) {
        this.NombrePrestamo = NombrePrestamo;
    }

    public String getFecha_adquisicion() {
        return Fecha_adquisicion;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public String getISDN() {
        return ISDN;
    }

    public int getN_Paginas() {
        return N_Paginas;
    }

    public int getPrecio() {
        return precio;
    }
    public boolean getprestado(){
        return prestado;
    }

    public boolean isLeido() {
        return leido;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public String getF_Prestamo() {
        return F_Prestamo;
    }

    public String getNombrePrestamo() {
        return NombrePrestamo;
    }

    public int getCopias(){
        return Copias;
    }
    
    @Override
    public String toString() {
        return "Libro{" + "Fecha_adquisicion= " + Fecha_adquisicion + ", Titulo= " + Titulo + ", Autor= " + Autor
                + ", ISDN= " + ISDN + ", N_Paginas= " + N_Paginas + ", precio= " + precio + ", leido= " + leido
                + ", prestado= " + prestado + ", F_Prestamo= " + F_Prestamo + ", NombrePrestamo= " + NombrePrestamo
                + '}';
    }

    public byte[] toBytes() {
        byte[] record = new byte[SIZE];
        int offset = 0;
        PackUtils.packLimitedString(Fecha_adquisicion, NAME_LIMIT, record, offset);
        offset += 2 * NAME_LIMIT;
        PackUtils.packLimitedString(Titulo, NAME_LIMIT, record, offset);
        offset += 2 * NAME_LIMIT;
        PackUtils.packLimitedString(Autor, autor, record, offset);
        offset += 2 * autor;
        PackUtils.packLimitedString(ISDN, isbn, record, offset);
        offset += isbn;
        PackUtils.packInt(N_Paginas, record, offset);
        offset += 4;
        PackUtils.packInt(precio, record, offset);
        offset += 4;
        PackUtils.packBoolean(leido, record, offset);
        offset += 1;
        PackUtils.packBoolean(prestado, record, offset);
        offset += 1;
        PackUtils.packLimitedString(F_Prestamo, 20, record, offset);
        offset += 2 * 20;
        PackUtils.packLimitedString(NombrePrestamo, nombre_p, record, offset);
        offset += 2 * nombre_p;
        return record;
    }
    public static Libro fromBytes(byte[] record) {
        int offset = 0;
        String Fecha_adquisicion = PackUtils.unpackLimitedString(NAME_LIMIT, record, offset);
        offset += 2 * NAME_LIMIT;
        String Titulo = PackUtils.unpackLimitedString(NAME_LIMIT, record, offset);
        offset += 2 * NAME_LIMIT;
        String Autor = PackUtils.unpackLimitedString(autor, record, offset);
        offset += 2 * autor;
        String ISDN = PackUtils.unpackLimitedString(isbn, record, offset);
        offset += isbn;
        int N_Paginas = PackUtils.unpackInt(record, offset);
        offset += 4;
        int precio = PackUtils.unpackInt(record, offset);
        offset += 4;
        boolean leido = PackUtils.unpackBoolean(record, offset);
        offset += 1;
        boolean prestado = PackUtils.unpackBoolean(record, offset);
        offset += 1;
        String F_Prestamo = PackUtils.unpackLimitedString(20, record, offset);
        offset += 2 * 20;
        String NombrePrestamo = PackUtils.unpackLimitedString(nombre_p, record, offset);
        offset += 2 * nombre_p;
        return new Libro(Fecha_adquisicion, Titulo, Autor, ISDN, N_Paginas, precio, leido, prestado, F_Prestamo,
                NombrePrestamo);
    }
   
}

 

    
    
    
    
    
    
    
    

