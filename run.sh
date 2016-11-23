#!/usr/bin/env bash

CLASSPATH=out/production/pcprox-java-sample:lib/*
APPNAME=App
LIBPATH=./lib
SRCPATH=src

mkdir -p $CLASSPATH
javac -d $CLASSPATH $SRCPATH/$APPNAME.java

# If you don't use LD_PRELOAD you will get hid errors thrown from pcProxAPI
LD_PRELOAD=$LIBPATH/libhidapi-hidraw.so java -Djava.library.path=$LIBPATH -Djna.library.path=$LIBPATH -classpath $CLASSPATH $APPNAME