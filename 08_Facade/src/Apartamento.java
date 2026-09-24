public class Apartamento {

    private long codigo;

    private String end;

    public Apartamento(long codigo, String end) {
        this.codigo = codigo;
        this.end = end;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
