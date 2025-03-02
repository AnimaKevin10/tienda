package Model;

public class TarjetaRegalo implements MetodoDePago {
    private double valor;
    private String codigo;
    private String tipo;

    public TarjetaRegalo(double valor, String codigo, String tipo) {
        this.valor = valor;
        this.codigo = codigo;
        this.tipo = tipo;
    }

    @Override
    public boolean procesarPago(double monto) {
        if (valor >= monto) {
            valor -= monto;
            return true;
        }
        return false;
    }
}