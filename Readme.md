# Arquitectura MVC

Aplicación que trabaja con objetos coches, modifica la velocidad y la muestra

---
## Diagrama de clases:

```mermaid
classDiagram
    class Coche {
        String: matricula
        String: modelo
        Integer: velocidad
    }
      class Controller{
          +main()
      }
      class View {
          +muestraVelocidad(String, Integer)
          +mostrarCoche(Coche)
          +limiteVelocidad(Integer)
          }
      class Model {
          ArrayList~Coche~: parking
          +crearCoche(String, String, String)
          +getCoche(String)
          +cambiarVelocidad(String, Integer)
          +getVelocidad(String)
      }
      class ObsExceso{
          +update(Observable, Object)
      }
      class ClaseObserver{
          +update(Observable, Object)
      }
    Controller "1" *-- "1" ObsExceso : association
    Controller "1" *-- "1" ClaseObserver : association
    Controller "1" *-- "1" Model : association
    Controller "1" *-- "1" View : association
    Model "1" *-- "1..n" Coche : association
      
```

---

## Diagrama de Secuencia

Ejemplo básico del procedimiento, sin utilizar los nombres de los métodos


```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    Controller->>Model: Puedes crear un coche?
    activate Model
    Model-->>Controller: Creado!
    deactivate Model
    Controller->>+View: Muestra la velocidad, porfa
    activate View
    View->>-View: Mostrando velocidad
    View-->>Controller: Listo!
    deactivate View
```

El mismo diagrama con los nombres de los métodos

```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    Controller->>Model: crearCoche("Mercedes", "BXK 1234")
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller->>+View: muestraVelocidad("BXK 1234", velocidad)
    activate View
    View->>-View: System.out.println()
    View-->>Controller: boolean
    deactivate View
```
Diagrama ejemplo aumentarVelocidad y bajarVelocidad

```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    Controller->>Model: crearCoche("Mercedes", "BXK 1234")
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller->>Model: cambiarVelocidad("BXK 1234", 150)
    activate Model
    Model-->>Controller: Nueva velocidad
    deactivate Model
    Controller->>+View: muestraVelocidad("BXK 1234", velocidad)
    activate View
    View->>-View: System.out.println()
    View-->>Controller: boolean
    deactivate View
    Controller->>Model: aumentarVelocidad("BXK 1234", 10)
    activate Model
    Model-->>Controller: Nueva velocidad
    deactivate Model
    Controller->>+View: muestraVelocidad("BXK 1234", velocidad)
    activate View
    View->>-View: System.out.println()
    View-->>Controller: boolean
    deactivate View
    Controller->>Model: bajarVelocidad("BXK 1234", 15)
    activate Model
    Model-->>Controller: Nueva velocidad
    deactivate Model
    Controller->>+View: muestraVelocidad("BXK 1234", velocidad)
    activate View
    View->>-View: System.out.println()
    View-->>Controller: boolean
    deactivate View
```

# Nueva función buscar coches

---

####  Función añadida al programa de coches

Ahora se pueden buscar coches creados por su matricula usando el nuevo boton implementado en la UI

### Pasos para la implementacion de la nueva función

+ Crear metodo mostrarCoche en View, que recibe un objeto de coche y lo muestra.
+ Crear un metodo buscarCoche en Controller que llame a getCoche (metodo de Model), y al nuevo metodo mostrarCoche.
+ Añadir boton Mostrar Coche a la IU, que llama al metodo buscarCoche del Controller.

# Nueva función limite de velocidad excedida

---

### Pasos seguidos para implementar la nueva función

+ Se crea clase ObsExceso, que revisa que la velocidad no exceda 120 km/h.
+ Se crea metodo de dialogo para generar dialogos de alerta.
+ Se crea metodo en View para avisar de velocidad excedida con una alerta.
+ Se añade observer de tipo ObsExceso a la clase Controller.