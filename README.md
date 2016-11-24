# PcProx Java Sample
[![Build Status](https://travis-ci.org/wsharp07/pcprox-java-sample.svg?branch=master)](https://travis-ci.org/wsharp07/pcprox-java-sample)

A Java console application for interacting with pcProx card readers. Tested and built on Ubuntu 16.04 64-bit.

### Prerequisites

1. See the README file in the `lib` folder for the files you will need to copy there from the pcProx SDK. More information on the SDK can be found here: https://www.rfideas.com/products/sdk/universal-enroll-sdk

### Building and running the app

```bash
sudo ./gradlew run
```

### Side notes

* You have to use `LD_PRELOAD` when running the app. I believe this to be due to a linker issue during compliation of the pcProxAPI

* You must run as root in order to connect to the reader

* Because of the complication of the pcProxAPI I had to wrap the system calls, as they needed to be referenced by symbol
