
import java.util.ArrayList;
import java.util.List;

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

class GestionParqueadero {
    private List<EspacioParqueadero> espacios;
    private List<Vehiculo> vehiculos;

    public GestionParqueadero() {
        espacios = new ArrayList<>();
        vehiculos = new ArrayList<>();
    }

    public void registrarEspacio(EspacioParqueadero espacio) {
        espacios.add(espacio);
    }

    public void registrarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public void mostrarEspaciosDisponibles() {
        System.out.println("Espacios disponibles:");
        for (EspacioParqueadero espacio : espacios) {
            if (!espacio.getEstado()) {
                System.out.println(espacio);
            }
        }
    }

    public void asignarEspacio(Vehiculo vehiculo) {
        boolean asignado = false;
        for (EspacioParqueadero espacio : espacios) {
            if (!espacio.getEstado() && espacio.getTipoPermitido().equals(vehiculo.getTipo())) {
                espacio.asignarVehiculo(vehiculo);
                asignado = true;
                break;
            }
        }

        if (!asignado) {
            System.out.println("No se pudo asignar un espacio para el vehículo: " + vehiculo);
        }
    }

    public void liberarEspacio(int numeroEspacio) {
        for (EspacioParqueadero espacio : espacios) {
            if (espacio.getNumeroEspacio() == numeroEspacio) {
                espacio.liberarEspacio();
                return;
            }
        }
        System.out.println("No se encontró el espacio con número " + numeroEspacio);
    }
}

public class Parqueadero {
    public static void main(String[] args) {
        GestionParqueadero gestion = new GestionParqueadero();

        gestion.registrarEspacio(new EspacioParqueadero(1, "carro"));
        gestion.registrarEspacio(new EspacioParqueadero(2, "moto"));
        gestion.registrarEspacio(new EspacioParqueadero(3, "carro"));
        gestion.registrarEspacio(new EspacioParqueadero(4, "moto"));

        Vehiculo vehiculo1 = new Vehiculo("ABC123", "carro", "Carlos Pérez");
        Vehiculo vehiculo2 = new Vehiculo("XYZ456", "moto", "Valerin Hernandez");

        gestion.registrarVehiculo(vehiculo1);
        gestion.registrarVehiculo(vehiculo2);

        gestion.mostrarEspaciosDisponibles();

        gestion.asignarEspacio(vehiculo1);
        gestion.asignarEspacio(vehiculo2);

        gestion.liberarEspacio(1);

        gestion.mostrarEspaciosDisponibles();
    }
}