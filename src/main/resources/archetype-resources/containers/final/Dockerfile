FROM ${rootArtifactId}_base
MAINTAINER Pavlov Media <dev@pavlovmedia.com>

ADD target/lib/ /opt/felix/current/bundle/
RUN echo 'felix.cm.dir=/opt/felix/current/configs' >> /opt/felix/current/conf/config.properties
RUN mkdir -p /opt/felix/current/configs
