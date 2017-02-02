# Semperti Property Evaluator

Este _bundle_ tiene un plugin para para los _property placeholders ext_ de _Blueprint_. Primero busca una variable de ambiente
con el nombre de la propiedad, de encontrarla, devuelve el valor de la variable de ambiente, si no, el valor seteado.

## Maven

```
<dependency>
    <groupId>com.semperti.karaf.blueprint</groupId>
    <artifactId>semperti-karaf-blueprint</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Ejemplo

```xml
<?xml version="1.0" encoding="UTF-8"?>
<blueprint xmlns="http://www.osgi.org/xmlns/blueprint/v1.0.0"
    xmlns:ext="http://aries.apache.org/blueprint/xmlns/blueprint-ext/v1.5.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.osgi.org/xmlns/blueprint/v1.0.0 http://www.osgi.org/xmlns/blueprint/v1.0.0/blueprint.xsd
        http://camel.apache.org/schema/blueprint
        http://camel.apache.org/schema/blueprint/camel-blueprint.xsd">

    <ext:property-placeholder evaluator="semperti" />
</blueprint>
```

## Jexl Evaluator

Este bundle se baso en _Jexl Evaluator_ versión: `1.0.1.redhat-60092` ([pom](https://maven.repository.redhat.com/ga/org/apache/aries/blueprint/org.apache.aries.blueprint.jexl.evaluator/1.0.1.redhat-60092/org.apache.aries.blueprint.jexl.evaluator-1.0.1.redhat-60092.pom), [jar + sources](https://maven.repository.redhat.com/ga/org/apache/aries/blueprint/org.apache.aries.blueprint.jexl.evaluator/1.0.1.redhat-60092/org.apache.aries.blueprint.jexl.evaluator-1.0.1.redhat-60092-sources.jar))

Repositorio _svn_: `http://svn.apache.org/viewvc/aries/trunk/blueprint/blueprint-jexl-evaluator`
