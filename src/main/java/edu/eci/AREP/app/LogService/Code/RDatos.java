package edu.eci.AREP.app.LogService.Code;

import com.mongodb.BasicDBObject;

import java.util.Date;

public class RDatos {
    private String nombres;
    private Date fecha;

    public  RDatos(String nombres, Date fecha){
        this.nombres = nombres;
        this.fecha = fecha;
    }
    public RDatos(BasicDBObject dBObject) {
        this.nombres = dBObject.getString("nombres");
        this.fecha = dBObject.getDate("fecha");
    }

    public BasicDBObject toBDObjectData(){
        BasicDBObject basic = new BasicDBObject();
        basic.append("nombres",this.getNombres());
        basic.append("fecha", this.getFecha());
        return basic;
    }


    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    @Override
    public String toString(){
        return "Salida desde el Rdatos"+ this.getNombres()+ this.getFecha();

    }
}
