package grupo12.entity;

import java.util.Date;

public class Cuotas {

    private Integer Long;

    private String name;

    private Date createAt;

    private Date fechaVencimiento;

    public Integer getLong() {
        return Long;
    }

    public void setLong(Integer aLong) {
        Long = aLong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Cuotas() {
    }
}
