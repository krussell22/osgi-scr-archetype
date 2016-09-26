FROM pavlovmedia/pavlov-felix-container:2.0.1

ADD obr/ /tmp/obr/
ADD install.gogo /tmp

WORKDIR /opt/felix/current
RUN echo -e "\nobr.repository.url=http://obr.dev.pavlovmedia.corp/obr/pavlov http://obr.dev.pavlovmedia.corp/obr/3rdParty" >> conf/config.properties
RUN java -Dhttp.proxyHost=${obr.proxy} -Dhttp.proxyPort=${obr.proxyport} -Dhttp.proxyAuth=${obr.auth} -Dgosh.args=/tmp/install.gogo -jar bin/felix.jar
