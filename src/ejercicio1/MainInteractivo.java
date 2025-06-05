package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainInteractivo {
    public static void main(String[] args) throws Exception {
        Gestor gestor = new Gestor();
        String respuestaUsuario = "";
        try {
            while (Objects.nonNull(respuestaUsuario)) {

                gestor.imprimirMenu();
                respuestaUsuario = gestor.obtenerEntradaUsuario("Introduce una opción (número): ");
                Integer opcionSeleccionada = gestor.convertirTextoAEntero(respuestaUsuario);

                switch (opcionSeleccionada) {
                    case 0:
                        System.out.println("¡Adios!");
                        return;
                    case 1:
                        aniadirNuevoInterprete(gestor);
                        break;
                    case 2:
                        crearOUsarInterpreteYAsignarDisco(gestor);
                        break;
                    case 3:
                        Interprete interpreteDiscos = obtenerInterpreteExistente(gestor);
                        System.out.println("Cantidad total de discos: " + interpreteDiscos.getListaDiscos().size());

                        String[] listaOpciones = new String[interpreteDiscos.getListaDiscos().size() + 1];
                        int indice = 1;
                        for (Disco disco : interpreteDiscos.getListaDiscos()) {
                            listaOpciones[indice] = indice + ". " + disco.getTituloDisco();
                            indice++;
                        }
                        listaOpciones[0] = "0. Salir sin eliminar";
                        Integer indiceDisco = gestor.convertirTextoAEntero(
                                gestor.obtenerEntradaValidaTexto("Introduce el indice del disco a eliminar: ", listaOpciones));
                        if (indiceDisco != 0) {
                            interpreteDiscos.getListaDiscos().remove(indiceDisco - 1);
                            System.out.println("ejercicio1.Disco eliminado correctamente.");
                        }
                        break;
                    case 4:
                        gestor.getArbolBinario().listarInterpretes();
                        break;
                    case 5:
                        Interprete interprete = obtenerInterpreteExistente(gestor);
                        interprete.imprimirDiscos();
                        break;
                    case 6:
                        Integer anioDisco = obtenerAnioValido(gestor, "Introduce el año de los discos a listar: ", gestor.obtenerAniosValidos(), "El año del disco debe ser un valor entre 1700 y 9999.");
                        gestor.getArbolBinario().listarDiscosPorAnio(anioDisco);
                        break;

                    default:
                        System.err.println("  La opción seleccionada no es valida");
                }


            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private static Interprete obtenerInterpreteExistente(Gestor gestor) {
        String nombreInterprete =
                gestor.obtenerEntradaValidaTexto("Introduce el nombre del Intérprete: ");
        Interprete interprete = gestor.obtenerOCrearInterprete(nombreInterprete);
        if (interprete == null) {
            System.out.println("El intérprete no existe. Por favor, selecciona uno existente: ");
            gestor.getArbolBinario().listarInterpretes();
            return obtenerInterpreteExistente(gestor);
        }
        return interprete;

    }

    private static void crearOUsarInterpreteYAsignarDisco(Gestor gestor) throws Exception {
        String nombreInterprete =
                gestor.obtenerEntradaValidaTexto("Introduce el nombre del Intérprete: ");
        Interprete interprete = gestor.obtenerOCrearInterprete(nombreInterprete);
        if (interprete.getTipo() == null) {
            interprete = aniadirNuevoInterprete(gestor, interprete);
        }


        String nombreDisco = gestor.obtenerEntradaValidaTexto("Introduce el nombre del ejercicio1.Disco: ");

        Integer anioDisco = obtenerAnioValido(gestor, "Introduce el año del ejercicio1.Disco: ", gestor.obtenerAniosValidos(), "El año del disco debe ser un valor entre 1700 y 9999.");
        Integer duracionDisco = obtenerAnioValido(gestor, "Introduce la duración del ejercicio1.Disco en minutos: ", gestor.obtenerMinutosValidos(), "El valor de duración del disco debe ser un valor entre 1 y 1440.");
        Disco disco = new Disco(nombreDisco, anioDisco, duracionDisco);
        interprete.agregarDisco(disco);

    }

    private static Integer obtenerAnioValido(Gestor gestor, String mensaje, List<Integer> gestor1, String x) {
        Integer anioDisco = -1;
        while (anioDisco == -1) {
            anioDisco = gestor.convertirTextoAEntero(
                    gestor.obtenerEntradaValidaTexto(mensaje));
            Integer finalAnioDisco = anioDisco;
            if (gestor1.stream().noneMatch(given -> given.equals(finalAnioDisco))) {
                System.out.println(x);
                anioDisco = -1;
            }

        }
        return anioDisco;
    }

    private static Interprete aniadirNuevoInterprete(Gestor gestor, Interprete interprete) throws Exception {
        String nombreInterprete = interprete.getNombre();
        Interprete gestor1 = validarDuplicado(gestor, nombreInterprete);
        boolean sigueActivoBoolean = obtenerSigueActivo(gestor);
        TipoInterprete tipoInterprete = obtenerTipo(gestor);
        Interprete interpreteCreado = new Interprete(nombreInterprete, sigueActivoBoolean, new ArrayList<>(), tipoInterprete);

        gestor.getArbolBinario().insertar(interpreteCreado);
        return interpreteCreado;
    }

    private static Interprete aniadirNuevoInterprete(Gestor gestor) throws Exception {
        String nombreInterprete = obtenerNombreInterprete(gestor);
        Interprete interpreteExistente = validarDuplicado(gestor, nombreInterprete);
        if (interpreteExistente != null) {
            return aniadirNuevoInterprete(gestor);
        }

        boolean sigueActivoBoolean = obtenerSigueActivo(gestor);
        TipoInterprete tipoInterprete = obtenerTipo(gestor);
        Interprete interprete = new Interprete(nombreInterprete, sigueActivoBoolean, new ArrayList<>(), tipoInterprete);

        gestor.getArbolBinario().insertar(interprete);
        return interprete;
    }

    private static Interprete validarDuplicado(Gestor gestor, String nombreInterprete) {
        try {
            Interprete interprete = gestor.getArbolBinario().buscar(new Interprete(nombreInterprete)).getInterprete();
            if (interprete != null) {
                System.out.println(" (!)   Ese Intérprete ya existe. Prueba con otro nombre.");
                return interprete; // Devuelve null para indicar que ya existe
            }
        } catch (Exception e) {
            //System.err.println("Error al buscar el intérprete: " + e.getMessage());
        }
        return null;
    }

    private static TipoInterprete obtenerTipo(Gestor gestor) {
        String tipo =
                gestor.obtenerEntradaValidaTexto("Introduce tipo de Intérprete (número): ", "1. Solista", "2. Grupo");
        TipoInterprete tipoInterprete = tipo.equals("1") ? TipoInterprete.SOLISTA : TipoInterprete.GRUPO;
        return tipoInterprete;
    }

    private static boolean obtenerSigueActivo(Gestor gestor) {
        String sigueActivo =
                gestor.obtenerEntradaValidaTexto("Introduce si sigue activo (número): ", "1. Si", "2. No");
        boolean sigueActivoBoolean = sigueActivo.equals("1");
        return sigueActivoBoolean;
    }

    private static String obtenerNombreInterprete(Gestor gestor) {
        String nombreInterprete =
                gestor.obtenerEntradaValidaTexto("Introduce el nombre del Intérprete: ");
        return nombreInterprete;
    }

}