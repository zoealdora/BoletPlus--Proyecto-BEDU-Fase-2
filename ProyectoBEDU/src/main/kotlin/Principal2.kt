/*package BoletPluspackage

data class Usuario(val username: String, val password: String, val nombre: String)

abstract class MetodoPago {
    abstract fun pagar()
}

class TarjetaCredito : MetodoPago() {
    override fun pagar() {
        println("Ingresa el número de tu tarjeta de crédito: ")
        val numeroTarjeta = readLine()
        println("Ingresa la fecha de expiración (MM/YY): ")
        val fechaExpiracion = readLine()
        println("Ingresa el código de seguridad: ")
        val codigoSeguridad = readLine()
        println("Pago realizado con tarjeta de crédito")
    }
}

class TransferenciaBancaria : MetodoPago() {
    override fun pagar() {
        println("Ingresa el número de cuenta bancaria: ")
        val numeroCuenta = readLine()
        println("Ingresa el nombre del titular de la cuenta: ")
        val nombreTitular = readLine()
        println("Ingresa el monto a transferir: ")
        val montoTransferencia = readLine()
        println("Pago realizado con transferencia bancaria")
    }
}

class PagoOXXO : MetodoPago() {
    override fun pagar() {
        println("Ingresa el código de barras del ticket de OXXO: ")
        val codigoBarras = readLine()
        println("Pago realizado en OXXO")
    }
}

class Evento(val nombre: String, var entradasDisponibles: Int = 10)

class CompraEvento(val evento: Evento, private val precio: Int = 100, private val metodoPago: MetodoPago) {

    companion object {
        private val eventosDisponibles = listOf(
            Evento("Concierto de rock", 20),
            Evento("Festival de cine", 30),
            Evento("Obra de teatro", 15)
        )

        fun mostrarEventosDisponibles() {
            println("Eventos disponibles:")
            eventosDisponibles.forEachIndexed { index, evento ->
                println("${index + 1}. ${evento.nombre} - Entradas disponibles: ${evento.entradasDisponibles}")
            }
        }
    }

    fun comprarBoletos() {
        var seguirComprando = 1
        var costoTotal = 0.0
        while (seguirComprando == 1) {
            println("¿Cuántos boletos quieres comprar? ")
            val cantidad = readLine()?.toIntOrNull() ?: 0
            if (cantidad <= 0 || cantidad > evento.entradasDisponibles) {
                println("Cantidad no válida")
            } else {
                val costoBoletos = cantidad * precio
                costoTotal += costoBoletos
                println("Total a pagar: $costoBoletos")
                evento.entradasDisponibles -= cantidad
                println("Boletos comprados exitosamente")
                println("Entradas disponibles: ${evento.entradasDisponibles}")
                println("¿Cuál es tu método de pago preferido? (1. Tarjeta de crédito / 2. Transferencia bancaria / 3. Pago en OXXO): ")
                val opcion = readLine()?.toIntOrNull()
                when (opcion) {
                    1 -> metodoPago.pagar()
                    2 -> metodoPago.pagar()
                    3 -> PagoOXXO().pagar()
                    else -> println("Opción no válida")
                }
                println("¿Quieres seguir comprando? (Sí= 1 / No= 0): ")
                seguirComprando = readLine()?.toIntOrNull() ?: 0
            }
        }
    }
}



class Registro {
    fun login(): Pair<String, String> {
        print("Ingresa tu nombre de usuario: ")
        val username = readLine()
        print("Ingresa tu contraseña: ")
        val password = readLine()

        return Pair(username ?: "", password ?: "")
    }

    fun mostrarPerfil(usuario: Usuario) {
        println("Nombre: ${usuario.nombre}")
        println("Nombre de usuario: ${usuario.username}")
    }

    fun registrarUsuario(): Usuario {
        print("Ingresa tu nombre completo: ")
        val nombre = readLine() ?: ""
        print("Ingresa tu nombre de usuario: ")
        val username = readLine() ?: ""
        print("Ingresa tu contraseña: ")
        val password = readLine() ?: ""

        return Usuario(username, password, nombre)
    }
}

class InicioSesion {
    fun iniciarSesion(usuarios: List<Usuario>): Usuario? {
        val (username, password) = Registro().login()

        return usuarios.find { it.username == username && it.password == password }
    }
}


fun main() {
    val usuarios = mutableListOf<Usuario>()
    var option: Int? = null

    println("*****************************")
    println("* BIENVENIDO A BOLETPLUS :) *")
    println("*****************************")
    println("=== MENU ===")
    println("1. Iniciar sesión")
    println("2. Registrarse")
    println("3. Salir")

    val registro = Registro()
    val inicioSesion = InicioSesion()
    //val metodoPago = MetodoPago()
    //var metodoPago: MetodoPago? = null
    val evento = Evento("Concierto de rock")
    val metodoPago = TarjetaCredito() // Se puede cambiar por cualquier otra subclase de MetodoPago
    val compraEvento = CompraEvento(evento, metodoPago = metodoPago)




    while (option != 3) {
        print("Selecciona una opción: ")
        option = readLine()?.toIntOrNull()

        when (option) {
            1 -> {
                val usuario = inicioSesion.iniciarSesion(usuarios)
                if (usuario != null) {
                    println("¡Bienvenido ${usuario.nombre}!")
                    println("=== MENÚ ===")
                    println("1. Comprar boletos")
                    println("2. Ver mi perfil")
                    println("3. Cerrar sesión")
                    var opcionUsuario: Int? = null
                    while (opcionUsuario != 3) {
                        print("Selecciona una opción: ")
                        opcionUsuario = readLine()?.toIntOrNull()
                        when (opcionUsuario) {
                            1 -> {
                                compraEvento.comprarBoletos()//metodoPago.MetodoPago()


                            }
                            2 -> {
                                println("=== VER MI PERFIL ===")
                                registro.mostrarPerfil(usuario)
                            }
                            3 -> {
                                println("¡Hasta pronto ${usuario.nombre}!")
                            }
                            else -> {
                                println("Opción inválida, intenta de nuevo.")
                            }
                        }
                    }
                } else {
                    println("Lo sentimos, no pudimos encontrar tus datos de inicio de sesión.")
                }
            }
            2 -> {
                println("=== REGISTRARSE ===")
                val usuario = registro.registrarUsuario()
                usuarios.add(usuario)
            }
            3 -> {
                println("¡Gracias por usar BoletPlus, hasta pronto!")
            }
            else -> {
                println("Opción inválida, intenta de nuevo.")
            }
        }
    }
}


*/