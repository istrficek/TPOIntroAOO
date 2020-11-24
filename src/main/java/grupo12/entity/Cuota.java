package grupo12.entity;

import java.util.Date;

public class Cuota {

    private Integer id;

    private int numeroDeCuota;

    private float valor;

    private  boolean paga;

    private Date fechaVencimiento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setNumeroDeCuota(int numeroDeCuota) {this.numeroDeCuota = numeroDeCuota;}

    public int getNumeroDeCuota() {return this.numeroDeCuota;}

    public void setValor(float valor) {this.valor = valor;}

    public float getValor() {return valor;}

    public boolean isPaga() {return this.isPaga();}

    public void setPaga(boolean isPaga){this.paga = isPaga;}

    public Cuota() {
    }

    public Cuota(Integer id, int numeroDeCuota, float valor, boolean paga, Date fechaVencimiento) {
        this.id = id;
        this.numeroDeCuota = numeroDeCuota;
        this.valor = valor;
        this.paga = paga;
        this.fechaVencimiento = fechaVencimiento;
    }
}
