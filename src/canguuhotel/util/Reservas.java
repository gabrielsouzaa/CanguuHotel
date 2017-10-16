
package canguuhotel.util;

public class Reservas {
    private int id;
    private String checkin;
    private String checkout;
    private int quantidade_de_dias;
    private int numero_de_hospedes;
    private int idQuarto;

    public int getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    private int idCliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public int getQuantidade_de_dias() {
        return quantidade_de_dias;
    }

    public void setQuantidade_de_dias(int quantidade_de_dias) {
        this.quantidade_de_dias = quantidade_de_dias;
    }

    public int getNumero_de_hospedes() {
        return numero_de_hospedes;
    }

    public void setNumero_de_hospedes(int numero_de_hospedes) {
        this.numero_de_hospedes = numero_de_hospedes;
    }  
    
}
