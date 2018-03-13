cmake_minimum_required(VERSION 3.9)
project(phone_number_in_pi)

set(CMAKE_CXX_STANDARD 11)

add_executable(phone_number_in_pi
        out/production/phone-number-in-pi/Pi.class
        out/.keep
        src/Pi.java
        .gitignore
        phone-number-in-pi.iml
        pi.txt
        pi2.txt
        README.md src/Pi.cpp src/Pi.h)
