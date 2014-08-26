Simple archetype to get up a sample SCR project that you can modify to make your own.

Here is a sample of how to run it:

```
mvn archetype:generate -DarchetypeGroupId=com.pavlovmedia.archetypes \
-DarchetypeArtifactId=osgi-archetype \
-DgroupId=dhc.osgi \
-DartifactId=scr \
-Dversion=1.1.0
```

Once this is done you can:
```
cd scr
mvn install
mkdir -p /tmp/load
find . -name *.jar -exec cp {} /tmp/load \;
docker run -t -i -p 8080:8080 -v /tmp/load:/opt/felix/current/load sdempsay/docker-felix-jaxrs-developer
```

Now from inside the felix shell you can run sayhi, or you can hit <a HREF='http://localhost:8080/services/hello/world'>http://localhost:8080/services/hello/world</a>