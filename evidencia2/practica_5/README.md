\# Sistema de Pedido de Comida - Fragments y Navegación Manual



Este proyecto es una aplicación Android desarrollada en \*\*Kotlin\*\* que ejemplifica cómo manejar múltiples Fragments y la navegación manual entre ellos, sin apoyarse en el \*\*Navigation Component\*\* de Jetpack.  

Su propósito es didáctico, ideal para estudiantes que desean aprender los conceptos básicos del manejo de Fragments y la comunicación entre ellos.



---



\## 🎯 Propósito



Brindar al usuario la posibilidad de crear un pedido de comida de forma interactiva:



\- Escoger la categoría principal del plato (ejemplo: pizza, hamburguesa o ensalada).

\- Añadir complementos o extras (bebida, papas, postre).

\- Visualizar un resumen del pedido antes de confirmarlo.

\- Editar el pedido en caso de ser necesario.



---



\## 🚀 Funcionalidades



\- Navegación entre Fragments implementada con \*\*FragmentManager\*\* y \*\*FragmentTransaction\*\*.  

\- Envío de información entre Fragments utilizando \*\*Bundle\*\* y \*\*arguments\*\*.  

\- Comunicación de retorno mediante \*\*setFragmentResult()\*\* y \*\*setFragmentResultListener()\*\*.  

\- Manejo de la pila de navegación con \*\*addToBackStack()\*\* para habilitar el botón "Atrás".  

\- Conservación del estado al realizar modificaciones en el pedido.  



---



\## 🛠️ Requisitos Técnicos



\- \*\*Android Studio\*\* (versión Giraffe o superior recomendada).  

\- \*\*SDK de Android\*\* con nivel mínimo de API 21.  

\- \*\*Kotlin 1.8+\*\* como lenguaje principal.  



---



\## 📌 Nota



Este proyecto fue desarrollado con fines académicos y de práctica.  

El código puede ser extendido para incluir funcionalidades más avanzadas como base de datos local, persistencia o integración con servicios externos.



