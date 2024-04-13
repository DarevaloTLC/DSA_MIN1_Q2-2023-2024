# El ejercicio está desarrollado en torno a 3 clases, Dron, Piloto y Vuelo. Dron y Piloto comparten una lista de la clase Vuelo. Se ha creado una interfaz GestorVuelos con su implementación GestorVuelosImpl para utilizar estas clases de forma dinámica.

# Después de revisar mi código he localizado el error, las clases Dron y Piloto contienen dentro otra lista de otra clase y esto para el servicio REST era complicado de interpretar, por eso he creado dos clases más sencillas a partir de las principales.
# Ahora todo el código funciona correctamente.