FROM ubuntu:20.04
RUN apt-get update
RUN apt-get -y install \
    curl \
    unzip \
    zip \
    default-jre \
    default-jdk
RUN rm /bin/sh && ln -s /bin/bash /bin/sh
RUN apt-get -qq -y install curl
RUN curl -s https://get.sdkman.io | bash
RUN chmod a+x "$HOME/.sdkman/bin/sdkman-init.sh"
RUN source "$HOME/.sdkman/bin/sdkman-init.sh"; sdk install kotlin