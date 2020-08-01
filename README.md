# proyectoRedes1-Bingo
Repositorio dedicado a la creación de un juego de BINGO utilizando el puerto serial RS232 para la comunicación entre participantes del juego.

## Requisitos 
* Java JDK 14
* VSPE (Virtual Serial Port Emulator): Se deben crear 4 pares de puertos seriales
  1. COM1 <-> COM2
  2. COM3 <-> COM4
  3. COM5 <-> COM6
  4. COM7 <-> COM8
* Java FX
* Java Fazecast/JSerialComm

## Protocolo de comunicación:
### Mensajes para la configuración del juego:
* **B1LI1O75:** Configura el juego como un juego de línea con 1 cartón por jugador.
* **B1LI2O75:** Configura el juego como un juego de línea con 2 cartones por jugador.
*	**B1LL1O75:** Configura el juego como un juego a cartón lleno con 1 cartón por jugador.
*	**B1LL2O75:** Configura el juego como un juego a cartón lleno con 2 cartones por jugador

### Mensajes para enviar el número cantado por el jugador con el turno actual:
* **B1NUMO75:** Envía el número que salió en la jugada cantada. Ejemplos: B1-19-O75 y B1-38-075.
* **B1TNUMO75:** La T es un indicador que señala que el jugador que le envía el número está pasando el turno y la 
computadora que reciba este indicador, se coloca como computadora con turno actual y al reenviar el mensaje, lo hace sin reenviar la T. 
* **B1BNUMO75:** La B es el indicador de que alguien ha cantado bingo y este mensaje debe llegar a todas las computadoras, esto se logra
debido a que cuando una computadora hace el chequeo con la ficha cantada y logra el bingo, esta agrega la B al mensaje y espera recibir 
ese mismo mensaje a través del anillo. 
