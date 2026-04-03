FROM ubuntu:latest
LABEL authors="zakar"

ENTRYPOINT ["top", "-b"]