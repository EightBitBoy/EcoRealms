FROM phusion/baseimage:0.9.19

CMD ["/sbin/my_init"]

RUN apt-get update && apt-get install -y \
        curl \
        gconf-service \
        lib32gcc1 \
        lib32stdc++6 \
        libasound2 \
        libc6 \
        libc6-i386 \
        libcairo2 \
        libcap2 \
        libcups2 \
        libdbus-1-3 \
        libexpat1 \
        libfontconfig1 \
        libfreetype6 \
        libgcc1 \
        libgconf-2-4 \
        libgdk-pixbuf2.0-0 \
        libgl1-mesa-glx \
        libglib2.0-0 \
        libglu1-mesa \
        libgtk2.0-0 \
        libnspr4 \
        libnss3 \
        libpango1.0-0 \
        libstdc++6 \
        libx11-6 \
        libxcomposite1 \
        libxcursor1 \
        libxdamage1 \
        libxext6 \
        libxfixes3 \
        libxi6 \
        libxrandr2 \
        libxrender1 \
        libxtst6 \
        zlib1g \
        debconf \
        npm \
        xdg-utils \
        lsb-release \
        libpq5 \
        xvfb

RUN mkdir -p /root/.cache/unity3d && \
    curl -o /tmp/unity.deb -s "http://download.unity3d.com/download_unity/linux/unity-editor-5.4.0f3+20160727_amd64.deb" && \
    dpkg --info /tmp/unity.deb && \ 
    dpkg -i /tmp/unity.deb && \
    rm /tmp/unity.deb && \
    dpkg -L unity-editor
