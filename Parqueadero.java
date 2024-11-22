
class Vehiculo {
    private String placa;
    private String tipo;
    private String propietario;


public Vehiculo(String placa, String tipo, String propietario) {
    this.placa = placa;
    this.tipo = tipo;
    this.propietario = propietario;
}
public String getPlaca() {
    return placa;
}
public String getTipo() {
    return tipo;
}
public String getPropietario() {
    return propietario;
}
@Override
public String toString() {
    return "Placa: " + placa + ", Tipo: " + tipo + ", Propietario: " + propietario;
}
}

class EspacioParqueadero {
    private int numeroEspacio;
    private String tipoPermitido;
    private boolean estado;

public EspacioParqueadero(int numeroEspacio, String tipoPermitido) {
    this.numeroEspacio = numeroEspacio;
    this.tipoPermitido = tipoPermitido;
    this.estado = false;
}

public int getNumeroEspacio() {
    return numeroEspacio;
}

public String getTipoPermitido() {
    return tipoPermitido;
}

public boolean getEstado() {
    return estado;
}

public void asignarVehiculo(Vehiculo vehiculo) {
    if (estado) {
        System.out.println("El espacio ya está ocupado");
    } else if (!vehiculo.getTipo().equals(tipoPermitido)) {
        System.out.println("El vehículo no puede estacionarse aquí. Tipo de espacio incorrecto");
    } else {
        estado = true;
        System.out.println("Vehículo asignado al espacio " + numeroEspacio + ": " + vehiculo);
    }
}

public void liberarEspacio() {
    if (!estado) {
        System.out.println("El espacio ya está disponible");
    } else {
        estado = false;
        System.out.println("El espacio " + numeroEspacio + " ha sido liberado");
    }
}

@Override
public String toString() {
    return "Espacio " + numeroEspacio + " (" + tipoPermitido + "): " + (estado ? "Ocupado" : "Disponible");
}
}
