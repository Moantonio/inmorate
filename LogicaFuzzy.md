# 3.2 Logica Fuzzy #

## 3.2.1 Introducción ##

La lógica borrosa (Fuzzy Logic) emerge como una herramienta interesante para el control de subsistemas y procesos industriales complejos, así como también para la electrónica de entretenimiento y hogar, sistemas de diagnóstico y otros sistemas expertos. Con esta lógica se pretende representar de forma rigurosa el significado de los enunciados imprecisos del lenguaje natural.

La lógica borrosa o difusa se basa en lo relativo de lo observado. Este tipo de lógica toma dos valores aleatorios, pero contextualizados y referidos entre sí. Así, por ejemplo, una persona que mida 2 metros es claramente una persona alta, si previamente se ha tomado el valor de persona baja y se ha establecido en 1 metro. Ambos valores están contextualizados a personas y referidos a una medida métrica lineal.

En la lógica clásica una proposición sólo admite dos valores: verdadero o falso. Por ello se dice que la lógica usual es bivalente o binaria. Existen otras lógicas que admiten además un tercer valor posible (lógica trivaluada) e incluso múltiple valores de verdad (lógica multivaluada).

La lógica difusa (o borrosa) es otro tipo de lógica, que se caracteriza por querer cuantificar esta incertidumbre: Si P es una proposición, se le puede asociar un número v(P) en el intervalo [0,1] tal que:

1.	Si v(P) = 0, P es falso.
2.	Si v(P) = 1, P es verdadero.
3.	La veracidad de P aumenta con v(P).

Tomando el ejemplo de la definición, la persona más alta será M=2, y la más baja será M=1. La persona más alta será, por lo tanto, h(2)=Alto, y la más baja h(1)=Bajo. Es evidente que los valores manejados, se pueden catalogar según la lógica clásica a valores de Verdadero o Falso. Si h(M) = Alto (o Verdadero) entonces se producen una serie de consecuencias, si h(M) = Bajo (o Falso) entonces se producen una serie distinta de consecuencias. La dificultad viene cuando los grados pueden ser intermedios. Por ejemplo, de forma intermedia podemos decir que una persona que mida 1,82 m es alta con grado 0,75 indicando que es "bastante alta", teniendo en cuenta que la persona en cuestión sea masculina.

Lo central en la lógica borrosa o “fuzzy logic” es que, de modo distinto a la lógica clásica de sistemas, se orienta hacia la modelización de modos de razonamiento imprecisos, los cuales juegan un rol esencial en la destacable habilidad humana de trazar decisiones racionales en un ambiente de incertidumbre e imprecisión. Esta habilidad depende, en cambio, de nuestra habilidad de inferir una respuesta aproximada a preguntas basadas en un conjunto de conocimiento que es inexacto, incompleto o no totalmente confiable.

Esta simple idea nació en un artículo de Lotfi A. Zadeh publicado en 1965 y titulado "Fuzzy Sets" (Conjuntos Difusos). La lógica difusa permite representar de forma matemática conceptos o conjuntos imprecisos, tales como días fríos, meses calurosos, personas altas, salarios bajos, guisos con mucho condimento, profesores poco valorados, etc.
Pero hay que tener en cuenta que la idea en sí de que las cosas no son blancas o negras, sino que existen infinitos matices de grises viene ya desde la época de los primeros grandes filósofos como Platón.
Posteriormente a ellos, otros grandes pensadores como David Hume o Kant apoyaban esta idea manteniendo que el razonamiento venía dado por las observaciones de las que somos testigos a lo largo de nuestra vida y la detección de algunos principios contradictorios en la lógica clásica.
Tras la publicación de Lotfi A. Zadeh, se comenzó rápidamente a usar la lógica difusa en distintas aplicaciones prácticas, llegando a su máximo auge a principios de los años 90, y continuando éste hasta la época actual.

Funcionamiento

La lógica difusa se adapta mejor al mundo real en el que vivimos, e incluso puede comprender y funcionar con nuestras expresiones, del tipo "hace mucho calor", "no es muy alto", "el ritmo del corazón está un poco acelerado", etc.
La clave de esta adaptación al lenguaje, se basa en comprender los cuantificadores de nuestro lenguaje (en los ejemplos de arriba "mucho", "muy" y "un poco").
En la teoría de conjuntos difusos se definen también las operaciones de unión, intersección, diferencia, negación o complemento, y otras operaciones sobre conjuntos (ver también subconjunto difuso), en los que se basa esta lógica.
Para cada conjunto difuso, existe asociada una función de pertenencia para sus elementos, que indican en qué medida el elemento forma parte de ese conjunto difuso. Las formas de las funciones de pertenencia más típicas son trapezoidal, lineal y curva.
Se basa en reglas heurísticas de la forma SI (antecedente) ENTONCES (consecuente), donde el antecedente y el consecuente son también conjuntos difusos, ya sea puros o resultado de operar con ellos. Sirvan como ejemplos de regla heurística para esta lógica (nótese la importancia de las palabras "muchísimo", "drásticamente", "un poco" y "levemente" para la lógica difusa):

SI hace muchísimo calor ENTONCES disminuyo drásticamente la temperatura.
SI voy a llegar un poco tarde ENTONCES aumento levemente la velocidad.

Los métodos de inferencia para esta base de reglas deben ser simples, veloces y eficaces. Los resultados de dichos métodos son un área final, fruto de un conjunto de áreas solapadas entre sí (cada área es resultado de una regla de inferencia). Para escoger una salida concreta a partir de tanta premisa difusa, el método más usado es el del centroide, en el que la salida final será el centro de gravedad del área total resultante.
Las reglas de las que dispone el motor de inferencia de un sistema difuso pueden ser formuladas por expertos, o bien aprendidas por el propio sistema, haciendo uso en este caso de Redes neuronales para fortalecer las futuras tomas de decisiones.
Los datos de entrada suelen ser recogidos por sensores, que miden las variables de entrada de un sistema. El motor de inferencias se basa en chips difusos, que están aumentando exponencialmente su capacidad de procesamiento de reglas año a año.
Un esquema de funcionamiento típico para un sistema difuso podría ser de la siguiente manera:

Funcionamiento de un sistema de control difuso

En la figura, el sistema de control hace los cálculos con base en sus reglas heurísticas, comentadas anteriormente. La salida final actuaría sobre el entorno físico, y los valores de las nuevas entradas sobre el entorno físico (modificado por la salida del sistema de control) serían tomadas por sensores del sistema.
Por ejemplo, imaginando que nuestro sistema borroso fuese el climatizador de un coche que se autorregula según las necesidades: Los chips borrosos del climatizador recogen los datos de entrada, que en este caso bien podrían ser la temperatura y humedad simplemente. Estos datos se someten a las reglas del motor de inferencia (como se ha comentado antes, de la forma SI... ENTONCES... ), resultando un área de resultados. De esa área se escogerá el centro de gravedad, proporcionándola como salida. Dependiendo del resultado, el climatizador podría aumentar la temperatura o disminuirla dependiendo del grado de la salida.

Aplicaciones

La lógica difusa se utiliza cuando la complejidad del proceso en cuestión es muy alta y no existen modelos matemáticos precisos, para procesos altamente no lineales y cuando se envuelven definiciones y conocimiento no estrictamente definido (impreciso o subjetivo).
En cambio, no es una buena idea usarla cuando algún modelo matemático ya soluciona eficientemente el problema, cuando los problemas son lineales o cuando no tienen solución.
Esta técnica se ha empleado con bastante éxito en la industria, principalmente en Japón, y cada vez se está usando en gran multitud de campos. La primera vez que se usó de forma importante fue en el metro japonés, con excelentes resultados. A continuación se citan algunos ejemplos de su aplicación:

Sistemas de control de acondicionadores de aire
Sistemas de foco automático en cámaras fotográficas
Electrodomésticos familiares (Frigoríficos, lavadoras...)
Optimización de sistemas de control industriales
Sistemas de reconocimiento de escritura
Mejora en la eficiencia del uso de combustible en motores
Sistemas expertos del conocimiento (simular el comportamiento de un experto humano)
Tecnología informática
Bases de datos difusas: Almacenar y consultar información imprecisa. Para este punto, por ejemplo, existe el lenguaje FSQL.
...y, en general, en la gran mayoría de los sistemas de control que no dependen de un Sí/No.

Conjuntos borrosos

Los elementos fundamentales de la teoría de sistemas borrosos son los conjuntos borrosos (fuzzy). Sobre ellos se pueden realizar operaciones, algunas de ellas semejantes a las que se realizan con los conjuntos clásicos. Finalmente, la lógica borrosa está basada en combinaciones de conjuntos difusos mediante las mencionadas operaciones.
Los conjuntos borrosos, son conjuntos en los que se define una función llamada "función de pertenencia", que asigna a cada elemento del conjunto, un valor que representa el grado en que dicho valor pertenece al conjunto. A cada conjunto se le asocia un cuantificador lingüístico, como por ejemplo, mucho, poco, bastante etc., de forma que relacionamos el modelo matemático con el lenguaje humano.
Sea X un universo de discurso. Un conjunto difuso (fuzzy) A se define mediante su función de pertenencia:
Así, dicho conjunto queda identificado mediante parejas de elementos
donde el símbolo "/" no representa ningún cociente sino que tiene la función de un separador. La forma específica de la función μA depende de los objetivos del modelo fuzzy. Por ejemplo, puede ser continua lineal a trozos. Si μA es la función característica de A, entonces A es un conjunto clásico (no fuzzy).

(continuar con documentación sobre conjuntos borrosos).

Otra opcion.

Un tipo de lógica que reconoce más que simples valores verdaderos y falsos. Con lógica difusa, las proposiciones pueden ser representadas con grados de veracidad o falsedad. Por ejemplo, la sentencia "hoy es un día soleado", puede ser 100% verdad si no hay nubes, 80% verdad si hay pocas nubes, 50% verdad si existe neblina y 0% si llueve todo el día.

La Lógica Difusa ha sido probada para ser particularmente útil en sistemas expertos y otras aplicaciones de inteligencia artificial. Es también utilizada en algunos correctores de voz para sugerir una lista de probables palabras a reemplazar en una mal dicha. La Lógica Difusa, que hoy en día se encuentra en constante evolución, nació en los años 60 como la lógica del razonamiento aproximado, y en ese sentido podía considerarse una extensión de la Lógica Multivaluada. La Lógica Difusa actualmente está relacionada y fundamentada en la teoría de los Conjuntos Difusos.Según esta teoría, el grado de pertenencia de un elemento a un conjunto va a venir determinado por una función de pertenencia, que puede tomar todos los valores reales comprendidos en el intervalo [0,1]. La representación de la función de pertenencia de un elemento a un Conjunto Difuso se representa según la figura 1.

Ejemplo de una función de pertenencia a un Conjunto Difuso.

La Lógica Difusa (llamada también Lógica Borrosa por otros autores) o Fuzzy Logic es básicamente una lógica con múltiples valores, que permite definir valores en las áreas oscuras entre las evaluaciones convencionales de la lógica precisa: Si / No, Cierto / Falso, Blanco / Negro, etc. Se considera un súper conjunto de la Lógica Booleana. Con la Lógica Difusa, las proposiciones pueden ser representadas con grados de certeza o falsedad. La lógica tradicional de las computadoras opera con ecuaciones muy precisas y dos respuestas: Si o no, uno o cero. Ahora, para aplicaciones de computadores muy mal definidas o sistemas vagos se emplea la Lógica Difusa.

Por medio de la Lógica Difusa pueden formularse matemáticamente nociones como un poco caliente o muy frío, para que sean procesadas por computadoras y cuantificar expresiones humanas vagas, tales como "Muy alto" o "luz brillante". De esa forma, es un intento de aplicar la forma de pensar humana a la programación de los computadores. Permite también cuantificar aquellas descripciones imprecisas que se usan en el lenguaje y las transiciones graduales en electrodomésticos como ir de agua sucia a agua limpia en una lavadora, lo que permite ajustar los ciclos de lavado a través de sensores. La habilidad de la Lógica Difusa para procesar valores parciales de verdad ha sido de gran ayuda para la ingeniería. En general, se ha aplicado a:

Sistemas expertos.
Verificadores de ortografía, los cuales sugieren una lista de palabras probables para reemplazar una palabra mal escrita.
Control de sistemas de trenes subterráneos.

Los operadores lógicos que se utilizarán en Lógica Difusa (AND, OR, etc.) se definen también usando tablas de verdad, pero mediante un "principio de extensión" por el cual gran parte del aparato matemático clásico existente puede ser adaptado a la manipulación de los Conjuntos Difusos y, por tanto, a la de las variables lingüísticas.

La operación más importante para el desarrollo y creación de Reglas Lógicas es la implicación, simbolizada por " ® " que representa el "Entonces" de las reglas heurísticas: Si (...) Entonces ( ® ) (...).

Así, en la Lógica Difusa hay muchas maneras de definir la implicación. Se puede elegir una "función (matemática) de implicación" distinta en cada caso para representar a la implicación.

La última característica de los sistemas lógicos es el procedimiento de razonamiento, que permite inferir resultados lógicos a partir de una serie de antecedentes. Generalmente, el razonamiento lógico se basa en silogismos, en los que los antecedentes son por un lado las proposiciones condicionales (nuestras reglas), y las observaciones presentes por otro (serán las premisas de cada regla).

Los esquemas de razonamiento utilizados son "esquemas de razonamiento aproximado", que intentan reproducir los esquemas mentales del cerebro humano en el proceso de razonamiento. Estos esquemas consistirán en una generalización de los esquemas básicos de inferencia en Lógica Binaria (silogismo clásico).

Tan importante será la selección de un esquema de razonamiento como su representación material, ya que el objetivo final es poder desarrollar un procedimiento analítico concreto para el diseño de controladores difusos y la toma de decisiones en general. Una vez que dispongamos de representaciones analíticas de cada uno de los elementos lógicos que acabamos de enumerar, estaremos en disposición de desarrollar formalmente un controlador "heurístico" que nos permita inferir el control adecuado de un determinado proceso en función de un conjunto de reglas "lingüísticas", definidas de antemano tras la observación de la salida y normas de funcionamiento de éste.


Conjuntos difusos: Lógica Difusa:

Predicados Vagos y Conjuntos Difusos.

Los conjuntos clásicos se definen mediante un predicado que da lugar a una clara división del Universo de Discurso X en los valores "Verdadero" y "Falso". Sin embargo, el razonamiento humano utiliza frecuentemente predicados que no se pueden reducir a este tipo de división: son los denominados predicados vagos.

Por ejemplo, tomando el Universo de Discurso formado por todas las posibles temperaturas ambientales en la ciudad de Huelva, se puede definir en dicho universo el conjunto A como aquél formado por las temperaturas "cálidas". Por supuesto, es imposible dar a A una definición clásica, ya que su correspondiente predicado no divide el universo X en dos partes claramente diferenciadas. No podemos afirmar con rotundidad que una temperatura es "cálida" o no lo es. El problema podría resolverse en parte considerando que una temperatura es "cálida" cuando su valor supera cierto umbral fijado de antemano. Se dice que el problema tan sólo se resuelve en parte, y de manera no muy convincente, por dos motivos: de una parte el umbral mencionado se establece de una manera arbitraria, y por otro lado podría darse el caso de que dos temperaturas con valores muy diferentes fuesen consideradas ambas como "cálidas". Evidentemente, el concepto "calor" así definido nos daría una información muy pobre sobre la temperatura ambiental.

La manera más apropiada de dar solución a este problema es considerar que la pertenencia o no pertenencia de un elemento x al conjunto A no es absoluta sino gradual. En definitiva, definiremos A como un Conjunto Difuso. Su función de pertenencia ya no adoptará valores en el conjunto discreto {0,1} (lógica booleana), sino en el intervalo cerrado [0,1]. En conclusión podemos observar que los Conjuntos Difusos son una generalización de los conjuntos clásicos.

Mediante notación matemática se define un Conjunto Difuso B como:

B = { ( x , mB( x ) ) / x å X }
mB: X® [0,1]

La función de pertenencia se establece de una manera arbitraria, lo cual es uno de los aspectos más flexibles de los Conjuntos Difusos. Por ejemplo, se puede convenir que el grado de pertenencia de una temperatura de "45ºC" al conjunto A es 1, el de "25ºC" es 0.4 , el de "6ºC" es 0, etc.: cuanto mayor es el valor de una temperatura, mayor es su grado de pertenencia al conjunto B. Para operar en la práctica con los Conjuntos Difusos se suelen emplear funciones de pertenencia del tipo representado en la figura 2:

Tipos de funciones de pertenencia.

En la figura se pueden observar dos tipos de funciones de pertenencia de todos los posibles: el tipo triangular, que puede ser un caso concreto del trapezoidal en el que los dos valores centrales son iguales, y el de forma de campana gaussiana. Tómese ahora el Universo de Discurso de la edad. El Conjunto Difuso "Joven" representa el grado de pertenencia respecto al parámetro juventud que tendrían los individuos de cada edad. Es decir, el conjunto expresa la posibilidad de que un individuo sea considerado joven. Un Conjunto Difuso podría ser considerado como una distribución de posibilidad, que es diferente a una distribución de probabilidad.

Se puede observar que los Conjuntos Difusos de la figura 3 se superponen, por lo que un individuo xl podría tener distintos grados de pertenencia en dos conjuntos al mismo tiempo: "Joven" y "Maduro". Esto indica que posee cualidades asociadas con ambos conjuntos. El grado de pertenencia de x en A, como ya se ha señalado anteriormente, se representa por m A(x). El Conjunto Difuso A es la unión de los grados de pertenencia para todos los puntos en el Universo de Discurso X, que también puede expresarse como:

Bajo la notación de los Conjuntos Difusos, µA(x)/x es un elemento del conjunto A. La operación òx representa la unión de los elementos difusos µA(x)/x. Los Universos de Discurso con elementos discretos utilizan los símbolos "+" y "S " para representar la operación unión.

Veamos un ejemplo:

Ejemplo de Conjuntos Difusos en el universo de la edad.

Tómese un individuo x cuya edad sea de 20 años. Como se puede observar en la figura, pertenece al Conjunto Difuso "Joven" y al Conjunto Difuso "Maduro". Se puede observar que posee un grado de pertenencia µA(x) de 0.6 para el Conjunto Difuso "Joven" y un grado de 0.4 para el Conjunto Difuso "Maduro"; también posee un grado de 0 para "Viejo". De este ejemplo se puede deducir que un elemento puede pertenecer a varios Conjuntos Difusos a la vez aunque con distinto grado. Así, nuestro individuo x tiene un grado de pertenencia mayor al conjunto "Joven " que al conjunto "Maduro"(0.6 > 0.4), pero no se puede decir, tratándose de Conjuntos Difusos, que x es joven o que x es maduro de manera rotunda.

Operaciones entre Conjuntos difusos:

Los Conjuntos Difusos se pueden operar entre sí del mismo modo que los conjuntos clásicos. Puesto que los primeros son una generalización de los segundos, es posible definir las operaciones de intersección, unión y complemento haciendo uso de las mismas funciones de pertenencia:

µAÇ B (x) = minµA(x), µB(x) )
µAÈ B (x) = max ( µA(x), µB(x) )
µØ A (x) = 1 - µA(x)
En realidad, estas expresiones son bastante arbitrarias y podrían haberse definido de muchas otras maneras. Esto obliga a considerar otras definiciones más generales para las operaciones entre los Conjuntos Difusos. En la actualidad se considera correcto definir el operador intersección mediante cualquier aplicación t-norma y el operador unión mediante cualquier aplicación s-norma. <

Variables Lingüísticas

La Teoría de Conjuntos Difusos puede utilizarse para representar expresiones lingüísticas que se utilizan para describir conjuntos o algoritmos. Los Conjuntos Difusos son capaces de captar por sí mismos la vaguedad lingüística de palabras y frases comúnmente aceptadas, como "gato pardo" o "ligero cambio". La habilidad humana de comunicarse mediante definiciones vagas o inciertas es un atributo importante de la inteligencia.

Una Variable Lingüística es aquella variable cuyos valores son palabras o sentencias que van a enmarcarse en un lenguaje predeterminado. Para estas variables lingüísticas se utilizará un nombre y un valor lingüístico sobre un Universo de Discurso. Además, podrán dar lugar a sentencias generadas por reglas sintácticas, a las que se les podrá dar un significado mediante distintas reglas semánticas.

Los Conjuntos Difusos pueden utilizarse para representar expresiones tales como:

X es PEQUEÑO.
La velocidad es RÁPIDA.
El ganso es CLARO.
Las expresiones anteriores pueden dar lugar a expresiones lingüísticas más complejas como:
X no es PEQUEÑO.
La velocidad es RÁPIDA pero no muy RÁPIDA.
El ganso es CLARO y muy ALEGRE.
Así, se pueden ir complicando las expresiones. Por ejemplo, la expresión "x no es PEQUEÑO" puede calcularse a partir de la original calculando el complemento de la siguiente forma:

µ\_no\_PEQUEÑA (x) = 1- µ\_PEQUEÑO (x)
Tratando de esta forma los distintos modificadores lingüísticos (muy, poco, rápido, lento...) pueden ir calculándose todas las expresiones anteriores.

(continuar con documentacion)


## 3.2.2 Herramientas ##

Comparativas.

XFuzzy, FFLL, Spark Fuzzy Logic Editor, etc...

## 3.2.3 XFuzzy ##

(traducir)

Xfuzzy is a development environment for fuzzy-inference-based systems. It
is composed of several tools that cover the different stages of the fuzzy system
design process, from their initial description to the final implementation. Its
main features are the capability for developing complex systems and the
flexibility of allowing the user to extend the set of available functions. The
environment has been completely programmed in Java, so it can be executed
on any platform with JRE (Java Runtime Environment) installed. The next figure
shows the design flow of Xfuzzy 3.0.
The description stage includes graphical tools for the fuzzy system definition. The
verification stage is composed of tools for simulation, monitoring and representing
graphically the system behavior. The tuning stage consists in applying learning
algorithms. Finally, the synthesis stage is divided into tools generating high-level
languages descriptions for software or hardware implementations.
The nexus between all these tools is the use of a common specification language,
XFL3, which extends the capabilities of XFL, the language defined in version 2.0.
XFL3 is a flexible and powerful language, which allows to express very complex
relations between the fuzzy variables, by means of hierarchical rule bases and userdefined
fuzzy connectives, linguistic hedges, membership functions and
defuzzification methods.
Every tool can be executed as an independent program. The environment
integrates all of them under a graphical user interface which eases the design
process.

(valoracion)