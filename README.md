# Patrón de diseño Factory Method

## Actividad 3 - Patrones de diseño.

*Autor: Juan Dirceu Navarro Arias*

**Factory Method.**

Este patrón de diseño es utilizado cuando es conveniente ocultar la creación de objetos, esto debido a que no se sabe de que tipo son ni en que momento se los creará.

**Como usar.**

El ejemplo propuesto trata de un decodificador de archivos de video, se reconoce tres tipos de formatos: mkv, mp4, mov.

El usuario solo tiene que introducir en nombre del archivo, el programa detecta el tipo de archivo y elige el objeto adecuado para realizar la decodificación.

Ejemplo 1:  
_$ java FactoryMethod atardecer.mkv_

Se obtiene la siguiente respuesta:  
_Video 'atardecer.mkv' fue decodificado._

Ejemplo 2:  
_$ java FactoryMethod atardecer.mp4_

Se obtiene la siguiente respuesta:  
_Video 'atardecer.mp4' fue decodificado._

**Herramientas.**

El ejemplo está escrito en Java, se utilizó Eclipse Oxygen.2 Release (4.7.2) como editor de coódigo fuente, la máquina virtual de Java de Oracle jdk1.8.0_92 y Debian 9 como sistema operativo. 

**Compilar.**

Para compilar se puede hacerlo desde Eclipse o utilizando el comando javac: 

_$ javac FactoryMethod.java_ 


![Patron Factory Method](https://www.patronesdediseño.com/img/patterns-articles/factory-method-diagram.png)

Fuente: Oscar Javier Blancarte Iturralde, www.patronesdediseño.com

