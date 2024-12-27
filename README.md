# apiFranquicia
Este proyecto proporciona una API para gestionar franquicias, sucursales y productos dentro de una franquicia. La API permite realizar operaciones como la creación, actualización y obtención de franquicias, sucursales y productos, mediante una serie de endpoints RESTful.
 
---
## Tabla de contenido 
* [Descripción](#descrippción)
* [Desarrollo](#desarrollo)
* [Configuración local](#configuración-local) 
* [Pruebas unitarias](#pruebas-unitarias)

---
## Descripción
Guarda frnaquicia, sucursales y productos en base de datos en memoria H2


## Desarrollo
1. Instale Java 11 y un IDE de desarrollo como Eclipse o IntelliJ.
2. Clone este repositorio.
3. Permita la construcción del proyecto con gradle.
4. Inicialice el proyecto desde ApiFranquiciaApplication
5. Pruebe conumiendo el servicio con una herramienta para consumir apis como postman


## Configuración local
1. Se debe instalar java en el equipo  MAC (https://www.java.com/es/download/help/mac_install.html), Windows (https://www.java.com/es/download/ie_manual.jsp)
2. Se debe instalar un IDE para abrir el proyecto https://www.jetbrains.com/idea/download
3. Se debe abrir el proyecto con intellij
4. Se debe ingresar al archivo resources/application.yamel y ajustar las variables  de expresion regular de contraseña
5. Una vez podamos ver todos los archivos en intellij se debe dar click derecho en la clase apiUsersApplication y dar click en Run
---


-metodo Post
-Url:http://localhost:80/userapi/api/franchises
##### REQUEST

```
{
  "name": "Franquicia Y",
  "branches": []
}
```

##### RESPONSE 200
```
{
    "id": 2,
    "name": "Franquicia Y",
    "branches": []
}
```

### Método: PUT
URL: http://localhost:80/userapi/api/franchises/franchise/{id}/name

##### REQUEST

```
"Nuevo nombre de franquicia"

```

##### RESPONSE 200
```
{
    "id": 2,
    "name": "Nuevo nombre de franquicia",
    "branches": []
}

```


### Método: `POST`

**URL**: `http://localhost:80/userapi/api/franchises/{franchiseId}/branches`

### Request:

```
{
  "name": "Sucursal 1",
  "location": "Dirección de la sucursal"
}
```
##### RESPONSE 200
```
{
  "id": 1,
  "name": "Sucursal 1",
  "location": "Dirección de la sucursal",
  "franchiseId": 2
}
```

### Método: `PUT`

**URL**: `http://localhost:80/userapi/api/franchises/branches/{id}/name`

### Request:

```
"Nuevo nombre de sucursal"

```
##### RESPONSE 200
```
{
    "id": 1,
    "name": "Nuevo nombre de sucursal",
    "location": "Dirección de la sucursal",
    "franchiseId": 2
}

```

### Método: `POST`

**URL**: `http://localhost:80/userapi/api/franchises/{franchiseId}/branches/{branchId}/products`

### Request:

```
{
  "name": "Producto A",
  "stock": 100
}
```

##### RESPONSE 200
```
{
    "id": 1,
    "name": "Producto A",
    "stock": 100
}
```

### Método: `DELETE`

**URL**: `URL: http://localhost:80/userapi/api/franchises/branches/{branchId}/products/{productId}`


##### RESPONSE 204
```
(No content, sin cuerpo de respuesta)

```


### Método: `PATCH`

**URL**: `URL: http://localhost:80/userapi/api/franchises/branches/{branchId}/products/{productId}/stock`

### Request:

```
{
  "stock": 150
}
```

##### RESPONSE 200
```
{
    "id": 1,
    "name": "Producto BBB",
    "stock": 600
}
```

### Método: `GET`

**URL**: `http://localhost:80/userapi/api/franchises/{franchiseId}/top-products`

### Request:

```

```

##### RESPONSE 200
```
[
    {
        "branchName": "branches BBB",
        "product": {
            "id": 3,
            "name": "Producto B",
            "stock": 200
        }
    }
]

```
### Método: `PUT`

**URL**: `http://localhost:80/userapi/api/franchises/product/{id}/name`

### Request:

```
"Nuevo nombre del producto"

```

##### RESPONSE 200
```
{
    "id": 1,
    "name": "Producto BBB",
    "stock": 100
}

```
## Pruebas unitarias
* JUnit
* Framework Mockito.


## Autor
- Camilo Castro

---

