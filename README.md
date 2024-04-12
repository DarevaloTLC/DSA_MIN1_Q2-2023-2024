# El ejercicio está desarollado entorno a 3 clases, Dron, Piloto y Vuelo. Dron y Piloto comparten una lista de la clase Vuelo. Se ha creado una interfaz GestorVuelos con su implementación GestorVuelosImpl para utilizar estas clases de forma dinámica.

# A partir de esta implementación se ha creado una RESTAPI con algunos de los metodos requeridos en el enunciado.

# El codigo de la implementación es completamente funcional, el codigo del servicio REST es donde falla. No funcionan los metodos GET. El error es el siguiente: org.glassfish.jersey.message.internal.WriterInterceptorExecutor$TerminalWriterInterceptor aroundWriteTo SEVERE: MessageBodyWriter not found for media type=application/json, type=class java.util.ArrayList, genericType=java.util.List<edu.upc.dsa.models.Vuelo>.
# Sospecho que el error es por el tipo de configuración que he utilizado al crear las clases.
