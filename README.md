# 🌳 Extended Tree Project

Un proyecto Java para la implementación y manejo sencillo de árboles n-arios, con visión futura de expandirse a otros tipos de grafos.

## 📋 Tabla de Contenidos

- [Descripción General](#descripción-general)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Clases Principales](#clases-principales)
  - [ExtendedNode](#extendednode)
  - [ExtendedTree](#extendedtree)
- [Ejemplo de Uso](#ejemplo-de-uso)
- [Métodos Implementados](#métodos-implementados)
- [Limitaciones Actuales](#limitaciones-actuales)
- [Futuras Implementaciones](#futuras-implementaciones)

## 🎯 Descripción General

Este proyecto proporciona una implementación flexible de árboles n-arios en Java, diseñada para ser fácil de usar y extender. El objetivo principal es facilitar la creación, navegación y manipulación de estructuras de árbol, con planes de expandir la funcionalidad a otros tipos de grafos en el futuro.

## 📁 Estructura del Proyecto

```
.
├── Main.java                 # Clase principal con ejemplos de uso
├── tree/
│   ├── ExtendedNode.java     # Implementación de nodos del árbol
│   ├── ExtendedTree.java     # Implementación del árbol n-ario
│   └── SuperExtendedNode.java # Extensión futura (actualmente vacía)
└── context.py               # Script utilitario para documentación
```

## 🔧 Clases Principales

### ExtendedNode<E>

Clase que representa un nodo en el árbol n-ario con funcionalidades extendidas para navegación y gestión.

#### Características Principales:
- **Genérica**: Soporta cualquier tipo de dato (`E`)
- **Bidireccional**: Mantiene referencia al padre y a los hijos
- **Iteradores Múltiples**: Incluye iteradores numéricos y nativos
- **Estados definidos**: Raíz, nodo interno y hoja

#### Métodos Clave:

| Método | Descripción | Estado |
|--------|-------------|---------|
| `isRoot()` | Verifica si el nodo es raíz | ✅ **Implementado** |
| `isLeaf()` | Verifica si el nodo es hoja | ✅ **Implementado** |
| `addChildNode()` | Añade un nodo hijo | ✅ **Implementado** |
| `removeChildNode()` | Elimina un nodo hijo | ✅ **Implementado** |
| `nextChildNode()` | Obtiene el siguiente hijo | ✅ **Implementado** |
| `hasNextChildNode()` | Verifica si hay más hijos | ✅ **Implementado** |
| `resetIterators()` | Reinicia los iteradores | ✅ **Implementado** |

### ExtendedTree<E>

Clase principal que gestiona el árbol completo y proporciona algoritmos de recorrido.

#### Métodos Clave:

| Método | Descripción | Estado |
|--------|-------------|---------|
| `getValuesInPreOrder()` | Recorrido pre-orden | ⚠️ **Parcial** |
| `getRootNode()` | Obtiene nodo raíz | ✅ **Implementado** |
| `nextNodePreOrder()` | Navegación pre-orden | ⚠️ **Parcial** |

## 🚀 Ejemplo de Uso

```java
// Crear árbol y nodos
ExtendedTree<Integer> tree = new ExtendedTree<>();
ExtendedNode<Integer> root = tree.getRootNode();
root.setActualNodeValue(1);

// Construir estructura del árbol:
//        1
//       / \
//      2   3
//     / \   \
//    4   5   6

// Configurar nodos hijos
ExtendedNode<Integer> node2 = new ExtendedNode<>();
node2.setActualNodeValue(2);
root.addChildNode(node2);
node2.setParentNode(root);

// Recorrido Pre-Orden
LinkedList<Integer> preOrderResult = tree.getValuesInPreOrder();
System.out.println("Resultado PreOrden: " + preOrderResult);
// Esperado: [1, 2, 4, 5, 3, 6]
```

## 📊 Métodos Implementados

### ✅ Completamente Funcionales

- **Creación de estructura**: Construcción completa del árbol con relaciones padre-hijo
- **Navegación básica**: Movimiento entre nodos padres e hijos
- **Verificación de estado**: Identificación de raíces, hojas y nodos internos
- **Gestión de hijos**: Adición y eliminación de nodos hijos
- **Iteración básica**: Navegación secuencial through hijos

### ⚠️ Implementación Parcial

- **Recorrido Pre-Orden**: Funciona pero con limitaciones en árboles complejos
- **Gestión de iteradores**: Requiere reset manual en algunos casos

### ❌ No Implementados

- **Recorridos In-Order y Post-Order**
- **Búsqueda y filtrado de nodos**
- **Serialización/Deserialización**
- **Balanceo del árbol**
- **Algoritmos de búsqueda avanzada**

## ⚠️ Limitaciones Actuales

1. **Recorridos Incompletos**: Solo Pre-Orden está parcialmente implementado
2. **Manejo de Errores**: Limitada validación de condiciones de error
3. **Iteradores**: Pueden requerir reset manual en operaciones complejas
4. **Eficiencia**: No optimizado para árboles muy grandes
5. **Concurrencia**: No thread-safe

## 🔮 Futuras Implementaciones

### Próximas Características Planeadas:

1. **Tipos de Grafos Adicionales**:
   - Árboles binarios
   - Grafos dirigidos y no dirigidos
   - Grafos ponderados

2. **Algoritmos de Recorrido**:
   - Recorrido In-Order y Post-Order
   - Búsqueda en profundidad (DFS)
   - Búsqueda en anchura (BFS)

3. **Funcionalidades Avanzadas**:
   - Serialización JSON/XML
   - Algoritmos de balanceo
   - Búsqueda por criterios
   - Operaciones de sub-árbol

4. **Mejoras de API**:
   - Builder pattern para construcción
   - Operaciones funcionales (Stream API)
   - Manejo de errores mejorado

## 💡 Uso Recomendado

Este proyecto es ideal para:
- Aprendizaje de estructuras de árboles
- Prototipado rápido de algoritmos arbóreos
- Proyectos educativos
- Casos donde la simplicidad es más importante que el rendimiento extremo

## 🛠️ Contribuciones

Las contribuciones son bienvenidas, especialmente en:
- Implementación de recorridos faltantes
- Mejora del manejo de iteradores
- Adición de tests unitarios
- Optimización de rendimiento

---

**Nota**: Este proyecto está en desarrollo activo. Se recomienda verificar la rama principal para las últimas actualizaciones y características implementadas.
