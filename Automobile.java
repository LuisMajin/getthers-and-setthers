public class Automobile {

    String marca;
    int modelo;
    int velocidadMaxima;
    int velocidadActual = 0;

    public enum tipoCom {
        GASOLINA,
        BIOETANOL,
        GAS_NATURAL,
        BIODIESEL,
        DIESEL
    }

    tipoCom tipoCombustible;

    enum tipoAuto {
        CIUDAD,
        COMPACTO,
        SUBCOMPACTO,
        SUV,
        EJECUTIVO
    }

    tipoAuto tipoAutomovil;

    public Automobile(String marca, int modelo, int velocidadMaxima, Automobile.tipoAuto tipoAutomovil, Automobile.tipoCom tipoCombustible) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
        this.tipoCombustible = tipoCombustible;
        this.tipoAutomovil = tipoAutomovil;
    }

    public int getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    void acelerar(int incremento) {
        if ((velocidadActual + incremento) < velocidadMaxima) {
            velocidadActual += incremento;
        } else {
            System.out.println("No se puede acelerar por encima de la velocidad máxima.");
        }
    }

    void desacelerar(int decremento) {
        if ((velocidadActual - decremento) > 0) {
            velocidadActual -= decremento;
        } else {
            System.out.println("No se puede decrementar por debajo de 0.");
        }
    }

    void frenar() {
        velocidadActual = 0;
    }

    double calcularTiempoLlegada(int distancia) {
        return (double) distancia / velocidadActual;
    }

    void mostrar() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Velocidad Actual: " + velocidadActual);
        System.out.println("Velocidad Máxima: " + velocidadMaxima);
        System.out.println("Tipo de Combustible: " + tipoCombustible);
        System.out.println("Tipo de Automóvil: " + tipoAutomovil);
    }

    public static void main(String[] args) {
        Automobile auto1 = new Automobile("Toyota", 2023, 280, tipoAuto.CIUDAD, tipoCom.DIESEL);
        auto1.mostrar();
        auto1.setVelocidadActual(100);
        System.out.println("Velocidad actual = " + auto1.getVelocidadActual());
        auto1.acelerar(20);
        System.out.println("Velocidad actual = " + auto1.getVelocidadActual());
        auto1.desacelerar(50);
        System.out.println("Velocidad actual = " + auto1.getVelocidadActual());
        auto1.frenar();
        System.out.println("Velocidad actual = " + auto1.getVelocidadActual());
        auto1.desacelerar(50); // se agrega para verificar  el else de desacelerar
        System.out.println("Velocidad actual = " + auto1.getVelocidadActual());
    }
}
