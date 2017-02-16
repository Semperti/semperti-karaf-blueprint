# Semperti Property Evaluator

This bundle was develop in order to use Openshift's enviromental variable configuration under [JBoss Fuse Integration Service (FIS) proyects](https://docs.openshift.com/enterprise/3.1/using_images/xpaas_images/fuse.html).
Red Hat's JBoss Fuse `6.2.x` comes with Apache Camel `2.15`, althought [Camel Property placeholders](http://camel.apache.org/using-propertyplaceholder.html) can read OS's environmental variables in the _Camel Context_, the
developer cannot use these variable in the rest of the blueprint file. In order to achive this, a property evaluator was develop.

This bundle is a plugin for the _property placeholder ext_ of _Blueprint_. The idea came from the [Fabric8 Karaf Blueprint Support](https://fabric8.io/guide/karaf.html#fabric8-karaf-blueprint-support).
It leverages [Aries PropertyEvaluator](https://github.com/apache/aries/blob/trunk/blueprint/blueprint-core/src/main/java/org/apache/aries/blueprint/ext/evaluator/PropertyEvaluator.java)
and a custom property placeholder resolver to let you resolve placeholders in your Blueprint XML file.

Basically, provides the posibility of reading OS environmental variables. This environmental variables have a higher precedence than the property file.

In addition, it adds the function `service:NAME`. This function uses two _placeholders_ defined using the _service naming idiom_:

* `<NAME>_SERVICE_HOST`: in order to obtain the _host_
* `<NAME>_SERVICE_PORT`: in order to obtain the _port_

## Maven

```
<dependency>
    <groupId>com.semperti.karaf.blueprint</groupId>
    <artifactId>semperti-karaf-blueprint</artifactId>
    <version>1.0.1</version>
</dependency>
```

## Example

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

The project structure is based in _Jexl Evaluator_ `1.0.1.redhat-60092` ([pom](https://maven.repository.redhat.com/ga/org/apache/aries/blueprint/org.apache.aries.blueprint.jexl.evaluator/1.0.1.redhat-60092/org.apache.aries.blueprint.jexl.evaluator-1.0.1.redhat-60092.pom), [jar + sources](https://maven.repository.redhat.com/ga/org/apache/aries/blueprint/org.apache.aries.blueprint.jexl.evaluator/1.0.1.redhat-60092/org.apache.aries.blueprint.jexl.evaluator-1.0.1.redhat-60092-sources.jar))

_Svn_ repository: `http://svn.apache.org/viewvc/aries/trunk/blueprint/blueprint-jexl-evaluator`
