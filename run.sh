#!/usr/bin/env bash

OUTPUTPATH=out/production/pcprox-java-sample
CLASSPATH=out/production/pcprox-java-sample:lib/jna.jar
APPNAME=App
LIBPATH=./lib
SRCPATH=src

mkdir -p $OUTPUTPATH
javac -d $OUTPUTPATH -cp $CLASSPATH $SRCPATH/*.java

# If you don't use LD_PRELOAD you will get hid errors thrown from pcProxAPI
LD_PRELOAD=$LIBPATH/libhidapi-hidraw.so java -Djava.library.path=$LIBPATH -Djna.library.path=$LIBPATH -classpath $CLASSPATH $APPNAME