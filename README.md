# Pokémon App

Una aplicación móvil desarrollada en Kotlin que interactúa con la API de Pokémon para ofrecer una experiencia completa de exploración de Pokémon. Los usuarios pueden registrarse, iniciar sesión y explorar una lista de Pokémon con detalles interactivos.

## Funcionalidades

- **Registro e inicio de sesión**: Los usuarios pueden crear una cuenta y autenticarse para acceder a la aplicación.
- **Lista de Pokémon**: Una vista en forma de RecyclerView muestra todos los Pokémon disponibles, con imágenes cargadas dinámicamente.
- **Detalles del Pokémon**: Al hacer clic en un Pokémon, se abre una nueva pantalla con información detallada sobre ese Pokémon.

## Tecnologías y herramientas utilizadas

- **Kotlin**: Lenguaje principal para el desarrollo de la aplicación.
- **API de Pokémon**: Fuente de datos para la lista y los detalles de los Pokémon.
- **Retrofit**: Para realizar llamadas HTTP a la API.
- **Picasso**: Para cargar y mostrar imágenes de los Pokémon.
- **Gson**: Para manejar la conversión de JSON a objetos de Kotlin.
- **Coroutines**: Para manejar las operaciones asincrónicas de forma eficiente.

## Cómo funciona

1. **Pantalla de registro/inicio de sesión**: Los usuarios ingresan su información, que se valida y almacena localmente.
2. **Exploración de Pokémon**: La app realiza una solicitud a la API de Pokémon para obtener una lista de Pokémon y la muestra en una RecyclerView.
3. **Detalles interactivos**: Al seleccionar un Pokémon, se carga una nueva pantalla con su imagen y detalles clave, obtenidos también de la API.

Video demostracion:
[Screen_recording_20241124_161308.webm](https://github.com/user-attachments/assets/607bb424-de56-495d-862c-a29ff24747ec)
