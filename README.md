DebugDrawer [![Build Status](https://travis-ci.org/jug6ernaut/debugdrawer.svg?branch=master)](https://travis-ci.org/jug6ernaut/debugdrawer)
===========

HEAVILY inspired/built off of JakeWharton's awesome work in [u2020](https://github.com/JakeWharton/u2020) DebugDrawer is small but highly extendable library built to allow developers to easily add a DebugDrawer to their Android applications.

Overview
========
In your applications you often need to change certain configuration settings, monitor internal state or simply try to understand what, DebugDrawer allows you to easily add a slide out drawer with the ability to do this. Classes are provided to allow you to easily create your own additions to customize to your needs.
	    
Usage
=====

	    new DebugDrawer.Builder()
			.elements("UI",
				new TelescopeElement(),
				new AnimationSpeedElement(),
				new LeakCanaryElement(),
				new RiseAndShineElement())
			.elements("Network", new NetworkWatcher(activity))
			.modules(
				new BuildModule(),
				new DeviceInfoModule(),
				new MadgeModule(),
				new ScalpelModule())
			.elements("Logs",new TimberModule())
			.bind(this);

![](vid.gif)

Download
--------

Download [the latest JAR][2] or grab via Maven:

```xml
<dependency>
  <groupId>com.jug6ernaut.debugdrawer</groupId>
  <artifactId>debugdrawer</artifactId>
  <version>0.7.0</version>
</dependency>
```
or Gradle:

```groovy
compile 'com.jug6ernaut.debugdrawer:debugdrawer:0.7.0'
```

License
-------

    Copyright 2016 William Webb

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    
    
    
[1]: http://repository.sonatype.org/service/local/artifact/maven/redirect?r=central-proxy&g=com.jug6ernaut&a=debugdrawer&v=LATEST
[2]: http://central.maven.org/maven2/com/jug6ernaut/debugdrawer/0.6.3/debugdrawer-0.6.3.aar
